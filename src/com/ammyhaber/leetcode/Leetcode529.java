package com.ammyhaber.leetcode;

import java.util.Arrays;

public class Leetcode529 {

    public static void main(String[] args) {
        char[][] board = updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0});
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        int[][] op = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            track(board, click, op);
        }
        return board;
    }

    private static void track(char[][] board, int[] click, int[][] op) {
        if (board[click[0]][click[1]] == 'M') {
            return;
        }
        int count = 0;
        for (int[] o : op) {
            int[] next = new int[2];
            next[0] = click[0] + o[0];
            next[1] = click[1] + o[1];
            if (next[0] < 0 || next[0] > (board.length - 1) || next[1] < 0 || next[1] > (board[0].length - 1)) {
                continue;
            }
            if (board[next[0]][next[1]] == 'M') {
                count++;
            }
        }
        board[click[0]][click[1]] = count == 0 ? 'B' : (count + "").toCharArray()[0];

        if (board[click[0]][click[1]] == 'B') {
            for (int[] o : op) {
                int[] next = new int[2];
                next[0] = click[0] + o[0];
                next[1] = click[1] + o[1];
                if (next[0] < 0 || next[0] > (board.length - 1) || next[1] < 0 || next[1] > (board[0].length - 1) || board[next[0]][next[1]] != 'E') {
                    continue;
                }
                track(board, next, op);
            }
        }
    }
}
