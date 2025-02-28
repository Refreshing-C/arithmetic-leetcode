package com.javabase;
public class GetSum{
	private static int sum = 0;
	private static final Object lock = new Object();
	
	public static void main(String[] args) throws Exception {
		ThreadTest t1 = new ThreadTest(0, 25);
		ThreadTest t2 = new ThreadTest(26, 50);
		ThreadTest t3 = new ThreadTest(51, 75);
		ThreadTest t4 = new ThreadTest(76, 100);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		System.out.println(sum);
	 
	}

	static class ThreadTest extends Thread{
		private final int begin;
		private final int end;
		public ThreadTest(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}

		@Override
		public void run() {
			synchronized(lock){
				for(int i = begin; i <= end; i++) {
					sum += i;
				}
			}
		}
	}
}