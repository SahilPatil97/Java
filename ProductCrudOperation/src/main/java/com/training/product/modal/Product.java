package com.training.product.modal;

public class Product {
	
	private int prod_no;
	private String prod_name;
	private double price;
	private int quantity;
	private static int counter = 1;
	
	public Product(int prod_no, String prod_name, double price, int quantity) {
		super();
		this.prod_no = prod_no;
		this.prod_no = prod_no;
		this.prod_name = prod_name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProd_no() {
		return prod_no;
	}

	public void setProd_no(int prod_no) {
		this.prod_no = prod_no;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [prod_no=" + prod_no + ", prod_name=" + prod_name + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	

}
