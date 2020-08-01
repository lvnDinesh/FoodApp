package com.javatpoint.springbootexample.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.springbootexample.Model.Order;

public interface OrderDetailsRepo extends JpaRepository<Order, Long>{

}
