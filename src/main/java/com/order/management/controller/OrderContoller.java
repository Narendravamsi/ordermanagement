package com.order.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.model.DeleteOrder;
import com.order.management.model.EmailIdOrders;
import com.order.management.model.OrderRequest;
import com.order.management.model.OrderResponse;
import com.order.management.model.UpdateOrder;
import com.order.management.service.OrderService;

import jakarta.transaction.Transactional;

@RestController
public class OrderContoller {
	
	Logger log = LoggerFactory.getLogger(OrderContoller.class);
	
	
	@Autowired
	OrderService service;

	@RequestMapping(method = RequestMethod.GET, path = "get/order/byId/{orderId}")
	public OrderResponse orderDetailsById(@PathVariable Integer orderId) {
		
		log.info("Received Order ID "+orderId);

		OrderResponse order = service.orderDetailsById(orderId);

		log.debug("Response "+order);
		
		return order;
	}

	@RequestMapping(method = RequestMethod.POST, path = "insert/order/details")
	public String insertOrderDetails(@RequestBody OrderRequest request) {

		String order = service.insertOrderDetails(request);
		return order;
	}

	@RequestMapping(method = RequestMethod.PUT, path = "update/order/details/{orderId}")
	public UpdateOrder updateOrderDetails(@RequestBody UpdateOrder request, @PathVariable Integer orderId) {

		UpdateOrder order = service.updateOrderDetails(request, orderId);

		return order;
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "delete/order/details/{orderId}")
	public DeleteOrder deleteOrderDetails(@PathVariable Integer orderId) {
		DeleteOrder delete = service.deleteOrderDetails(orderId);
		return delete;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{emailId}")
	public List<EmailIdOrders> getOrderResponseDetails(@PathVariable("emailId") String emailId) {

		return service.loadOrdersByEmailId(emailId);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.DELETE, path = "/{emailId}")
	public String deleteOrdersByEmailId(@PathVariable("emailId") String emailId) {
		return service.deleteOrdersByEmailId(emailId);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/insert/user/order/details")
	public String insertOrderDetailsFromUser(@RequestBody OrderRequest request) {

		return service.insertOrderDetailsFromUser(request);
	}

	@RequestMapping(method = RequestMethod.PATCH, path = "/update/orders/{orderId}")
	public UpdateOrder updateById( @RequestBody UpdateOrder request,@PathVariable Integer orderId) {

		return service.updateById(request, orderId);

	}
}
