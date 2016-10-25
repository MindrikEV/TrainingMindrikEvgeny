package org.senlatraining.autoservice.manager;

import java.time.LocalDate;
import org.senlatraining.autoservice.util.*;
import org.senlatraining.autoservice.util.sort.Sort;
import org.senlatraining.autoservice.api.*;
import org.senlatraining.autoservice.entity.*;

public class OrderManager implements IOrder, ICommonEntitiesManagers{
	private final String STATUS_CLOSE = "closed";
	private final String STATUS_REVOKE = "revoked";
	private final String STATUS_ACTIVE = "active";
	private final String STATUS_AT_WORK = "at work";
	
	private Path path = new Path();
	private FileWorker fileOperator = new FileWorker(path.getPathForOrder());
	private ArrayWorker arrayWorker = new ArrayWorker();
	private static Order[] listOfOrders = new Order[10];
	private MasterManager masterManager = new MasterManager();
	private GarageManager garageManager = new GarageManager();
		
	@Override
	public void add(Order order) {
		arrayWorker.addElement(listOfOrders, order);
		saveArray();
	}
//------------------------------------------------------------------
	@Override
	public void remove(Order order) {
		arrayWorker.removeElement(listOfOrders, order);
		saveArray();
	}
//------------------------------------------------------------------
	@Override
	public void closeOrder(Order order) {
		order.setStatus(STATUS_CLOSE);
		order.getMaster().setStatus(false);
		order.getGarage().setStatus(false);
		saveArray();
	}
//------------------------------------------------------------------
	@Override
	public void revokeOrder(Order order) {
		order.setStatus(STATUS_REVOKE);
		order.getMaster().setStatus(false);
		order.getGarage().setStatus(false);
		saveArray();
	}
//------------------------------------------------------------------
	@Override
	public void showListOfOrders() {
		arrayWorker.ShowList(listOfOrders);
	}
//------------------------------------------------------------------
	public void showListOfExecutableOrders(){
		for(int i = 0; i < listOfOrders.length; i++){
			if(listOfOrders[i] != null && listOfOrders[i].getStatus().equals(STATUS_AT_WORK)){
				System.out.println(listOfOrders[i].toString());
			}
		}
	}
//------------------------------------------------------------------
	public void showMasterByOrder(Order order){
		if(order.getMaster() != null){
			System.out.println(order.getMaster().getSurName());
		} else {
			System.out.println("This order don't have garage");
		}
	}
//------------------------------------------------------------------
	public void showGarageByOrder(Order order){
		if(order.getMaster() != null){
			System.out.println(order.getGarage().getIdOfGarage());
		} else {
			System.out.println("This order don't have master");
		}
	}
//------------------------------------------------------------------
	public void setMasterForOrder(Order order){
		order.setMaster(masterManager.getFreeMaster());
		saveArray();
	}
//-------------------------------------------------------------------
	public void setGarageForOrder(Order order, Garage garage){
		order.setGarage(garageManager.getFreeGarage());
		saveArray();
	}
//------------------------------------------------------------------
	public void changeDateOFComplete(Order order, String newDate){
		order.setDateOfComplete(newDate);
		saveArray();
	}
//------------------------------------------------------------------
	public void showOrdersInInterval(String startDate, String endDate){
		for(int i = 0; i < listOfOrders.length; i++){
			if(listOfOrders[i] != null){
				if((listOfOrders[i].getDateOfComplete().isAfter(LocalDate.parse(startDate))) 
				&& (listOfOrders[i].getDateOfComplete().isBefore(LocalDate.parse(endDate)))) {
					System.out.println(listOfOrders[i].toString());
				}
			}	
		}	
	}
//------------------------------------------------------------------
	public Integer getAmountOfFreeByDate(String date){
		Integer count = 0;
		Boolean f = false;
		
		for(int i = 0; i < listOfOrders.length; i++){
			if(listOfOrders[i] != null){
				if((LocalDate.parse(date).isAfter(listOfOrders[i].getDateOfRegistration()))
				&& (LocalDate.parse(date).isBefore(listOfOrders[i].getDateOfComplete())) 
				&& (listOfOrders[i].getGarage().getStatus() == f)
				&& (listOfOrders[i].getMaster().getStatus() == f)){
					count++;
				}
			}
		}
		return count;
	} 
//------------------------------------------------------------------
	public void sortListByPrice(){
		Sort sort = new Sort();
		sort.sortOrdersListByPrice(listOfOrders);
	}
//------------------------------------------------------------------	
	public void sortListByDateRegistration(){
		Sort sort = new Sort();
		sort.sortOrdersListByDateRegistration(listOfOrders);
	}
//------------------------------------------------------------------
	public void sortListByDateComplete(){
		Sort sort = new Sort();
		sort.sortOrdersByDateComplete(listOfOrders);
	}
//------------------------------------------------------------------
	public void sortListByDatePlanStart(){
		Sort sort = new Sort();
		sort.sortOrdersByDatePlanStart(listOfOrders);
	}
//------------------------------------------------------------------
	@Override
	public void saveArray(){										
		fileOperator.pushListToFile(listOfOrders);
	}
}
