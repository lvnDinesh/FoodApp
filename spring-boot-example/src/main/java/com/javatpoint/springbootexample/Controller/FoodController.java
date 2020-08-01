package com.javatpoint.springbootexample.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.springbootexample.CustomisedException.ResourceNotFoundException;
import com.javatpoint.springbootexample.Model.RestaurentFood;
import com.javatpoint.springbootexample.Model.Restrant;
import com.javatpoint.springbootexample.Repos.FoodDetailsRepo;
import com.javatpoint.springbootexample.Repos.RestaurentRepo;

@RestController
public class FoodController {
	
	@Autowired
	private RestaurentRepo restaurentRepo;
	
	@Autowired
	private FoodDetailsRepo foodDetailsRepo;
	
	@RequestMapping("/getfoodDetails")
	public String getFoodDetailsByrestaurentId() {
		return "biriyani";
	}
	
	@PostMapping("/saveFoodDetailsDetails/{id}")
	public void saveResturentDetails(@PathVariable(value = "id") Long restaurentId,@RequestBody Restrant foodDetails) {
		
		Restrant resturant = restaurentRepo.findById(restaurentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Restaruent", "id", restaurentId));
		
		resturant.setFoodDetails(foodDetails.getFoodDetails());
		restaurentRepo.save(resturant);
	}

}
