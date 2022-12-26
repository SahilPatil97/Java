package com.training.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.product.modal.Product;

public class ProductDao implements IDao<Product>{
	private DbConnection db;

	private ProductDao() {
		super();
	}

	public ProductDao(DbConnection db) {
		super();
		this.db = db;
	}
	
//	Create new product
	public boolean createNew(Product prod) throws SQLException {
		Connection connect = db.getConnection();
		final String sql = "insert into product values(?,?,?,?)";
		final PreparedStatement pStatement = connect.prepareStatement(sql);
		pStatement.setInt(1, prod.getProd_no());
		pStatement.setString(2, prod.getProd_name());
		pStatement.setDouble(3, prod.getPrice());
		pStatement.setInt(4, prod.getQuantity());
		if (pStatement.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
	public List<Product> findAll() throws SQLException {
		final List<Product> list=new ArrayList<Product>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select prod_no,prod_name,price,quantity from Product";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4)));			
		}
		return list;
	}

	public Product findOne(int id) throws SQLException {

		Connection connect = db.getConnection();
		Statement statement = connect.createStatement();
		final String sql = "select prod_no,prod_name,price,quantity from product where prod_no=" + id;
		ResultSet resultSet = statement.executeQuery(sql);
		if (resultSet.next()) {
			final Product prod = new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4));
			return prod;
		}
		return null;
	}
	
	public boolean findOneAndDelete(int id)  throws SQLException{
		final Connection connect=db.getConnection();
		final String sql="delete from product where prod_no=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}
	
	public boolean findOneAndUpdate(int id, Product prod) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update product set quantity=? , price=? where prod_no=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, prod.getQuantity());;
		pStatement.setDouble(2, prod.getPrice());;
		pStatement.setInt(3, prod.getProd_no());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}
}
