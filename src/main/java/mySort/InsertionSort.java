package mySort;

import mySearch.SequentialSearch;

import java.util.Arrays;
// import java.util.Collections;
// import java.util.LinkedList;
// import java.util.stream.Collectors;
// To convert from and to linked lists
//        LinkedList<Integer> inputLL = Arrays.stream(inputArr).boxed().collect(Collectors.toCollection(LinkedList::new));
//
//        inputArr=inputLL.stream().mapToInt(Integer::valueOf).toArray();

public class InsertionSort {

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
     * The insertion sort wrapper
     *
     * @param inputArr Input array
     */
    public static void sort(int[] inputArr) {
        sort(inputArr, 0, inputArr.length);
    }

    /**
     * The insertion sort wrapper
     *
     * @param inputArr Input array
     * @param from     The index of element needs to be exchanged from
     * @param to       The index where the element needs to be exchanged to
     */
    public static void sort(int[] inputArr, int from, int to) {
        arrayInsertionSort(inputArr, from, to);
    }

    /**
     * The insertion sort using arrays, a pointer to current stable version
     *
     * @param inputArr Input array
     * @param from     The index of element needs to be exchanged from
     * @param to       The index where the element needs to be exchanged to
     */
    public static void arrayInsertionSort(int[] inputArr, int from, int to) {
        arrayInsertionSort(inputArr, from, to, 1);
    }

    /**
     * The insertion sort using arrays, a pointer to current stable version
     *
     * @param inputArr Input array
     * @param from     The index of element needs to be exchanged from
     * @param to       The index where the element needs to be exchanged to
     * @param k        The step length when using Shell sort
     */
    public static void arrayInsertionSort(int[] inputArr, int from, int to, int k) {
        for (int pointer = from; pointer < to; pointer += k) {
            int newpos = SequentialSearch.searchRange(inputArr, inputArr[pointer], from, pointer)[1];
            SortUtils.insert(inputArr, pointer, newpos);
        }
    }
}
