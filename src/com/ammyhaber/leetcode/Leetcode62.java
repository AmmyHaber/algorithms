package com.ammyhaber.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode62 {

    private static final Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(51, 9));
    }

    public static int uniquePaths(int m, int n) {
        return doCount(m, n);
    }

    private static int doCount(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        String keyA = Math.max(m - 1, n - 1) + "_" + Math.min(m - 1, n - 1);
        String keyB = Math.max(m - 2, n) + "_" + Math.min(m - 2, n);
        String keyC = Math.max(m, n - 2) + "_" + Math.min(m, n - 2);
        Integer a = cache.get(keyA);
        Integer b = cache.get(keyB);
        Integer c = cache.get(keyC);
        if (a == null) {
            a = doCount(m - 1, n - 1);
            cache.put(keyA, a);
        }
        if (b == null) {
            b = doCount(m - 2, n);
            cache.put(keyB, b);
        }
        if (c == null) {
            c = doCount(m, n - 2);
            cache.put(keyC, c);
        }
        return a * 2 + b + c;
    }
}
