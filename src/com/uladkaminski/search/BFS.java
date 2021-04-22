package com.uladkaminski.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfsPrint(Node start) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> seenNodes = new HashSet<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (!seenNodes.contains(curr)) {
                seenNodes.add(curr);
                System.out.println(curr.value);
            }
            for (Node node : Arrays.asList(curr.left, curr.right)) {
                if (node != null && !seenNodes.contains(node)) {
                    queue.add(node);
                }
            }

        }
    }

    public static void main(String[] args) {

    }
}
