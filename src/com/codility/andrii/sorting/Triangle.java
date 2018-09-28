package com.codility.andrii.sorting;

import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		int[] test1 = new int[]{10,2,5,1,8,20};
		int[] test2 = new int[]{10,50,5,1};
		int[] test3 = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};

		System.out.println(solution(test1));
		System.out.println(solution(test2));
		System.out.println(solution(test3));

	}

	public static int solution(int[] A){
		Arrays.sort(A);

		for(int i = 0; i < A.length-2; i++){
			if((double)A[i] + (double)A[i+1] > (double)A[i+2])
				return 1;
		}
		return 0;
	}
}
