package com.training.product;
import java.sql.SQLException;
import java.util.List;

import com.training.product.modal.Product;
import com.training.product.dao.DbConnection;
import com.training.product.dao.ProductDao;

public class ProductDetails {
	public static void main(String[] args) {
		try {
			final DbConnection db=DbConnection.getDb();
			final ProductDao dao=new ProductDao(db);
//			Display all products			
			showProducts(dao);
//			Find by prod_no
			System.out.println("Find Product by Product Number");
			final Product prod=dao.findOne(1);
			System.out.println(prod);
//			Create new product
			System.out.println("After New Product Registered");
			final Product newProduct=new Product(1,"Blush",000.10,5);
			if(dao.createNew(newProduct)) {
				System.out.println(newProduct+" New Product Registered ");
			}else {
				System.out.println(newProduct+" Not Registered ");
			
		}
			showProducts(dao);
			showProducts(dao);
			System.out.println("Update");
			prod.setQuantity(20);
			prod.setPrice(20000);
			if(dao.findOneAndUpdate(12,prod)) {
				System.out.println("Product Details Updated" +prod);
			}
			showProducts(dao);
			System.out.println("After Product Details Delete");
			if(dao.findOneAndDelete(1)) {
				System.out.println("Product No : 1 records deleted\n");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		private static void showProducts(ProductDao dao) throws SQLException {
			final List<Product>list = dao.findAll();
			for(Product a: list) {
				System.out.println(a);
			}
		
	}

}
