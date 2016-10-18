package com.autoservice.java;
/**
 * 
 * This class work with arrays
 * 
 */
public class ArrayWorker {
	
	public Object[] resize(Object[] oldArray){ 							// Get double size of array(resizing)
		int size = oldArray.length;
		
		Object[] newArray = new Object[size * 2];
		System.arraycopy(oldArray, 0, newArray, 0, size);
		
		return newArray;
	}
//-----------------------------------------------------------------------
	public Integer countOfElements(Object[] array){						// Get amount of nor empty(non-null) elements in array 
		Integer count = 0;
		
		for(int i = 0; i < array.length; i++){
			if(array[i] != null){
				count++;
			}
		}
		return count;
	}
//-----------------------------------------------------------------------
	public void addElement(Object[] array, Object element){				// Add new element in to array
		if(countOfElements(array) == array.length){
			array = resize(array);
		}
		for(int i = 0; i < array.length; i++){
			if(array[i] == null){
				array[i] = element;
				break;
			}
		}
	}
//-----------------------------------------------------------------------
	public Object[] removeElement(Object[] array, Object object){		// Remove element from array and decrement size of array
		int size = array.length;
		int position = 0;
		Object[] newArray = new Object[size - 1];
		
		for(int i = 0; i < size; i++){
			if (!array[i].equals(object)){
				continue;
			} else {
				position = i;
				break;
			}
		}
		if(position >= 0 && position < size){
			System.arraycopy(array, 0, newArray, 0, position);
			System.arraycopy(array, position + 1, newArray, position, size - position - 1);
		}
		return newArray;
	}
//-----------------------------------------------------------------------	
	public void Show(Object[] array){									// Print all elements from array
		for(int i = 0; i < array.length; i++){
			if(array[i] != null){
				System.out.println(array[i]);
			} else {
				continue;
			}
		}
	}
//-----------------------------------------------------------------------
	/*public void getListOfEmptyElements(Object[] array){						// Get list of empty(null) elements in array 
		for(int i = 0; i < array.length; i++){
			if(array[i] == false){
				System.out.println(array[i].toString());
			}
		}
	}*/
}
