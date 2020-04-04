package com.uladkaminski.unionfind;

import static java.util.stream.IntStream.range;

public class QuickUnion implements UnionFind {
    private int[] arr;

    public QuickUnion(int n) {
        arr = new int[n];
        range(0, n).forEach(i -> arr[i] = i);
    }

    @Override
    public void union(int p, int q) {
        arr[root(p)] = root(q);
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (arr[i] != i){
            i = arr[i];
        }

        return i;
    }

}
