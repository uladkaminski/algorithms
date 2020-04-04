package com.uladkaminski.unionfind;

import static java.util.stream.IntStream.range;

public class BalancedQuickUnion implements UnionFind {
    private int[] arr;
    private int[] sz;

    public BalancedQuickUnion(int n) {
        arr = new int[n];
        sz = new int[n];
        range(0, n).forEach(i -> arr[i] = i);
        range(0, n).forEach(i -> sz[i] = 1);
    }

    @Override
    public void union(int p, int q) {
        if (sz[p] > sz[q]) {
            arr[root(q)] = root(p);
            sz[p] += sz[q];
        } else {
            arr[root(p)] = root(q);
            sz[q] += sz[p];

        }

    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (arr[i] != i) {
            i = arr[i];
        }

        return i;
    }

}
