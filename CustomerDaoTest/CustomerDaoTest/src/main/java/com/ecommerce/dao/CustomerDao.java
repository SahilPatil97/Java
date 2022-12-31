package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.model.Customer;
import com.ecommerce.util.HibernateUtil;



public class CustomerDao implements IDao<Customer>{
	
	private Session session;
	private Transaction transaction;
	private Query query;
	
	public boolean register(Customer cust) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		if(session.save(cust)!=null) {
			result=true;
		}		
		transaction.commit();
		return result;
	}

	@Override
	public List<Customer> findAll() {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Customer");//select * from Customer
		final List<Customer> customerList=query.list();
		transaction.commit();
		return customerList;
	}

	@Override
	public Customer findOne(int id) {
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("from Customer c where c.cust_no="+id);//select * from customer
		final Customer cust=(Customer) query.getSingleResult();
		transaction.commit();
		return cust;
	}

	@Override
	public boolean findOneandDelete(int cust_no) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Delete from Customer c where c.cust_no=:id");
		query.setParameter("id",cust_no);
		final int statusDelete=query.executeUpdate();		
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if(statusDelete>0) {
			result=true;
		}
		return result;
	}

	@Override
	public boolean findOneandUpdate(int id, Customer cust) {
		boolean result=false;
		session=HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction=session.beginTransaction();
		query=session.createQuery("Update Customer c set c.cust_name=:cust_name, c.address=:address where cust_no=:cust_no");
		query.setParameter("cust_no",id);
		query.setParameter("cust_name",cust.getCust_name());
		query.setParameter("address", cust.getAddress());
		final int statusUpdate=query.executeUpdate();		
		transaction.commit();
		if(statusUpdate>0) {
			result=true;
		}
		return result;
	}

	
}

