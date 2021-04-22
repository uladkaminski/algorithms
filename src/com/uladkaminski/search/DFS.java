package com.uladkaminski.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;


public class DFS {
    public static void dfsPrint(Node start) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> seenNodes = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            if (!seenNodes.contains(curr)) {
                seenNodes.add(curr);
                System.out.println(curr.value);
            }
            for (Node node : Arrays.asList(curr.left, curr.right)) {
                if (node != null && !seenNodes.contains(node)) {
                    stack.push(node);
                }
            }
        }
    }

    public static void main(String[] args) {
        dfsPrint(Node.getNode());
    }
}
