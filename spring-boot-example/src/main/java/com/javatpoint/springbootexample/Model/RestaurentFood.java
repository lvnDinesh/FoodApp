package com.javatpoint.springbootexample.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "ForeignKeyAssoAccountEntity")
@Table(name = "Food_DETAILS", uniqueConstraints = {
@UniqueConstraint(columnNames = "ID")})
public class RestaurentFood implements Serializable{

	private static final long serialVersionUID = -6790693372846798580L;
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer foodId;
	private String iteamName;
    private Integer foodPrice;
   
    public RestaurentFood() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
    private Restrant restrant;
    
    public Restrant getRestrant() {
		return restrant;
	}
	public void setRestrant(Restrant restrant) {
		this.restrant = restrant;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getIteamName() {
		return iteamName;
	}
	public void setIteamName(String iteamName) {
		this.iteamName = iteamName;
	}
	public Integer getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}
    
    
    
}
