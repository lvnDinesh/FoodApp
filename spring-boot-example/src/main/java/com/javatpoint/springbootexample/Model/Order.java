package com.javatpoint.springbootexample.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ORDER_DETAILS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class Order implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private Long restaurentId;
	private String iteamName;
	private Integer iteamQuantity;
	private Double iteamCost;
	private Boolean status;
	
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getRestaurentId() {
		return restaurentId;
	}
	public void setRestaurentId(Long restaurentId) {
		this.restaurentId = restaurentId;
	}
	public String getIteamName() {
		return iteamName;
	}
	public void setIteamName(String iteamName) {
		this.iteamName = iteamName;
	}
	public Integer getIteamQuantity() {
		return iteamQuantity;
	}
	public void setIteamQuantity(Integer iteamQuantity) {
		this.iteamQuantity = iteamQuantity;
	}
	public Double getIteamCost() {
		return iteamCost;
	}
	public void setIteamCost(Double iteamCost) {
		this.iteamCost = iteamCost;
	}

}
