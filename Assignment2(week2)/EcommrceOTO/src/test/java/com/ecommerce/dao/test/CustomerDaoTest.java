package com.ecommerce.dao.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.model.Customer;

public class CustomerDaoTest {

	private Query query;
	private Customer cust;
	private CustomerDao customerDao;

	@BeforeEach()
	public void beforeEach() {
		cust = new Customer("Trisha", 87574, "Pune");
		customerDao = new CustomerDao();
	}

	@Disabled
	@Test
	public void testRegisterCustomer() {
		Assertions.assertTrue(customerDao.register(cust));
	}

	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(customerDao.findAll());
	}

	@Disabled
	@Test
	public void testFindOneNotNull() {
		cust = customerDao.findOne(4);
		Assertions.assertNotNull(cust);
		System.out.println("\n id=4 |" + cust);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(customerDao.findOneandDelete(3));
	}

	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		cust.setCust_name("Akshay");
		cust.setAddress("Australia");
		Assertions.assertTrue(customerDao.findOneandUpdate(6, cust));
	}
}
