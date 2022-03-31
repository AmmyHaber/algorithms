package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {

    private static int places = 12;

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("010010"));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12) {
            return result;
        }
        dfs(s, 0, result, new StringBuilder());
        return result;
    }

    private static void dfs(String s, int index, List<String> result, StringBuilder sb) {
        if ((s.length() - index) > places) {
            return;
        }
        if (index == s.length() && places == 0) {
            result.add(sb.substring(0, sb.length() - 1));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if ((i - sb.lastIndexOf(".")) > 3) {
                return;
            }
            sb.append(s.charAt(i));
            if (Integer.parseInt(sb.substring(sb.lastIndexOf(".") + 1, sb.length())) > 255) {
                return;
            }
            sb.append('.');
            places -= 3;
            dfs(s, i + 1, result, sb);
            sb.delete(sb.lastIndexOf("."), sb.length());
            places += 3;

            if ("0".equals(sb.substring(sb.lastIndexOf(".") + 1))) {
                return;
            }
        }
    }
}
