package com.ammyhaber.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Leetcode20 {

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        System.out.println(isValid(s1) + "|" + isValid(s2) + "|" + isValid(s3) + "|" + isValid(s4) + "|" + isValid(s5));
    }

    /**
     * 将字符串中的字符依次放入栈中。如果当次放入的元素与上一个放入的元素能够配对，那么就不放入当前元素，并把上一个元素从栈中移除。
     * 如果最后栈为空，那么就表示字符串符合有效的括号。
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> charMap = new HashMap<>(){
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            Character pre = stack.peek();
            if (pre != null && charMap.get(pre) != null && c == charMap.get(pre)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}
