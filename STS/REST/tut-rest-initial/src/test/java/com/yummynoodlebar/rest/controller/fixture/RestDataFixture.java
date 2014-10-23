package com.yummynoodlebar.rest.controller.fixture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.yummynoodlebar.rest.domain.Order;
import com.yummynoodlebar.core.events.orders.AllOrdersEvent;
import com.yummynoodlebar.core.events.orders.OrderDetails;

public class RestDataFixture {
	public static final String YUMMY_ITEM="yummy1";
	
	public static AllOrdersEvent alOrders() {
		List<OrderDetails> orders = new ArrayList<OrderDetails>();
		
		orders.add(standardOrderDetails());
		orders.add(standardOrderDetails());
		orders.add(standardOrderDetails());
		
		return new AllOrdersEvent(orders);
	}
	
	public static Order standardOrder() {
		Order order = new Order();
		
		order.setItems(Collections.singletonMap(YUMMY_ITEM, 12));
		
		return order;	
	}
	
	public static OrderDetails customKeyOrderDetails(UUID key) {
		OrderDetails orderDetails = new OrderDetails(key);
		
		orderDetails.setOrderItems(Collections.singletonMap(YUMMY_ITEM, 12));
		
		return orderDetails;
	}
	
	public static OrderDetails standardOrderDetails() {
		return customKeyOrderDetails(UUID.randomUUID());
	}
	
	public static String standardOrderJSON() {
		return  "{ \"items\": { \"yummy1\": 12, \"yummy15\": 42 } }";
	}
	
}
