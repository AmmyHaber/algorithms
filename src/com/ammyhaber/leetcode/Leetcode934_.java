package com.ammyhaber.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode934_ {
    private static int[] direction = new int[]{-1,0,1,0,-1};
    private static int res = 0;

    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{{0,1},{1,0}})); // 1
        res = 0;
        System.out.println(shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}})); // 2
        res = 0;
        System.out.println(shortestBridge(new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}})); // 1
        res = 0;
        System.out.println(shortestBridge(new int[][]{{1,1,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{0,0,0,1,1},{0,0,0,1,1}})); // 3
        res = 0;
        System.out.println(shortestBridge(new int[][]{{0,1,0,0,0,0},{0,1,1,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{1,1,0,0,0,0}})); // 3
        res = 0;
        System.out.println(shortestBridge(new int[][]{{1,0,1,1,0,0,0,0,0,0},{1,1,1,1,1,1,0,0,0,0},{0,1,1,0,1,1,0,0,0,0},{0,0,1,1,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1,1,1},{0,0,0,0,0,0,1,1,1,1},{0,0,0,0,0,1,1,1,1,1}})); // 6
    }

    public static int shortestBridge(int[][] A) {
        // 1. 先 dfs 将找到的第一座桥的值全部赋值为2，并将第一座桥旁边的 0 全部插入队列中
        // 2. 再 while 循环判断队列是否为空，循环体里会判断是否发现了第二座桥；
        Queue<int[]> queue = new LinkedList<>();
        int m = A.length;
        int n = A[0].length;
        // 先 dfs，将第一座岛上所有值都该为 2
        outer:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, queue, i, j, m, n);
                    break outer;
                }
            }
        }

        // bfs 寻找下一座岛屿，遍历时将所有 0 值赋值为 2
        while (!queue.isEmpty()) {
            res++;
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                int[] root = queue.poll();
                for (int i = 0; i < direction.length-1; i++) {
                    int x1 = root[0] + direction[i];
                    int y1 = root[1] + direction[i+1];
                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n) {
                        if (A[x1][y1] == 1) {
                            return res;
                        } else if (A[x1][y1] == 2) {
                            continue;
                        }
                        A[x1][y1] = 2;
                        queue.add(new int[]{x1,y1});
                    }
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] A, Queue<int[]> queue, int x, int y, int n, int m) {
        // 插入所有为 0 的值的坐标到队列中
        // 为 1 的值就改变为 2 并且继续遍历四个方向
        // 为 2 的值就直接退出
        if (x < 0 || x == n || y < 0 || y == m || A[x][y] == 2) {
            return;
        }
        if (A[x][y] == 0) {
            queue.add(new int[]{x,y});
            return;
        }
        A[x][y] = 2;
        for (int i = 0; i < direction.length-1; i++) {
            int x1 = x + direction[i];
            int y1 = y + direction[i+1];
            dfs(A, queue, x1, y1, n, m);
        }
    }

}
