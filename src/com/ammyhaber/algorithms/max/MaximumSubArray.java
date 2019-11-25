package com.ammyhaber.algorithms.max;

import java.util.Arrays;

/**
 * find the maximum sub array
 * @author wangzhaori
 * @date 2019/11/25
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
//        int[] a = {-13, -3, -25, -20, -3, -16, -23, -18, -20, -7, -12, -5, -22, -15, -4, -7};
        Result result = maximumSubArray(a, 0, a.length - 1);
        System.out.println(result);
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, result.left, result.right + 1)));
    }

    private static Result maximumSubArray(int[] a, int start, int end) {
        if (start == end) {
            // only one element
            Result result = new Result();
            result.left = start;
            result.right = end;
            result.sum = a[result.left];
            return result;
        }
        int mid = (start + end) / 2;
        Result leftResult = maximumSubArray(a, start, mid);
        Result rightResult = maximumSubArray(a, mid + 1, end);
        Result crossingResult = maximumCrossingSubArray(a, start, mid, end);
        if (leftResult.sum >= rightResult.sum && leftResult.sum >= crossingResult.sum) {
            return leftResult;
        } else if (rightResult.sum >= leftResult.sum && rightResult.sum >= crossingResult.sum) {
            return rightResult;
        }
        return crossingResult;
    }

    private static Result maximumCrossingSubArray(int[] a, int start, int mid, int end) {
        Result result = new Result();
        int leftSum = 0;
        int maxLeftSum = a[mid];
        int left = mid;
        for (int i = mid; i >= start; i--) {
            leftSum += a[i];
            if (leftSum > maxLeftSum) {
                maxLeftSum = leftSum;
                left = i;
            }
        }
        int rightSum = 0;
        int maxRightSum = a[mid + 1];
        int right = mid + 1;
        for (int i = mid + 1; i <= end; i++) {
            rightSum += a[i];
            if (rightSum > maxRightSum) {
                maxRightSum = rightSum;
                right = i;
            }
        }
        result.left = left;
        result.right = right;
        result.sum = maxLeftSum + maxRightSum;
        return result;
    }

    private static class Result {
        int left;
        int right;
        int sum;

        @Override
        public String toString() {
            return "Result{" +
                    "left=" + left +
                    ", right=" + right +
                    ", sum=" + sum +
                    '}';
        }
    }
}
