package com.codility.andrii.iterations;

public class Fibo {

	public static void main(String[] args) {

		Fibo fibo = new Fibo();
		
		for(int i = 0; i < 10; i++)
			System.out.println("i = " + i + "; fibo = " + fibo.fibonacci(i));
	}
	
	
	public int fibonacci(int n) {
		if( n == 0 || n == 1 ) return 1;
		
		int f1 = 1;
		int f2 = 1;
		int fc = 0;
		
		for(int i = 2; i <= n; i++) {
			fc = f1 + f2;
			f2 = f1;
			f1 = fc;
		}
		
		return fc;
	}

}
