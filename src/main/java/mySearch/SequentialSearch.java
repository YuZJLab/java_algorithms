package mySearch;

import mySort.BubbleSort;

import java.util.ArrayList;
import java.util.Arrays;

public class SequentialSearch {
    /**
     * The testing script
     *
     * @param args Nothing
     */
    public static void main(String[] args) {
        int[] i = {1, 5, 6, 3, 2, 6, 7, 5, 5, 43, 6, 86, 4, 2};
        System.out.println(Arrays.toString(i));
        System.out.println(search(i, 5));
        System.out.println(Arrays.toString(searchAll(i, 5)));
        BubbleSort.sort(i);
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(searchRange(i, 5)));
        System.out.println(Arrays.toString(searchRange(i, 0)));
        System.out.println(Arrays.toString(searchRange(i, 115)));
    }

    public static int search(int[] inputArr, int target) {
        return search(inputArr, target, 0, inputArr.length);
    }

    public static int[] searchAll(int[] inputArr, int target) {
        return searchAll(inputArr, target, 0, inputArr.length);
    }

    public static int[] searchRange(int[] inputArr, int target) {
        return searchRange(inputArr, target, 0, inputArr.length);
    }

    public static int search(int[] inputArr, int target, int from, int to) {
        for (int pointer = from; pointer < to; pointer++) {
            if (inputArr[pointer] == target) {
                return pointer;
            }
        }
        return -1;
    }

    public static int[] searchAll(int[] inputArr, int target, int from, int to) {
        ArrayList<Integer> returnList = new ArrayList<>();
        for (int pointer = from; pointer < to; pointer++) {
            if (inputArr[pointer] == target) {
                returnList.add(pointer);
            }
        }
        if (returnList.size() > 0) {
            return returnList.stream().mapToInt(Integer::valueOf).toArray();
        } else {
            return new int[]{-1};
        }
    }

    public static int[] searchRange(int[] inputArr, int target, int from, int to) {
        int[] returnList = new int[]{-1, 0};
        if ((inputArr[from] <= target)) {
            return returnList;
        }
        for (int pointer = from; pointer < to - 1; pointer++) {
            returnList[0] = returnList[1];
            returnList[1] = pointer + 1;
            if ((inputArr[pointer] >= target && inputArr[pointer + 1] <= target)) {
                return returnList;
            }
        }
        returnList[0] = returnList[1];
        returnList[1]++;
        return returnList;
    }
}
