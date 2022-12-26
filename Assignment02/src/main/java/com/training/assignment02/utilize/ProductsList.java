package com.training.assignment02.utilize;

import com.training.assignment02.modal.Product;

public class ProductsList {
	
	public static final Product [] _products=new Product[10];
	
	static {
		
		_products[0]=new Product(101,"lenovo",100,"Available",3000);
		_products[1]=new Product(102,"Dell",150,"Available",35000);
		_products[2]=new Product(103,"HP",150,"Available",32000);
		_products[3]=new Product(104,"Asus",150,"Available",40000);
		_products[4]=new Product(105,"MAC",150,"Available",100000);
		_products[5]=new Product(106,"MI",150,"Available",52000);
		_products[6]=new Product(107,"Dell",150,"Available",48000);
		_products[7]=new Product(108,"JIO",150,"Available",46000);
		_products[8]=new Product(109,"Dell",150,"Available",66000);
		_products[9]=new Product(110,"HP",150,"Available",50000);
	}
	
	public Product[] getProducts() {
		return _products;
	}

}
