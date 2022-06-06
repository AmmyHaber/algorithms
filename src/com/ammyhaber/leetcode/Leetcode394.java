package com.ammyhaber.leetcode;

import java.util.Stack;

public class Leetcode394 {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("abc3[cd]xyz"));
        System.out.println(decodeString("100[leetcode]"));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ']') {
                process(stack);
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private static void process(Stack<Character> stack) {
        char c;
        StringBuilder sb = new StringBuilder();
        while ((c = stack.pop()) != '[') {
            sb.append(c);
        }
        StringBuilder nsb = new StringBuilder();
        char n;
        while (!stack.isEmpty() && (n = stack.peek()) >= 48 && n <= 57) {
            nsb.append(stack.pop());
        }

        int num = Integer.parseInt(nsb.reverse().toString());
        String s = sb.reverse().toString();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb2.append(s);
        }
        for (char c1 : sb2.toString().toCharArray()) {
            stack.push(c1);
        }
    }
}
