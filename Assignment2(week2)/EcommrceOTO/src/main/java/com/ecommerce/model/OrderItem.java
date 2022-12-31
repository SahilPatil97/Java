package com.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderItems")
public class OrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderItemId;
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
	private int quantity;
	
	public OrderItem() {
		super();
	}

	public OrderItem(int orderItemId, Product product, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.product = product;
		this.quantity = quantity;
	}

	public OrderItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", product=" + product + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderItemId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (orderItemId != other.orderItemId)
			return false;
		return true;
	}

	
	
	
	
	
	
	
	

}
