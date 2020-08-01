package com.javatpoint.springbootexample.Controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.springbootexample.CustomisedException.ResourceNotFoundException;
import com.javatpoint.springbootexample.Model.Order;
import com.javatpoint.springbootexample.Model.Restrant;
import com.javatpoint.springbootexample.Repos.OrderDetailsRepo;
import com.javatpoint.springbootexample.Repos.RestaurentRepo;

@RestController
public class OrderController {
	
	@Autowired
	private OrderDetailsRepo orderDetailsRepo;
	@Autowired
	private RestaurentRepo restaurentRepo;
	
	
	@PostMapping("/saveOrderDetails/{id}")
	public void saveResturentDetails(@PathVariable(value = "id") Long restaurentId,@RequestBody List<Order> orders) {
		
		Restrant resturant = restaurentRepo.findById(restaurentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Restaruent", "id", restaurentId));

		for(Order order: orders) {
			order.setRestaurentId(restaurentId);
			orderDetailsRepo.save(order);
		}
		
	}

	@PutMapping("/updateOrder")
	public Order updateNote(@Valid @RequestBody Order orderDetails) {
		return orderDetailsRepo.save(orderDetails);
	}
	
	@GetMapping("/getOrderbyId")
	public Order getOrderById(@PathVariable(value = "id") Long orderid) {
		Order order = orderDetailsRepo.findById(orderid)
	            .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderid));
		 
		return orderDetailsRepo.getOne(orderid);
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long orderId) {
		
		orderDetailsRepo.deleteById(orderId);

	    return ResponseEntity.ok().build();
	}
	

}
