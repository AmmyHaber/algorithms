package com.ammyhaber.leetcode;

public class Leetcode79 {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean b = exist0(board, i, j, chars, 0, visited);
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist0(char[][] board, int m, int n, char[] word, int k, boolean[][] visited) {
        if (m < 0 || m > board.length - 1 || n < 0 || n > board[0].length - 1 || visited[m][n]) {
            return false;
        }
        if (board[m][n] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }

        visited[m][n] = true;

        boolean b1 = exist0(board, m - 1, n, word, k + 1, visited);
        if (b1) {
            return true;
        }
        boolean b2 = exist0(board, m + 1, n, word, k + 1, visited);
        if (b2) {
            return true;
        }
        boolean b3 = exist0(board, m, n + 1, word, k + 1, visited);
        if (b3) {
            return true;
        }
        boolean b4 = exist0(board, m, n - 1, word, k + 1, visited);
        if (b4) {
            return true;
        }

        visited[m][n] = false;

        return false;
    }
}
