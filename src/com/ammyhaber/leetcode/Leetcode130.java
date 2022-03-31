package com.ammyhaber.leetcode;

import java.util.Arrays;

public class Leetcode130 {

    public static void main(String[] args) {
//        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = new char[][]{{'X','O','X','O','X','O','O','O','X','O'},{'X','O','O','X','X','X','O','O','O','X'},{'O','O','O','O','O','O','O','O','X','X'},{'O','O','O','O','O','O','X','O','O','X'},{'O','O','X','X','O','X','X','O','O','O'},{'X','O','O','X','X','X','O','X','X','O'},{'X','O','X','O','O','X','X','O','X','O'},{'X','X','O','X','X','O','X','O','O','X'},{'O','O','O','O','X','O','X','O','X','O'},{'X','X','O','X','X','X','X','O','O','O'}};
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        solve(board);
        System.out.println();
        System.out.println();
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i, m, n);
            dfs(board, m - 1, i, m, n);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i - 1, j, m, n);
        dfs(board, i + 1, j, m, n);
        dfs(board, i, j - 1, m, n);
        dfs(board, i, j + 1, m, n);
    }

}