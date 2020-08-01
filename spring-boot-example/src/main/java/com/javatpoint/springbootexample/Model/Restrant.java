package com.javatpoint.springbootexample.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "RESTRAUENT_DETAILS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class Restrant implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long restaurentId;
	private String restaurentName;
	private String restaurentAddress;

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="RESTARUENT_ID")
    private List<RestaurentFood> foodDetails;
	
	public List<RestaurentFood> getFoodDetails() {
		return foodDetails;
	}

	public void setFoodDetails(List<RestaurentFood> foodDetails) {
		this.foodDetails = foodDetails;
	}

	public Restrant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getRestaurentId() {
		return restaurentId;
	}
	public void setRestaurentId(Long restaurentId) {
		this.restaurentId = restaurentId;
	}
	public String getRestaurentName() {
		return restaurentName;
	}
	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}
	public String getRestaurentAddress() {
		return restaurentAddress;
	}
	public void setRestaurentAddress(String restaurentAddress) {
		this.restaurentAddress = restaurentAddress;
	}
	
}
