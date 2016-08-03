package com.snapdeal;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPractice {
	
	
	class Thread1 implements Runnable {

		@Override
		public void run() {
			
			Thread.currentThread().setName("thread1");
			System.out.println(Thread.currentThread().getName());
			
		}
		
	}
	
	
	class Thread2 implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Thread.currentThread().setName("thread2");
			System.out.println(Thread.currentThread().getName());
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService service = new ThreadPoolExecutor(10, 20, 2000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(1000));
		for(int i = 0; i < 100; i ++) {
		service.execute(new ThreadPractice().new Thread1());
		service.execute(new ThreadPractice().new Thread2());
		}		

	}

}
