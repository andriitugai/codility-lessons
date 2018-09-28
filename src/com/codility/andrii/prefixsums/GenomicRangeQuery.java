package com.codility.andrii.prefixsums;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        char[] symbs = S.toCharArray();
        int[][] preSums = new int[3][symbs.length + 1];

        for(int idx = 0; idx < symbs.length; idx++){
            preSums[0][idx+1] = preSums[0][idx] + (symbs[idx] == 'A'? 1:0);
            preSums[1][idx+1] = preSums[1][idx] + (symbs[idx] == 'C'? 1:0);
            preSums[2][idx+1] = preSums[2][idx] + (symbs[idx] == 'G'? 1:0);
        }

        int[] result = new int[P.length];

        for(int idx = 0; idx < P.length; idx++){
            if(preSums[0][Q[idx]+1]-preSums[0][P[idx]] > 0)
                result[idx] = 1;
            else
            if(preSums[1][Q[idx]+1]-preSums[1][P[idx]] > 0)
                result[idx] = 2;
            else
            if(preSums[2][Q[idx]+1]-preSums[2][P[idx]] > 0)
                result[idx] = 3;
            else
                result[idx] = 4;
        }

        return result;
    }

}
