package com.ammyhaber.leetcode;

public class Leetcode7 {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
    }

    public static int reverse(int x) {
        String str = String.valueOf(x);
        String s = reverseString(str);
        boolean b = s.endsWith("-");
        if (b) {
            s = s.substring(0, s.length() - 1);
        }
        try {
            return Integer.parseInt((b ? "-" : "") + s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static String reverseString(String str) {
        char[] chars = str.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = chars.length - 1, j = 0; i >= 0 && j < chars.length; i--,j++) {
            newChars[j] = chars[i];
        }
        return String.valueOf(newChars);
    }
}
