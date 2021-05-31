package myUnsorted;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * Generate a list of prime numbers from 2 to a specific value
 *
 * @author YU Zhejian
 */
public class PrimeGenerator {
    /**
     * Test cases
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(stupidSieveOfEratosthenesPrimeList(3)));
        System.out.println(Arrays.toString(smartSieveOfEratosthenesPrimeList(3)));
        System.out.println(Arrays.toString(stupidSieveOfEratosthenesPrimeList(100)));
        System.out.println(Arrays.toString(smartSieveOfEratosthenesPrimeList(100)));
    }

    /**
     * Get the last non-zero index in an array
     *
     * @param inputArr Input array
     * @return Index
     */
    public static int getLastNZero(int[] inputArr) {
        for (int i = inputArr.length - 1; i >= 0; i--) {
            if (inputArr[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get the first non-zero index in an array
     *
     * @param inputArr Input array
     * @return Index
     */
    public static int getFirstNZero(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Generate a list of prime numbers from 2 to a specific value
     *
     * @param to Generate until...?
     * @return Generated prime numbers
     */
    public static int[] stupidSieveOfEratosthenesPrimeList(int to) {
        int[] inputArr = new int[to];
        LinkedList<Integer> returnLL = new LinkedList<Integer>();
        for (int i = 0; i < to; i++) {
            inputArr[i] = i;
        }
        inputArr[1] = 0;
        int eliminator = 2; // Eliminator
        int lastNum = getLastNZero(inputArr);
        int eliminationNum;
        while (eliminator <= lastNum) {
            eliminationNum = eliminator;
            returnLL.add(eliminator);
            // System.out.println(eliminator);
            while (eliminationNum <= lastNum) {
                inputArr[eliminationNum] = 0;
                eliminationNum += eliminator;
            }
            eliminator = getFirstNZero(inputArr);
            if (eliminator == -1) {
                break;
            }
            lastNum = getLastNZero(inputArr);
        }
        return returnLL.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * Generate a list of prime numbers from 2 to a specific value
     *
     * @param to Generate until...?
     * @return Generated prime numbers
     */
    public static int[] smartSieveOfEratosthenesPrimeList(int to) {
        int[] inputArr = new int[to];
        for (int i = 0; i < to; i++) {
            inputArr[i] = i;
        }
        inputArr[1] = 0;
        int eliminator = 2; // Eliminator
        int lastNum = getLastNZero(inputArr);
        int eliminationNum;
        while (eliminator <= Math.sqrt(lastNum)) {
            if (inputArr[eliminator] == 0) {
                eliminator++;
                continue;
            }
            eliminationNum = eliminator * eliminator;
            // System.out.println(eliminator+","+eliminationNum);
            while (eliminationNum <= lastNum) {
                // System.out.println(eliminationNum+","+inputArr[eliminationNum] +"=0");
                inputArr[eliminationNum] = 0;

                eliminationNum += eliminator;
            }
            eliminator++;
            lastNum = getLastNZero(inputArr);
        }
        return Arrays.stream(inputArr).filter(x -> x != 0).toArray();
    }
}
