package com.order.management.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.order.management.entity.Orders;
import com.order.management.model.DeleteOrderByEmailId;

public interface OrderRepository extends CrudRepository<Orders, Integer>{

	List<Orders> findByEmailId(String emailId);

	DeleteOrderByEmailId deleteByEmailId(String emailId);


	
}
