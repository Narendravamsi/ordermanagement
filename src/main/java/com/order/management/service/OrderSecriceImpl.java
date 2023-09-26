package com.order.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.entity.Orders;
import com.order.management.model.DeleteOrder;
import com.order.management.model.EmailIdOrders;
import com.order.management.model.OrderRequest;
import com.order.management.model.OrderResponse;
import com.order.management.model.UpdateOrder;
import com.order.management.repository.OrderRepository;

@Service
public class OrderSecriceImpl implements OrderService {

	@Autowired
	OrderRepository repo;

	@Override
	public OrderResponse orderDetailsById(Integer orderId) {

		Optional<Orders> data = repo.findById(orderId);

		Orders orders = data.get();

		OrderResponse orderResponse = new OrderResponse();

		orderResponse.setOrderId(orders.getOrderId());
		orderResponse.setEmailId(orders.getEmailId());
		orderResponse.setStatus(orders.getStatus());
		orderResponse.setOrderPrice(orders.getOrderPrice());
		orderResponse.setProductName(orders.getProducrName());

		return orderResponse;
	}

	@Override
	public String insertOrderDetails(OrderRequest request) {
		Orders order = new Orders();

		order.setEmailId(request.getEmailId());
		order.setStatus(request.getStatus());
		order.setOrderPrice(request.getOrderPrice());
		order.setProducrName(request.getProductName());

               repo.save(order);

	
		return "your details are saved";
	}

	@Override
	public UpdateOrder updateOrderDetails(UpdateOrder request, Integer orderId) {

		Optional<Orders> data = repo.findById(orderId);

		Orders order = data.get();

		order.setStatus(request.getStatus());
		order.setOrderPrice(request.getOrderPrice());
		
		order.setOrderId(orderId);

		Orders savedOrder = repo.save(order);

		
		UpdateOrder updateOrder = new UpdateOrder();

		updateOrder.setStatus(savedOrder.getStatus());
		updateOrder.setOrderPrice(savedOrder.getOrderPrice());
		updateOrder.setMessage("your order is ready for shipping");

		return updateOrder;
	}

	@Override
	public DeleteOrder deleteOrderDetails(Integer orderId) {

		repo.deleteById(orderId);

		DeleteOrder deleteOrder = new DeleteOrder();

		deleteOrder.setOrderId(orderId);
		deleteOrder.setMessage("your order details are deleted");

		return deleteOrder;
	}

	@Override
	public List<EmailIdOrders> loadOrdersByEmailId(String emailId) {

		List<Orders> listOfOrders = repo.findByEmailId(emailId);

		return mapFromOrdersToEmailIdOrders(listOfOrders);
	}

	public List<EmailIdOrders> mapFromOrdersToEmailIdOrders(List<Orders> orders) {

		List<EmailIdOrders> emailIdOrders = new ArrayList<>(); 
		
		for (Orders order : orders) {

			EmailIdOrders e = new EmailIdOrders();
			e.setOrderId(order.getOrderId());
			e.setOrderPrice(order.getOrderPrice());
			e.setStatus(order.getStatus());
			emailIdOrders.add(e);
		}
		return emailIdOrders;
	}

	@Override
	public String deleteOrdersByEmailId(String emailId) {
		repo.deleteByEmailId(emailId);
	
		
		
		return "your order is deleted";
	}

	@Override
	public String insertOrderDetailsFromUser(OrderRequest request) {
	
		Orders order = new Orders();

		order.setEmailId(request.getEmailId());
		order.setStatus(request.getStatus());
		order.setOrderPrice(request.getOrderPrice());

               repo.save(order);

		
		
		return "your details are inserted ";
	}

	@Override
	public UpdateOrder updateById(UpdateOrder request, Integer orderId) {
		
		Orders order=repo.findById(orderId).get();
		
		order.setEmailId(request.getEmailId());
		order.setOrderPrice(request.getOrderPrice());
		order.setStatus(request.getStatus());
	
		repo.save(order);
		
		UpdateOrder orderUpdate=new UpdateOrder();
		
		orderUpdate.setEmailId(order.getEmailId());
		orderUpdate.setStatus(order.getStatus());
		orderUpdate.setMessage("your details updated");
		
		return orderUpdate;
	}
	
	
	
}
