package com.codility.andrii.sorting;
/*
We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers,
specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least
one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0

There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of
intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].
 */

import java.util.Arrays;

public class NumberOfDiscIntersections {

	public static void main(String[] args) {

		int[] test1 = new int[]{1,5,2,1,4,0};

		System.out.println(new NumberOfDiscIntersections().solution(test1));
	}

	class Mark implements Comparable<Mark> {
		private int point;
		private boolean isEnd;

		Mark(int point, boolean isEnd) {
			this.point = point;
			this.isEnd = isEnd;
		}

		int getPoint() {
			return point;
		}

		boolean isEnd() {
			return isEnd;
		}

		@Override
		public int compareTo(Mark o) {
			if(this.point > o.getPoint()) return 1;
			else if(this.point == o.getPoint()) {
				if(this.isEnd)	return 1;
			}
			return -1;
		}

		@Override
		public String toString(){
			return Integer.toString(this.point).concat(isEnd?"E":"S");
		}
	}

	public int solution(int[] A){
		Mark[] marks = new Mark[2*A.length];
		for(int i = 0; i<A.length; i++){
			marks[2*i]   = new Mark(i-A[i], false);
			marks[2*i+1] = new Mark(i+A[i], true);
		}

		Arrays.sort(marks);

		int total = 0;
		int overlapped = -1;

		for(int i = 0; i<marks.length; i++){
			if(!marks[i].isEnd()) {
				overlapped +=1;
				total+= overlapped;
				if(total > 10_000_000)
					return -1;
			}
			else {
				overlapped -= 1;
			}
		}

		return total;
	}
}
