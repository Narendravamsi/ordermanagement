package com.order.management.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class OrderRequest {

	private String status;
	private String emailId;
	private BigDecimal orderPrice;
	private String productName;



}
