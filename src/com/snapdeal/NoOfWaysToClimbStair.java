package com.snapdeal;

public class NoOfWaysToClimbStair {
	
	public int waysToClimb(int numberOfStairs) {
		
		int number;
		
		if(numberOfStairs <= 0)
			return 0;
		
		if(numberOfStairs == 1) {
			number = 1;
		}
		else if(numberOfStairs ==2) {
			number = 2;
		}
		else
		number = waysToClimb(numberOfStairs-2) + waysToClimb(numberOfStairs-1);
		return number;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoOfWaysToClimbStair object = new NoOfWaysToClimbStair();
		System.out.println(object.waysToClimb(4));

	}

}
