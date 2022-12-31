package com.ecommerce.dao.test;

import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;

public class ProductDaoTest {

	private Query query;
	private Product product;
	private ProductDao productDao;

	@BeforeEach()
	public void beforeEach() {
		product = new Product("Siya", 1200.00, 12);
		productDao = new ProductDao();
	}
	@Disabled
	@Test
	public void testRegisterProduct() {
		Assertions.assertTrue(productDao.register(product));
	}

	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(productDao.findAll());
	}

	@Disabled
	@Test
	public void testFindOneNotNull() {
		product = productDao.findOne(4);
		Assertions.assertNotNull(product);
		System.out.println("\n id=4 |" + product);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productDao.findOneandDelete(3));
	}

	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		product.setProd_name("Lipstick");
		Assertions.assertTrue(productDao.findOneandUpdate(8, product));
	}
}
