package mySort;

import java.util.Arrays;

/**
 * A simple merge sort class
 *
 * @author YU Zhejian
 */
public class MergeSort {

    /**
     * The testing script
     *
     * @param args Nothing
     */
    public static void main(String[] args) {
        int[] i = {1, 5, 6, 3, 2, 6, 7, 5, 5, 43, 6, 86, 4, 2};
        System.out.println(Arrays.toString(i));
        sort(i);
        System.out.println(Arrays.toString(i));
    }


    /**
     * A smart merge sort implementation with small memory consumption
     *
     * @param inputArr Input array
     */
    public static void sort(int[] inputArr) {
        sort(inputArr, 0, inputArr.length);
    }

    /**
     * A smart merge sort worker
     *
     * @param inputArr Input array
     * @param from     Start index where you need to sort (inclusive)
     * @param to       End index where you need to sort (exclusive)
     */
    public static void sort(int[] inputArr, int from, int to) {
        if (to - from > 1) {
            int pivot = (from + to) / 2;
            sort(inputArr, from, pivot);
            sort(inputArr, pivot, to);
            int[] inputArr1 = Arrays.copyOfRange(inputArr, from, pivot);
            int[] inputArr2 = Arrays.copyOfRange(inputArr, pivot, to);
            int pointer1 = 0;
            int pointer2 = 0;
            int pointer = from;
            while (inputArr1.length > pointer1 && inputArr2.length > pointer2) {
                if (inputArr1[pointer1] > inputArr2[pointer2]) {
                    inputArr[pointer++] = inputArr1[pointer1++];
                } else {
                    inputArr[pointer++] = inputArr2[pointer2++];
                }
            }
            while (inputArr1.length > pointer1) {
                inputArr[pointer++] = inputArr1[pointer1++];
            }
            while (inputArr2.length > pointer2) {
                inputArr[pointer++] = inputArr2[pointer2++];
            }
        }
    }
}
