package com.autoservice.java;

public class GarageWorker implements Operation{
	//private Garage[] listOfMasters = new Garage[10];
	private final String path = "Places.txt";
	private Place[] listOfPlaces = new Place[10];
	private ArrayWorker arrayWorker = new ArrayWorker();
	private FileOperator fileOperator = new FileOperator(path);
	
	private Master[] listOfMasters = new Master[5];
	
	
	public void add(Place place) {
		arrayWorker.addElement(listOfPlaces, place);
	}
//----------------------------------------------------------
	public void remove(Place place) {
		arrayWorker.removeElement(listOfPlaces, place);
	}
//----------------------------------------------------------
	public void show() {
		arrayWorker.Show(listOfPlaces);
	}
//----------------------------------------------------------	
	public void showListOfFreePlaces(){
		for(int i = 0; i < listOfPlaces.length; i++){
			if(listOfPlaces[i] != null){
				if(listOfPlaces[i].getStatus() == false){
					System.out.println(listOfPlaces[i].toString());
				}
			}
		}
	}
//----------------------------------------------------------

//----------------------------------------------------------
}
