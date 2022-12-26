package com.training.customer_crud;

import java.sql.SQLException;
import java.util.List;

import com.training.customer.modal.Customer;
import com.training.customer.dao.CustomerDao;
import com.training.customer.dao.DbConnection;

public class CustomerDetails {
	
	public static void main(String[] args) {
		try {
			final DbConnection db=DbConnection.getDb();
			final CustomerDao dao=new CustomerDao(db);
//			Display all customers			
			showCustomers(dao);
//			Find by cust_no
			System.out.println("Find Customer by Customer Number");
			final Customer cust=dao.findOne(1);
			System.out.println(cust);
//			Create new customer
			System.out.println("After New Customer Registered");
			final Customer newCustomer=new Customer(1,"Mansi",2000000040,"Pune");
			if(dao.createNew(newCustomer)) {
				System.out.println(newCustomer+" New Customer Registered ");
			}else {
				System.out.println(newCustomer+" Not Registered ");
			
		}
			showCustomers(dao);
			showCustomers(dao);
			System.out.println("Update");
			cust.setPhone_no(95201768);
			if(dao.findOneAndUpdate(12,cust)) {
				System.out.println("Customer Details Updated" +cust);
			}
			showCustomers(dao);
			System.out.println("After Customer Details Delete");
			if(dao.findOneAndDelete(5)) {
				System.out.println("Customer No : 1 records deleted");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		private static void showCustomers(CustomerDao dao) throws SQLException {
			final List<Customer>list = dao.findAll();
			for(Customer a: list) {
				System.out.println(a);
			}
		
	}
}
