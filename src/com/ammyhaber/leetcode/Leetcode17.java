package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 */
public class Leetcode17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backTrack(digits, map, 0, new StringBuilder(), result);
        return result;
    }

    private static void backTrack(String digits, Map<String, String> map, int index, StringBuilder sb, List<String> result) {
        if (index > digits.length() - 1) {
            result.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        String s = map.get(c + "");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backTrack(digits, map, index + 1, sb, result);
            sb.deleteCharAt(index);
        }
    }

}
