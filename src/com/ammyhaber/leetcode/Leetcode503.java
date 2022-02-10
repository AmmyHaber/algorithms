package com.ammyhaber.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Leetcode503 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{5,2,9,9,4,6,1,3})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peek()]) {
                result[deque.pop()] = nums[i];
            }
            deque.push(i);
        }
        for (int i = 0; !deque.isEmpty() && i <= deque.peekLast(); i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peek()]) {
                result[deque.pop()] = nums[i];
            }
        }
        while (!deque.isEmpty()) {
            result[deque.pop()] = -1;
        }
        return result;
    }
}
