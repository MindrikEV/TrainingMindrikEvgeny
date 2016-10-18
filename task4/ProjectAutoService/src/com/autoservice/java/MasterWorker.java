package com.autoservice.java;
/**
 * This class operate with Masters
 */
public class MasterWorker{
	private final String path = "Masters.txt";
	private ArrayWorker arrayWorker = new ArrayWorker();
	private FileOperator fileOperator = new FileOperator(path);
	private Master[] listOfMasters = new Master[5];
	
	public void add(Master master){
		arrayWorker.addElement(listOfMasters, master);
	}
//------------------------------------------------------------------------------
	public void remove(Master master){
		arrayWorker.removeElement(listOfMasters, master);
	}
//------------------------------------------------------------------------------	
	public void show(){
		arrayWorker.Show(listOfMasters);
	}
//------------------------------------------------------------------------------
	public void getAmount(){
		System.out.println(arrayWorker.countOfElements(this.listOfMasters));
	}
//------------------------------------------------------------------------------
	public void saveArray(){
		fileOperator.pushListToFile(listOfMasters);
	}
}
	
	
	
	
	
	
	//------------------------------------------------------------------------------
/*	public void pushListToFile(){
		Integer size = this.listOfMasters.length;
		String[] listMasters = new String[arrayWorker.countOfElements(this.listOfMasters)];
		
		for(int i = 0; i < size; i++){
			//listMasters[i] = String.valueOf(listOfMasters[i].getStatus());
			if(listOfMasters[i] != null){
					listMasters[i] = listOfMasters[i].getFirstname()
					+ " "
					+ listOfMasters[i].getLastname() 
					+ " " 
					+ String.valueOf(listOfMasters[i].getStatus())
					+ " "
					;
			} else {
				continue;
			}
		}
		fileOperator.pushToFile(listMasters);		
	}*/
//------------------------------------------------------------------------------
/*		public void pullListFromFile(){
		Integer size = fileOperator.pullFromFile().length;
		String[] s = new String[size];
		
		for(int i=0; i < size; i++){
			//s[i] = fileOperator.pullFromFile()[i].split(" ");
			System.out.println(fileOperator.pullFromFile()[i].split(" "));
		}
		//for(int j=0; j < s.length;j++){
		//	System.out.println(s[j]);
		//}
	}
*/
