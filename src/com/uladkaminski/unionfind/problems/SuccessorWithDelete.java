package com.uladkaminski.unionfind.problems;

import java.util.stream.IntStream;

public class SuccessorWithDelete {

    private int[] successors;

    public SuccessorWithDelete(int n) {
        successors = new int[n];
        IntStream.range(0, n).forEach(i -> successors[i] = i);
    }

    public void delete(int x){
        successors[x] = x+1;
    }

    public int findSuccessor(int x) {
        return root(x);
    }

    private int root(int x) {
        int val = x;
        while (val != successors[val]){
            val = successors[val];
            successors[x] = val;
        }

        return val;
    }


}
