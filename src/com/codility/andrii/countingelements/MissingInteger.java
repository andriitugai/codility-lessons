package com.codility.andrii.countingelements;

/*
 * This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer 
(greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting 
the storage required for input arguments).
 * 
 */

public class MissingInteger {

	public static void main(String[] args) {
		
		int[] A = {1,3,6,4,1,2};		
		System.out.println(solution(A));
		
		A = new int[] {1,2,3};
		System.out.println(solution(A));
		
		A = new int[] {-1, -3};
		System.out.println(solution(A));

	}
	
	private static int MaxElementValue  = 1_000_000;
	
	
	public static int solution(int[] A) {
		
		int[] journal = new int[MaxElementValue+1];
		
		for (int elem : A) {
			
			if(elem > 0)	journal[elem] = 1;
		}	
		
		
		for(int i = 1; i < journal.length; i++) {
			
			if( journal[i] == 0 )	return i;
		}
		
		return A.length+1;
	}

}
