package com.ammyhaber.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Leetcode3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        assert length == 3;
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> occ = new HashSet<>();

        int rk = -1, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
            occ.remove(s.charAt(i - 1));
            }

            while (rk + 1 < s.length() && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }

            ans = Math.max(ans, rk + 1 - i);
        }
        return ans;
    }
}
