package com.training.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.customer.modal.Customer;

public class CustomerDao implements IDao<Customer> {
	private DbConnection db;

	private CustomerDao() {
		super();
	}

	public CustomerDao(DbConnection db) {
		super();
		this.db = db;
	}

//	Create new customer
	public boolean createNew(Customer cust) throws SQLException {
		Connection connect = db.getConnection();
		final String sql = "insert into customer values(?,?,?,?)";
		final PreparedStatement pStatement = connect.prepareStatement(sql);
		pStatement.setInt(1, cust.getCust_no());
		pStatement.setString(2, cust.getCust_name());
		pStatement.setLong(3, cust.getPhone_no());
		pStatement.setString(4, cust.getAddress());
		if (pStatement.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
	public List<Customer> findAll() throws SQLException {
		final List<Customer> list=new ArrayList<Customer>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select cust_no,cust_name,phone_no,address from customer";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getLong(3),resultSet.getString(4)));			
		}
		return list;
	}
	
	public Customer findOne(int id) throws SQLException {

		Connection connect = db.getConnection();
		Statement statement = connect.createStatement();
		final String sql = "select cust_no,cust_name,phone_no,address from customer where cust_no=" + id;
		ResultSet resultSet = statement.executeQuery(sql);
		if (resultSet.next()) {
			final Customer cust = new Customer(resultSet.getInt(1), resultSet.getString(2),resultSet.getLong(3),resultSet.getString(4));
			return cust;
		}
		return null;
	}

	public boolean findOneAndDelete(int id)  throws SQLException{
		final Connection connect=db.getConnection();
		final String sql="delete from customer where cust_no=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	public boolean findOneAndUpdate(int id, Customer cust) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update customer set phone_no=? where cust_no=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setLong(1, cust.getPhone_no());;
		pStatement.setInt(2, cust.getCust_no());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

}
