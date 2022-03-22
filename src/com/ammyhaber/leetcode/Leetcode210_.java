package com.ammyhaber.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode210_ {

    // 存储有向边
    private static List<List<Integer>> edges;
    // 存储节点状态 0-未搜索，1-搜索中，2-已完成
    private static int[] visited;
    // 数组模拟栈，存储拓扑排序的结果
    private static int[] result;
    // 是否是有向无环图
    private static boolean valid = true;
    // 栈的索引
    private static int index;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>(numCourses);
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;

        // 将原始数据存储成有向边
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }

        return result;
    }

    private static void dfs(int i) {
        // 标记为搜索中
        visited[i] = 1;

        // 搜索i的相邻节点
        for (Integer k : edges.get(i)) {
            if (visited[k] == 1) {
                valid = false;
                return;
            }
            if (visited[k] == 0) {
                dfs(k);
                if (!valid) {
                    return;
                }
            }
        }

        visited[i] = 2;
        result[index--] = i;
    }
}
