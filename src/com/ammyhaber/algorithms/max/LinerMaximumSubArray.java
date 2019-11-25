package com.ammyhaber.algorithms.max;

import java.util.Arrays;

/**
 * @author wangzhaori
 * @date 2019/11/25
 */
public class LinerMaximumSubArray {

    public static void main(String[] args) {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaximumSubArray.Result result = linerMaximumSubArray(a);
        System.out.println(result);
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, result.left, result.right + 1)));
    }

    private static MaximumSubArray.Result linerMaximumSubArray(int[] a) {
        MaximumSubArray.Result result = new MaximumSubArray.Result();
        result.left = 0;
        result.right = 0;
        result.sum = a[0];
        int temp;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > result.sum) {
                result.sum = a[i];
                result.left = i;
                result.right = i;
                continue;
            }
            MaximumSubArray.Result r = sum(a, result.left, i);
            if (r.sum > result.sum) {
                result.sum = r.sum;
                result.right = i;
                result.left = r.left;
            }
        }
        return result;
    }

    private static MaximumSubArray.Result sum(int[] a, int start, int end) {
        int leftSum = 0;
        int maxLeftSum = a[end];
        int left = end;
        for (int j = end; j >= start; j--) {
            leftSum += a[j];
            if (leftSum > maxLeftSum) {
                maxLeftSum = leftSum;
                left = j;
            }
        }
        MaximumSubArray.Result r = new MaximumSubArray.Result();
        r.left = left;
        r.right = end;
        r.sum = maxLeftSum;
        return r;
    }
}
