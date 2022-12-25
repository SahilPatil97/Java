package com.training.assignment02.controller;

import com.training.assignment02.modal.Product;

public class ProductController {

	/*public Product [] _Products;
	public ProductController(Product [] products) {
		this._Products=products;
	}*/
	
	//find By ID
	public static Product findById(Product[] _products, final int pro_id) {
		for(Product product:_products) {
			if(product.getProductID()==pro_id) {
				return product;
			}
		}
		return null;
		
	}
	
	//Find By Product Name
	public static Product findByName(Product[] _products, final String name) throws ProductNotFoundException {
		for(Product _product:_products) {
			if(_product.getProductName()==name) {
				return _product;
			}
			else
				throw new ProductNotFoundException("Product Not Found");
		}
		return null;
	}
	
	
	
		
		
	}

	

