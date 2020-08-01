package com.javatpoint.springbootexample.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.springbootexample.Model.RestaurentFood;
import com.javatpoint.springbootexample.Model.Restrant;

@Repository
public interface RestaurentRepo  extends JpaRepository<Restrant, Long> {

}
