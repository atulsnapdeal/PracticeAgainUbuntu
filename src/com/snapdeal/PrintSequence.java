package com.snapdeal;

import java.util.Scanner;
import java.util.Stack;

public class PrintSequence {
	
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String[] args) {
		PrintSequence printSequence = new PrintSequence();
		Scanner sc = new Scanner(System.in);
		int noofInputs = sc.nextInt();
		
		for(int i = 0; i<noofInputs;i++) {
			int input1 = sc.nextInt();
			if(input1 == 1) {
				int input2 = sc.nextInt();
				if(printSequence.stack2.isEmpty()) {
				printSequence.stack1.push(input2);
				printSequence.stack2.push(input2);
				}
				else {
					printSequence.stack1.push(input2);
					if(input2 > printSequence.stack2.peek()) {
						printSequence.stack2.push(input2);
					}
					
				}
			}
			
			else if(input1 ==2) {
				int removedElement = printSequence.stack1.pop();
				if(removedElement == printSequence.stack2.peek()) {
					printSequence.stack2.pop();
				}
					
			}
			else {
				System.out.println(printSequence.stack2.peek());
			}
		}

	}

}
