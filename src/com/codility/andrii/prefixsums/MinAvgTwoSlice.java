package com.codility.andrii.prefixsums;

public class MinAvgTwoSlice {

	public int solution(int[] A) {

		double minResult = 10001.0;
		double avg = 0;
		int minPosition = -1;

		for(int i = 0; i < A.length; i++){
			if(i < A.length - 1 ) {
				avg = (A[i] + A[i+1])/2.0;
				if (avg < minResult){
					minResult = avg;
					minPosition = i;
				}
			}
			if(i < A.length - 2 ) {
				avg = (A[i] + A[i+1] + A[i+2])/3.0;
				if (avg < minResult){
					minResult = avg;
					minPosition = i;
				}
			}
		}
		return minPosition;
	}
}
