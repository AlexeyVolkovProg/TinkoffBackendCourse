package edu.hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Напишите функцию, которая группирует строку в кластеры, заключенные в скобки.
 * Каждый кластер должен быть сбалансированным.
 * Примеры:
 * clusterize("()()()") -> ["()", "()", "()"]
 * clusterize("((()))") -> ["((()))"]
 * clusterize("((()))(())()()(()())") -> ["((()))", "(())", "()", "()", "(()())"]
 * clusterize("((())())(()(()()))") -> ["((())())", "(()(()()))"]
 */

public class Task2 {

    private Task2() {

    }

    public static List<String> clusterize(String processedString) {
        List<String> clusters = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int indexStart = 0;

        for (int i = 0; i < processedString.length(); i++) {
            char c = processedString.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    int startIndex = stack.pop();
                    if (stack.isEmpty()) {
                        clusters.add(processedString.substring(startIndex, i + 1));
                        indexStart = i + 1;
                    }
                } else {
                    indexStart = i + 1;
                }
            }
        }
        return clusters;
    }

}
