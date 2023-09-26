package com.order.management.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@DynamicUpdate
@DynamicInsert 
@Getter
@Setter
@Table(name = "order_management")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	public int orderId;

	@Column(name = "status")
	public String status;

	@Column(name = "email_id")
	public String emailId;

	@Column(name = "order_price")
	public BigDecimal orderPrice;

	@Column(name="product_name")
	public String producrName;
	


	

	
}
