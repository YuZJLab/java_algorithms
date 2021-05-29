package mySort;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {

    /**
     * The testing script
     *
     * @param args Nothing
     */
    public static void main(String[] args) {
        Random RDG = new Random();
        int[] i = RDG.ints(100, 0, 100).toArray();
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
        int k = 1;
        while (k < (to - from / 3)) {
            k = 3 * k + 1;
        }
        while (k >= 1) {
            InsertionSort.arrayInsertionSort(inputArr, from, to, k);
            k = k / 3;
        }
    }
}
