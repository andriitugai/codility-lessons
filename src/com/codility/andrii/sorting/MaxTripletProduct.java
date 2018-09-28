package com.codility.andrii.sorting;

import java.util.Arrays;

public class MaxTripletProduct {

	public static void main(String[] args) {
		int[] test1 = new int[]{ -3,1,2,-2,5,6};
		int[] test2 = new int[]{ -3,1,2,-5,5,6};

		System.out.println(solution(test1));
		System.out.println(solution(test2));

	}

	public static int solution(int[] A) {
		// write your code in Java SE 8
		Arrays.sort(A);
		int n = A.length;

		return Integer.max(A[0]*A[1]*A[n-1], A[n-3]*A[n-2]*A[n-1]);
	}
}
