package com.autoservice.java;

public class Runner {
	public static void main(String[] args){
		Garage serviceStation = new Garage("Bosch-service", 10);		// Name + Amount of Places
		
		GarageWorker garageWorker = new GarageWorker();
		garageWorker.showListOfFreePlaces();
		
		Master master1 = new Master("Givi","Vartanov");
		Master master2 = new Master("Ivan","Grozny");
		Master master3 = new Master("Max","Pax");
		Master master4 = new Master("Tom","Cruse");
		Master master5 = new Master("Elton","John");
		Master master6 = new Master("Jesie","Pinkman");
		
		MasterWorker masterWorker = new MasterWorker();
		masterWorker.add(master1);
		masterWorker.add(master2);
		masterWorker.add(master3);
		masterWorker.add(master4);
		masterWorker.add(master5);
		masterWorker.add(master6);
		
		masterWorker.show();				// Show list of masters
		masterWorker.getAmount();
		masterWorker.saveArray();
		//masterWorker.pullListFromFile();
		
		//FileOperator fileOperator = new FileOperator("Masters.txt");
		//fileOperator.pushToFile();
		
	}
}
