package com.uladkaminski.search;

public class Node {
    public Node left;
    public Node right;
    public String value;

    public Node(Node left, Node right, String value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public static Node getNode() {
        Node node = new Node(
                new Node(
                        new Node(
                                new Node(null, null, "one"),
                                new Node(null,
                                        new Node(null, null, "two"), "three"),
                                "four"
                        ),
                        new Node(
                                new Node(null,
                                        new Node(null, null, "six"), "sevem"),
                                null, "five"), "ten")
                ,
                new Node(
                        new Node(
                                new Node(null, null, "11"),
                                new Node(null,
                                        new Node(null, null, "12"), "13"),
                                "14"
                        ),
                        new Node(
                                new Node(null,
                                        new Node(null, null, "151"), "16"),
                                null, "18"), "21"),
                "ROOT"


        );
        return node;
    }
}
