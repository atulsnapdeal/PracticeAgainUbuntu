package com.snapdeal;

public class ReverseArray {

	public static void main(String[] args) {
		
		int i = 0; 
		int[] array = {4, 1, 2, 5, 3, 6, 7};
		int leftIndex = 2;
		int rightIndex = 4;
		int tempLength = rightIndex - leftIndex + 1;
		int[] tempArray = new int[tempLength];
		for(int j = rightIndex; j >=leftIndex; j--) {
			tempArray[i] = array[j];
			i = i+1;
		}
		i = 0;
		for(int j = leftIndex;j <= rightIndex; j++) {
			array[j] = tempArray[i];
			i=i+1;
		}
		i = 0;
		while(i != array.length-1) {
			System.out.print(array[i]);
			System.out.print(" ");
			i++;
		}
		}

	}

