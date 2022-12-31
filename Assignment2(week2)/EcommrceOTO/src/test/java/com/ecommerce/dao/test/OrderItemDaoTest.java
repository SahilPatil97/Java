package com.ecommerce.dao.test;

import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecommerce.dao.OrderItemDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.Product;

public class OrderItemDaoTest {
	
	private Query query;
	private OrderItem orderItem;
	private OrderItemDao orderItemDao;
	private Product product;
	private ProductDao productDao;
	
	@BeforeEach()
	public void beforeEach() {
		productDao = new ProductDao();
		product = productDao.findOne(5);
		orderItem = new OrderItem(product, 25);
		orderItemDao = new OrderItemDao();
	}
	
	
	@Test
	public void testRegister() {
		Assertions.assertTrue(orderItemDao.register(orderItem));
	}
	
	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(orderItemDao.findAll());
	}
	
	@Disabled
	@Test
	public void testFindOneNotNull() {
		orderItem=orderItemDao.findOne(4);
		Assertions.assertNotNull(orderItem);
		System.out.println("\n id=4 |"+orderItem);
	}
	
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(orderItemDao.findOneandDelete(3));
	}
	
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		orderItem.setQuantity(10);;
		Assertions.assertTrue(orderItemDao.findOneandUpdate(3, orderItem));
	}
}
