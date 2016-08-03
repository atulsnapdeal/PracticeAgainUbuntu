package com.snapdeal;

public class Xor {
	
	public static void main(String[] args) {
		int count = 0;
		int firstNumber = 9;
		int secondNumber = 5;
		int nextXorNumber = firstNumber^secondNumber;
		System.out.println(nextXorNumber);
		String string = Integer.toBinaryString(nextXorNumber);
		System.out.println(string);
		
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == '1') {
				count++;
			}
		}
		System.out.println("no Of bits to be flipped"+ count);
	}
}
