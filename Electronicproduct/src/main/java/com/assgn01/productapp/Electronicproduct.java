package com.assgn01.productapp;
public class Electronicproduct {

	private int productNo;

	private String productName;

	private double price;

	private String productquality;

	 

	public Electronicproduct () {

	super();

	}

	// alt+s+a =>create

	 

	//Read the object

	public Electronicproduct (int productNo, String productName, double price, String productquality) {

	super();

	this.productNo = productNo;

	this.productName = productName;

	this.price = price;

	this.productquality= productquality;

	}

	 

	public String deposit(double amount) {

	return null;

	}

	 

	public String withdraw(double amount) {

	return null;

	}

	//Object to string conversion

	@Override

	public String toString() {

	return "Electronicproduct  [productno=" +productNo + ", productName=" + productName + ", price=" + price + ", productquality="+productquality+"]";

	}

	}

