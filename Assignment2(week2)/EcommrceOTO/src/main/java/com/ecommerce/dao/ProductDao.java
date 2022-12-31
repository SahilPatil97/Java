package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ecommerce.model.Product;
import com.ecommerce.util.HibernateUtil;

public class ProductDao implements IDao<Product> {

	private Session session;
	private Transaction transaction;
	private Query query;

	@Override
	public boolean register(Product prod) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(prod) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	}

	@Override
	public List<Product> findAll() {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Product");// select * from Product
		final List<Product> productList = query.list();
		transaction.commit();
		return productList;
	}

	@Override
	public Product findOne(int id) {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Product p where p.prod_no=" + id);// select * from product
		final Product prod = (Product) query.getSingleResult();
		transaction.commit();
		return prod;
	}

	@Override
	public boolean findOneandDelete(int prod_no) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from Product p where p.prod_no=:id");
		query.setParameter("id", prod_no);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean findOneandUpdate(int id, Product prod) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update Product p set p.prod_name=:prod_name where prod_no=:prod_no");
		query.setParameter("prod_no", id);
		query.setParameter("prod_name", prod.getProd_name());
		final int statusUpdate = query.executeUpdate();
		transaction.commit();
		if (statusUpdate > 0) {
			result = true;
		}
		return result;
	}

}
