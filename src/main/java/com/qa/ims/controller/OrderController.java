package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter customer id");
		Long customer_id = utils.getLong();
		Order nOrder = new OrderDAO.create(new Order(customer_id));
		LOGGER.info("Order created");
		return nOrder;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter the id of the customer");
		Long customer_id = utils.getLong();
		LOGGER.info("Please enter the id of item you want to add");
		Long item_id = utils.getLong();
		Order order = orderDAO.update(new Order(order_id, customer_id, item_id));

		LOGGER.info("Order Updated");
		return order;

	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = utils.getLong();
		return orderDAO.delete(order_id);
	}

}