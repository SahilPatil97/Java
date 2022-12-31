package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.model.OrderItem;
import com.ecommerce.util.HibernateUtil;

public class OrderItemDao implements IDao<OrderItem>{
	
	private Session session;
	private Transaction transaction;
	private Query query;
	
	@Override
	public boolean register(OrderItem orderItem) {
		boolean result=false;
		try {
			session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
			transaction=session.beginTransaction();
			if(session.save(orderItem)!=null) {
				result=true;
			}		
			transaction.commit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public List<OrderItem> findAll() {
		try {
			session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
			transaction=session.beginTransaction();
			query=session.createQuery("from OrderItem");
			final List<OrderItem> itemsList=query.list();
			return itemsList;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			transaction.commit();
		}
		return null;
	}

	@Override
	public OrderItem findOne(int id) {
		try {
			session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
			transaction=session.beginTransaction();
			query=session.createQuery("from OrderItem o where o.orderItemId="+id);
			OrderItem orderItem=(OrderItem) query.getSingleResult();
			return orderItem;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean findOneandDelete(int id) {
		try {
			session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
			transaction=session.beginTransaction();
			query=session.createQuery("delete from OrderItem o where o.orderItemId=:id");
			query.setParameter("id", id);
			final int statusDelete=query.executeUpdate();
			transaction.commit();
			if(statusDelete>0) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean findOneandUpdate(int id, OrderItem orderItem) {
		try {
			session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
			transaction=session.beginTransaction();
			query=session.createQuery("update OrderItem o set o.quantity=:odquantity where o.orderItemId=:id");
			query.setParameter("odquantity",orderItem.getQuantity());
			query.setParameter("id", id);
			final int statusUpdate=query.executeUpdate();
			transaction.commit();
			if(statusUpdate>0) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;	
	}
	
}
