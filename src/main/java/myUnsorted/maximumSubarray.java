package myUnsorted;

import java.util.Arrays;

/**
 * Find the nonempty, contiguous subarray of A whose values have the largest sum. We call this contiguous subarray the maximum subarray.
 *
 * @author YU Zhejian
 */
public class maximumSubarray {
    /**
     * The testing script
     *
     * @param args Nothing
     */
    public static void main(String[] args) {
        int[] i = {1, -5, 6, -3, 2, 6, -7, -5, 5, 43, 6, -86, 4, 2};
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(bruteForceMaximumSubarray(i)));
        System.out.println(Arrays.toString(recursiveMaximumSubarray(i)));
    }

    /**
     * Wrapper of sum of a part of array
     *
     * @param inputArr Input array
     * @return The sum of this part of array
     */
    public static int arraySum(int[] inputArr) {
        return arraySum(inputArr, 0, inputArr.length);
    }

    /**
     * Sum of a part of array
     *
     * @param inputArr Input array
     * @param from     Start index where you need to sort (inclusive)
     * @param to       End index where you need to sort (exclusive)
     * @return The sum of this part of array
     */
    public static int arraySum(int[] inputArr, int from, int to) {
        int currentSum = 0;
        for (int pointer = from; pointer < to; pointer++) {
            currentSum += inputArr[pointer];
        }
        return currentSum;
    }

    /**
     * Wrapper of maximum subarray using brute force. O(n^2)
     *
     * @param inputArr Input array
     * @return An array of {from (inclusive), to (exclusive), sum}
     */
    public static int[] bruteForceMaximumSubarray(int[] inputArr) {
        return bruteForceMaximumSubarray(inputArr, 0, inputArr.length);
    }

    /**
     * Wrapper of maximum subarray using divide-and-conquer
     *
     * @param inputArr Input array
     * @return An array of {from (inclusive), to (exclusive), sum}
     */
    public static int[] recursiveMaximumSubarray(int[] inputArr) {
        return recursiveMaximumSubarray(inputArr, 0, inputArr.length);
    }

    /**
     * Maximum subarray using brute force. O(n^2)
     *
     * @param inputArr Input array
     * @param from     Start index where you need to sort (inclusive)
     * @param to       End index where you need to sort (exclusive)
     * @return An array of {from (inclusive), to (exclusive), sum}
     */
    public static int[] bruteForceMaximumSubarray(int[] inputArr, int from, int to) {
        int[] returnArr = new int[3];
        int currentSum = Integer.MIN_VALUE;
        int thisSum;
        for (int pointer1 = from; pointer1 < to; pointer1++) {
            for (int pointer2 = pointer1 + 1; pointer2 < to; pointer2++) {
                thisSum = arraySum(inputArr, pointer1, pointer2);
                if (thisSum >= currentSum) {
                    returnArr[0] = pointer1;
                    returnArr[1] = pointer2;
                    currentSum = thisSum;
                }
            }
        }
        returnArr[2] = currentSum;
        return returnArr;
    }

    /**
     * Maximum subarray using divide-and-conquer
     *
     * @param inputArr Input array
     * @param from     Start index where you need to sort (inclusive)
     * @param to       End index where you need to sort (exclusive)
     * @return An array of {from (inclusive), to (exclusive), sum}
     */
    public static int[] recursiveMaximumSubarray(int[] inputArr, int from, int to) {
        if (to - from == 1) {
            return new int[]{from, to, inputArr[from]};
        } else {
            int pivot = (from + to) / 2;
            int[] candidate1 = recursiveMaximumSubarray(inputArr, from, pivot); // left
            int[] candidate2 = recursiveMaximumSubarray(inputArr, pivot, to); // right
            int[] candidate3 = new int[]{pivot - 1, pivot, Integer.MIN_VALUE}; // middle
            // Following script will find crossing maximum subarray
            int tmpSum = 0;
            int lSum = Integer.MIN_VALUE;
            for (int lPointer = pivot - 1; lPointer >= from; lPointer--) {
                tmpSum += inputArr[lPointer];
                if (tmpSum >= lSum) {
                    lSum = tmpSum;
                    candidate3[0] = lPointer;
                }
            }
            int rSum = Integer.MIN_VALUE;
            tmpSum = 0;
            for (int rPointer = pivot; rPointer < to; rPointer++) {
                tmpSum += inputArr[rPointer];
                if (tmpSum >= rSum) {
                    rSum = tmpSum;
                    candidate3[1] = rPointer;
                }
            }
            candidate3[2] = lSum + rSum;
            candidate3[1]++;
            if (candidate1[2] > candidate2[2] && candidate1[2] > candidate3[2]) {
                return candidate1;
            } else if (candidate2[2] > candidate1[2] && candidate2[2] > candidate3[2]) {
                return candidate2;
            } else {
                return candidate3;
            }
        }
    }
}
