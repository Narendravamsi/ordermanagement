package com.order.management.service;

import java.util.List;

import com.order.management.entity.Orders;
import com.order.management.model.DeleteOrder;
import com.order.management.model.EmailIdOrders;
import com.order.management.model.OrderRequest;
import com.order.management.model.OrderResponse;
import com.order.management.model.UpdateOrder;

public interface OrderService {
	
	OrderResponse orderDetailsById(Integer orderId);
	String insertOrderDetails( OrderRequest request);
	
	UpdateOrder  updateOrderDetails(UpdateOrder request, Integer orderId);
    
	DeleteOrder deleteOrderDetails(Integer orderId);
	
	List<EmailIdOrders> loadOrdersByEmailId(String emailId);
	String deleteOrdersByEmailId(String emailId);
	
	String insertOrderDetailsFromUser(OrderRequest request);
	
	UpdateOrder updateById(UpdateOrder request, Integer orderId);
}
