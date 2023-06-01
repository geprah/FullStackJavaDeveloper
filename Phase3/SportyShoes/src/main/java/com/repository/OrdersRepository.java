package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	
	
	// Native Query 
	@Query(value="select * from orders o where o.emailid = :emailid", nativeQuery = true)
	public List<Orders> findOrdersByEmailId(@Param("emailid") String emailid);
		
	// Native Query 
	@Query(value="select * from orders o where o.emailid is not null", nativeQuery = true)
	public List<Orders> findAllOrders();

}