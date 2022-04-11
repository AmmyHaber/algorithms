package com.ammyhaber.leetcode;

public class Leetcode200 {

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{ {'1', '1', '1', '1', '0'},
                                                    {'1', '1', '0', '1', '0'},
                                                    {'1', '1', '0', '0', '0'},
                                                    {'0', '0', '0', '0', '0'}
        }));

        System.out.println(numIslands(new char[][]{ {'1','1','0','0','0'},
                                                    {'1','1','0','0','0'},
                                                    {'0','0','1','0','0'},
                                                    {'0','0','0','1','1'}
        }));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                result++;
                dfs(grid, i, j, m, n, visited);
            }
        }
        return result;
    }

    private static void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i - 1, j, m, n, visited);
        dfs(grid, i + 1, j, m, n, visited);
        dfs(grid, i, j - 1, m, n, visited);
        dfs(grid, i, j + 1, m, n, visited);
    }
}
