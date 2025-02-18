package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)

public class OrderControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		final Long customer_id = 1l;
		final double item_cost = 10D;
		final Order created = new Order(1L, 10D);

		Mockito.when(utils.getLong()).thenReturn(customer_id);
		Mockito.when(utils.getDouble()).thenReturn(item_cost);
		Mockito.when(dao.create(created)).thenReturn(created);

//		assertEquals(created, controller.create());
//
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(utils, Mockito.times(1)).getDouble();
//		Mockito.verify(dao, Mockito.times(1)).create(created);

	}
	
	@Test
	public void testUpdate() {
	Order updated = new Order(1L, 1L, 10D);

	Mockito.when(this.utils.getLong()).thenReturn(updated.getOrder_id());
	Mockito.when(this.utils.getLong()).thenReturn(updated.getCustomer_id());
	Mockito.when(this.utils.getDouble()).thenReturn(updated.getOrderCost());
	Mockito.when(this.dao.update(updated)).thenReturn(updated);

	assertEquals(updated, this.controller.update());
//
//	Mockito.verify(this.utils, Mockito.times(1)).getLong();
//	Mockito.verify(this.utils, Mockito.times(1)).getLong();
//	Mockito.verify(this.utils, Mockito.times(1)).getDouble();
//	Mockito.verify(this.dao, Mockito.times(1)).update(updated);
}
	
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}