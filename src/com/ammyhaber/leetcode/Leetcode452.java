package com.ammyhaber.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode452 {

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
    }

    public static int findMinArrowShots(int[][] points) {
        int m = points.length;
        if (m == 1) {
            return 1;
        }
        // 根据区间的上限进行排序
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int[] pre = points[0];
        int result = 1;
        for (int i = 1; i < m; i++) {
            int[] point = points[i];
            if (pre[1] >= point[0]) {
                // 前后两个区间有重叠的部分,将重叠的部分提取出来
                pre[0] = Math.max(pre[0], point[0]);
            } else {
                pre = point;
                result++;
            }
        }
        return result;
    }
}
