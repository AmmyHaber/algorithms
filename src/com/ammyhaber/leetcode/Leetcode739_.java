package com.ammyhaber.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode739_ {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            Integer top;
            while (!stack.isEmpty() && temperatures[i] > temperatures[top = stack.peek()]) {
                stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }
        return result;
    }
}
