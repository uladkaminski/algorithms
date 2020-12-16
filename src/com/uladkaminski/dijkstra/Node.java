package com.uladkaminski.dijkstra;

public class Node implements Comparable<Node> {

    private int cost;
    private int id;

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.cost, node.cost);
    }
}
