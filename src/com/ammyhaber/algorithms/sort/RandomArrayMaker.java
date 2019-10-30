package com.ammyhaber.algorithms.sort;

import java.util.Random;

/**
 * random array maker
 */
public class RandomArrayMaker {

    /**
     * make a random array sized 'size'
     * @param size array size
     * @return a int array sized 'size'.
     */
    public static int[] make(int size) {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(Integer.MAX_VALUE);
        }
        return arr;
    }
}
