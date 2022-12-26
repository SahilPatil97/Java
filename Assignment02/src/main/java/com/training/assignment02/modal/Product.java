package com.training.assignment02.modal;

public class Product {
	private static int counter=1000;
	private int productID;
	private String productName;
	private int productQuantity;
	private String productDesc;
	private double productPrice;
	
	public Product() {
		super();
	}
	public Product(String name,int quantity,String desc,double price) {
		super();
		this.productID=this.counter++;
		this.productName=name;
		this.productQuantity=quantity;
		this.productDesc=desc;
		this.productPrice=price;
	}
	public Product(int id,String name,int quantity,String desc,double price) {
		super();
		this.productID=id;
		this.productName=name;
		this.productQuantity=quantity;
		this.productDesc=desc;
		this.productPrice=price;
	}
	public int getProductID() {
		return this.productID;
	}
	public void setProductID(int id) {
		this.productID=id;
	}
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String value) {
		this.productName=value;
	}
	public int getProductQuantity() {
		return this.productQuantity;
	}
	public void setProductQuantity(int value) {
		this.productQuantity=value;
	}
	public String getProductDesc() {
		return this.productDesc;
	}
	public void setProductDesc(String value) {
		this.productDesc=value;
	}
	public double getProductPrice() {
		return this.productPrice;
	}
	public void setProductPrice(double value) {
		this.productPrice=value;
	}
	
	/*@Override
	public String toString() {
		return "Product ID "+this.productID +" Product Name "+this.productName +" Product Price "+this.productPrice +" Added";
	}*/
}
