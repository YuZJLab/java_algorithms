package myUnsorted;

/**
 * To get the biggest common divisor among two integer
 *
 * @author YU Zhejian
 */
public class BiggestCommonDivisor {

    /**
     * Testing scripts
     *
     * @param args Nothing
     */
    public static void main(String[] args) {
        System.out.println(euclidAlgorithm(60, 8));
        System.out.println(euclidAlgorithm(60, 80));
    }

    /**
     * To get the biggest common divisor among two integer using Euclid's algorithm
     *
     * @param m An integer
     * @param n Another integer
     * @return biggest common divisor
     */
    public static int euclidAlgorithm(int m, int n) {
        int r;
        if (m < n) {
            r = m;
            m = n;
            n = r;
        }
        while (n != 0) {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
}
