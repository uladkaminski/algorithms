package com.uladkaminski.unionfind.problems;


import java.time.LocalDateTime;
import java.util.Random;

import static java.util.stream.IntStream.range;

public class SocialNetworkConnectivity {
    private int[] ids;
    private int[] sz;
    private int rootsCount;

    public int getRootsCount() {
        return rootsCount;
    }

    public SocialNetworkConnectivity(int n) {
        rootsCount = n;
        ids = new int[n];
        sz = new int[n];
        range(0, n).forEach(i -> ids[i] = i);
        range(0, n).forEach(i -> sz[i] = 1);
    }

    public void union(int p, int q) {

        int qRoot = root(q);
        int pRoot = root(p);

        if (qRoot != pRoot) {
            rootsCount--;
            if (sz[p] > sz[q]) {
                ids[qRoot] = pRoot;
                sz[p] += sz[q];
            } else {
                ids[pRoot] = qRoot;
                sz[q] += sz[p];
            }
        }

    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (ids[i] != i) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    public LocalDateTime findTheTimeWhereAllMembersAreConnected() {
        int count = this.ids.length;

        if (count == 1) {
            return LocalDateTime.now();
        }

        Friendship friendship = null;
        while (count != 1) {
            friendship = Friendship.generateFriendship(this.ids.length);
            this.union(friendship.getaId(), friendship.getbId());
            count = this.getRootsCount();
        }

        return friendship.getLocalDateTime();
    }

    private static class Friendship {
        private int aId;
        private int bId;
        private LocalDateTime localDateTime;

        private Friendship(int n) {
            Random random = new Random();
            this.aId = random.nextInt(n);
            this.bId = random.nextInt(n);
            this.localDateTime = LocalDateTime.now();
        }

        static Friendship generateFriendship(int n) {
            return new Friendship(n);
        }

        public int getaId() {
            return aId;
        }

        public int getbId() {
            return bId;
        }

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }
    }

}
