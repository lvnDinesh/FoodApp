package com.javatpoint.springbootexample.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.springbootexample.Model.RestaurentFood;

public interface FoodDetailsRepo extends JpaRepository<RestaurentFood, Long>{

}
