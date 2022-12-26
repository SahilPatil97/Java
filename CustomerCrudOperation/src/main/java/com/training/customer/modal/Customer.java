package com.training.customer.modal;

public class Customer {
		
	private int cust_no;
	private String cust_name;
	private long phone_no;
	private String address;
	private static int counter = 1;
	
	public Customer(int cust_no, String cust_name, long phone_no, String address) {
		super();
		this.cust_no=counter++;
		this.cust_no=cust_no;
		this.cust_name = cust_name;
		this.phone_no = phone_no;
		this.address = address;
	}
	
	public int getCust_no() {
		return cust_no;
	}
	public void setCust_no(int cust_no) {
		this.cust_no = cust_no;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [Cust_no =" +cust_no+" custName = "+cust_name+ " phone_no ="+phone_no+" address = "+address+"]";
	}
	
}
