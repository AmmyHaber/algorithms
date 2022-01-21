package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{15, 18}, new int[]{8, 10}};
        int[][] merged = merge(intervals);
        for (int[] ints : merged) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        // 先排序，根据start排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            }
            return o1[0] == o2[0] ? 0 : -1;
        });
        List<int[]> result = new ArrayList<>();
        int k = 0;
        int[] arr = Arrays.copyOfRange(intervals[0], 0, 2);
        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            if (arr[1] < tmp[0]) {
                // 不能合并
                result.add(Arrays.copyOfRange(arr, 0, 2));
                arr[0] = tmp[0];
                arr[1] = tmp[1];
                k++;
            } else {
                arr[0] = Math.min(arr[0], tmp[0]);
                arr[1] = Math.max(arr[1], tmp[1]);
            }
        }
        result.add(Arrays.copyOfRange(arr, 0, 2));
        return result.toArray(new int[result.size()][2]);
    }
}
