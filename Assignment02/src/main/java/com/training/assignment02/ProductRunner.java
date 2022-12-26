package com.training.assignment02;

import com.training.assignment02.controller.ProductController;
import com.training.assignment02.modal.Product;
import com.training.assignment02.utilize.ProductsList;

public class ProductRunner {

	public static void main(String[] args) {
		ProductsList _productList=new ProductsList();
		final int id1=104;
		final int id2=103;
		final String prodName="lenovo";
		Product[] _products=new Product[10];
		_products=_productList.getProducts();
		try {
			
			//List of products
			for(Product product:_products) {
				System.out.println(product.getProductID()+"  "+"ProductName: "+product.getProductName()+" Product Quantity : "+product.getProductQuantity()+" Product Price : "+product.getProductPrice());
			}
			System.out.println("==========================================================");
			
			//find by Product ID
			Product _product=ProductController.findById(_products,id1);
			System.out.println("Find By Product ID :"+"Product Id "+_product.getProductID()+" ProductName: "+_product.getProductName());
			
			System.out.println("==========================================================");
			
			//Find By ProductName
			Product _product1=ProductController.findByName(_products,prodName);
			System.out.println("Find By Product Name :"+"Product Id "+_product1.getProductID()+" ProductName: "+_product1.getProductName());
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}
	
	
	

}
