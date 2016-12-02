package org.senlatraining.autoservice.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.senlatraining.autoservice.manager.OrderManager;
import org.senlatraining.autoservice.util.IdMaker;

public class Order implements Cloneable, Serializable{

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Order.class);
	private Integer id;
	private Double price;
	private String description;
	private String status;
	private LocalDate dateOfRegistration;
	private LocalDate dateOfComplete;
	private LocalDate dateOfPlanStart;
	private Master master;
	private Garage garage;
	private IdMaker idMaker = new IdMaker();
	
	public Order(String description, Double price, String planStartDay, String completeDay){
		this.description = description;
		this.price = price;
		this.id = idMaker.getIdOfOrders();
		this.status = "active";
		this.dateOfRegistration = LocalDate.now();
		setDateOfPlanStart(planStartDay);
		setDateOfComplete(completeDay);
		
	}

	@Override 
	public Order clone(){
		Order order = null;
		try{
			order = (Order) super.clone(); 
		} catch (CloneNotSupportedException cnse){
			log.error(cnse);
		}
		return order;
	}
//-----------------------------------------------------------------
	public void setDateOfRegistration(String date){
		this.dateOfRegistration = LocalDate.parse(date);
	}
//-----------------------------------------------------------------
	public void setPrice(Double price){
		this.price = price;
	}
//-----------------------------------------------------------------
	public Double getPrice(){
		return this.price;
	}
//-----------------------------------------------------------------
	public void setDescription(String description){
		this.description = description;
	}
//-----------------------------------------------------------------
	public String getDescription(){
		return this.description;
	}
//-----------------------------------------------------------------
	public Integer getId(){
		return id;
	}
//-----------------------------------------------------------------
	public void setId(Integer id){
		this.id = id;
	}	
//-----------------------------------------------------------------
	public void setStatus(String status){
		this.status = status;
	}
//-----------------------------------------------------------------
	public String getStatus(){
		return this.status;
	}
//-----------------------------------------------------------------
	public LocalDate getDateOfRegistration(){
		return this.dateOfRegistration;
	}
//-----------------------------------------------------------------
	public LocalDate getDateOfComplete(){
		return this.dateOfComplete;
	}
//-----------------------------------------------------------------
	public void setDateOfComplete(String dateOfComplete){
		this.dateOfComplete = LocalDate.parse(dateOfComplete);
	}
//-----------------------------------------------------------------
	public LocalDate getDateOfPlanStart(){
		return this.dateOfPlanStart;
	}
//-----------------------------------------------------------------
	public void setDateOfPlanStart(String dateOfPlanStart){
		this.dateOfPlanStart = LocalDate.parse(dateOfPlanStart);
	}
//-----------------------------------------------------------------	
	public void setMaster(Master master){
		this.master = master;
		//master.setOrder(this.order);
	}
//-----------------------------------------------------------------
	public void setGarage(Garage garage){
		this.garage = garage;
	}
//-----------------------------------------------------------------
	public Master getMaster(){
		return this.master;
	}
//-----------------------------------------------------------------
	public Garage getGarage(){
		return this.garage;
	}	
//-----------------------------------------------------------------
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append(getId());
		s.append("|");
		s.append(getDescription());
		s.append("|");
		s.append(getPrice());
		s.append("|");
		s.append(getStatus());
		s.append("|");
		s.append(dateOfRegistration);
		s.append("|");
		s.append(dateOfPlanStart);
		s.append("|");
		s.append(dateOfComplete);

		return s.toString();
	}
}