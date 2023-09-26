package com.order.management.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class OrderResponse {

	private int orderId;
	private String status;
	private String emailId;
	private String productName;
	private BigDecimal orderPrice;



}
