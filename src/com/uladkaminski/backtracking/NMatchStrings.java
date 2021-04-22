package com.uladkaminski.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NMatchStrings {

    public static void main(String[] args) {
        List<String> strings = new NMatchStrings().generateParentheses(1);
        System.out.println(strings);
        System.out.println("=====================");


        List<String> strings2 = new NMatchStrings().generateParentheses(4);
        System.out.println(strings2);
    }
    public List<String> generateParentheses(int numPairs) {
        List<String> result = new ArrayList<>();

        directedGenerateBalancedParentheses(numPairs, numPairs, "", result); // kick off the recursion

        return result;
    }

    private void directedGenerateBalancedParentheses(
            int numLeftParensNeeded,
            int numRightParensNeeded,
            String parenStringInProgress,
            List<String> result
    ) {

        if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
            result.add(parenStringInProgress);
            return;
        }


        if (numLeftParensNeeded > 0) {

            directedGenerateBalancedParentheses(
                    numLeftParensNeeded - 1,
                    numRightParensNeeded,
                    parenStringInProgress + "(",
                    result
            );
        }

        if (numLeftParensNeeded < numRightParensNeeded) {
            directedGenerateBalancedParentheses(
                    numLeftParensNeeded,
                    numRightParensNeeded - 1,
                    parenStringInProgress + ")",
                    result
            );
        }
    }
}
