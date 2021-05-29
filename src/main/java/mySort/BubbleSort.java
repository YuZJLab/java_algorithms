package mySort;

import java.util.Arrays;

public class BubbleSort {

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
     * The bubble sort wrapper
     *
     * @param inputArr Input array
     */
    public static void sort(int[] inputArr) {
        sort(inputArr, 0, inputArr.length);
    }

    /**
     * The bubble sort wrapper
     *
     * @param inputArr Input array
     * @param from     Start index where you need to sort (inclusive)
     * @param to       End index where you need to sort (exclusive)
     */
    public static void sort(int[] inputArr, int from, int to) {
        int outPointer = from;
        int inPointer;
        while (outPointer < to) {
            inPointer = outPointer;
            while (inPointer > from) {
                if (inputArr[inPointer] > inputArr[inPointer - 1]) {
                    SortUtils.swap(inputArr, inPointer, inPointer - 1);
                }
                inPointer--;
            }
            outPointer++;
        }
    }
}
