package com.autoservice.java;

public class OrderWorker implements Operation{
	private Order[] listOfOrders = new Order[10];
	
	public void add(Order order) {
		ArrayWorker.addElement(listOfOrders, order);
	}
//------------------------------------------------------------------
	public void remove(Order order) {
		ArrayWorker.removeElement(listOfOrders, order);
	}
//------------------------------------------------------------------
	public void show() {
		
	}
}
