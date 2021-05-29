package mySort;

import java.util.Arrays;

/**
 * Helpers to complete common options
 *
 * @author YU Zhejian
 */
public class SortUtils {
    /**
     * The testing script
     *
     * @param args Nothing
     */
    public static void main(String[] args) {
        int[] i = {1, 5, 6, 3, 2, 6, 7, 5, 5, 43, 6, 86, 4, 2};
        System.out.println(Arrays.toString(i));
        swap(i, 0, 5);
        System.out.println(Arrays.toString(i));
        insert(i, 0, 5);
        System.out.println(Arrays.toString(i));
        insert(i, 10, 5);
        System.out.println(Arrays.toString(i));
    }

    /**
     * Swap two elements in an array
     *
     * @param inputArr Input array
     * @param x        Index of the first element
     * @param y        Index of the second element
     */
    public static void swap(int[] inputArr, int x, int y) {
        if (x == y) {
            return;
        }
        int tmp = inputArr[x];
        inputArr[x] = inputArr[y];
        inputArr[y] = tmp;
    }

    /**
     * Insert element indexed from before to.
     *
     * @param inputArr Input array
     * @param from     The index of element needs to be exchanged from
     * @param to       The index where the element needs to be exchanged to
     */
    public static void insert(int[] inputArr, int from, int to) {
        int tmp = inputArr[from];
        if (from == to) {
            return;
        } else if (from < to) { // to the back
            System.arraycopy(inputArr, from + 1, inputArr, from, to - from);
        } else { // to the front
            if (from - to >= 0) System.arraycopy(inputArr, to, inputArr, to + 1, from - to);
        }
        inputArr[to] = tmp;
    }
}
