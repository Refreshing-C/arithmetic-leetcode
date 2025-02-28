package com.javabase;

public class PalinDromeNumber {

	public static void main(String[] args) {
		int N = 100, M = 10000;
		getPlinDromeNumber(N, M);
	}

	private static void getPlinDromeNumber(int n, int m) {
		for(int i = n; i < m; i++) {
			if(String.valueOf(i).equals(new StringBuffer(i+"").reverse().toString())) {
				char[] ch = String.valueOf(i).toCharArray();
				int sum = 0;
				for (char c : ch) {
					sum += c - '0';
				}
				if(sum == 30) {
					System.out.println(i);
				}
			}
		}
	}
}
