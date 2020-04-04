package com.uladkaminski.unionfind;

import static java.util.stream.IntStream.range;

public class QuickFind implements UnionFind {

    private int[] arr;

    public QuickFind(int n) {
        arr = new int[n];
        range(0, n).forEach(i -> arr[i] = i);
    }

    @Override
    public void union(int p, int q) {
        int pid = arr[p];
        int qid = arr[q];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pid) {
                arr[i] = qid;
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return arr[p] == arr[q];
    }
}
