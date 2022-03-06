package com.ammyhaber.leetcode;

public class Leetcode63 {

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; ++i) {
            if (obstacleGrid[i][0] == 1) {
                f[i][0] = 0;
            } else {
                f[i][0] = f[i - 1][0];
            }
        }
        for (int j = 1; j < n; ++j) {
            if (obstacleGrid[0][j] == 1) {
                f[0][j] = 0;
            } else {
                f[0][j] = f[0][j - 1];
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
