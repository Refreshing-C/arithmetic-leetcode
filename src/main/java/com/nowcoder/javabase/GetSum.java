package com.nowcoder.javabase;
public class GetSum{
	private static int sum = 0;
	private static Object lock = new Object();
	
	public static void main(String[] args) throws Exception {
		GetSum gs = new GetSum();
		ThreadTest t1 = gs.new ThreadTest(0, 25);
		ThreadTest t2 = gs.new ThreadTest(26, 50);
		ThreadTest t3 = gs.new ThreadTest(51, 75);
		ThreadTest t4 = gs.new ThreadTest(76, 100);
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
	
	class ThreadTest extends Thread{
		private int begin;
		private int end;
		public ThreadTest(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
		
		@Override
		public void run() {
			synchronized(lock){
				for(int i = begin; i <= end; i++) {
					GetSum.this.sum += i;
				}
			}
		}
	}
}