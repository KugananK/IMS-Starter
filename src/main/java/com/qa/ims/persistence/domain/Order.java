package com.qa.ims.persistence.domain;

import java.util.List;

public class Order {

	private long order_id;
	private long customer_id;
	private List<Item> items;
	private double orderCost;

	public Order(long order_id, long customer_id, List<Item> items, double orderCost) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.items = items;
		this.orderCost = orderCost;
	}

	public Order(long order_id, long customer_id, List<Item> items) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.items = items;
	}

	public Order(long order_id, long customer_id) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
	}

	public Order(long customer_id, List<Item> items, double orderCost) {
		super();
		this.customer_id = customer_id;
		this.items = items;
		this.orderCost = orderCost;
	}

	public Order(long customer_id) {
		super();
		this.customer_id = customer_id;
	}

	public Order(long customer_id, List<Item> items) {
		super();
		this.customer_id = customer_id;
		this.items = items;
	}

	
	public Order(long customer_id, double orderCost) {
		super();
		this.customer_id = customer_id;
		this.orderCost = orderCost;
	}
	
	

	public Order(long order_id, long customer_id, double orderCost) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.orderCost = orderCost;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", items=" + items + ", orderCost="
				+ orderCost + "]";
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customer_id ^ (customer_id >>> 32));
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		long temp;
		temp = Double.doubleToLongBits(orderCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (order_id ^ (order_id >>> 32));
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
		Order other = (Order) obj;
		if (customer_id != other.customer_id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (Double.doubleToLongBits(orderCost) != Double.doubleToLongBits(other.orderCost))
			return false;
		if (order_id != other.order_id)
			return false;
		return true;
	}
	

}
