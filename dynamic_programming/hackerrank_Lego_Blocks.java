/*Lego_Blocks
hackerrank

Sample Input:
4
2 2
3 2
2 3
4 4

Sample Output:
3
7
9
3375

Explanation:
For the first case, the possible walls are:

aa
bc

aa
bb

ab
cc

For the second case, each row of the wall can contain either two blocks of width
1, or one block of width 2. However, the wall where all rows contain two blocks
of width 1 is not a solid one as it can be divided vertically. Thus the number
of ways is 2 * 2 * 2 - 1 = 7.

PS:”aa” is one lego block of size 1 * 1 * 2, “b” and “c” are lego blocks of size 1 * 1 * 1.
*/

import java.math.BigInteger;

class Lego_Blocks {
    public static void main(String[] args) {
        lego(new int[][] {{2, 2}, {3, 2}, {2, 3}, {4, 4}, {1, 10}, {10, 10}, {20, 20}, {5, 5}});
        lego(new int[][] {{1000, 1000}});
    }
    public static void lego(int[][] arr) {
        final int modulus = 1000000007;
        final BigInteger modulusBitInt = new BigInteger("1000000007");
        int width, height;
        long[] P, N;
        BigInteger[] oneLayer;
        for (int k = 0; k < arr.length; ++k) {
            if (arr[k][0] <= 0 || arr[k][1] <= 0) {
                System.out.println(0);
                continue;
            } else if (arr[k][0] == 1) {
                System.out.println((arr[k][1] <= 4) ? 1 : 0);
                continue;
            }
            height = arr[k][0];
            width = arr[k][1];
            P = new long[width + 1];
            N = new long[width + 1];
            oneLayer = new BigInteger[width + 1];
            oneLayer[0] = new BigInteger("1");
            int i, j, prevBlock;
            for (i = 1; i <= width; ++i) {
                oneLayer[i] = new BigInteger("0");
            }
            // Pre-processing number of ways to build 1 * 1 * width. DP-based.
            for (i = 1; i < P.length; ++i) {
                for (prevBlock = 1; prevBlock <= 4; ++prevBlock) {
                    if (i - prevBlock >= 0) {
                        oneLayer[i] = oneLayer[i].add(oneLayer[i - prevBlock]);
                    } else {
                        break;
                    }
                }
            }
            for (i = 1; i < P.length; ++i) {
                P[i] = pow(oneLayer[i].mod(modulusBitInt).intValue(), height, modulus);
                N[i] = P[i];
            }
            // Calculate N. DB-based. 
            for (i = 1; i < P.length; ++i) {
                for (j = 1; j < i; ++j) {
                    N[i] -= ((N[j] * (P[i - j])) % modulus);
                    if (N[i] < 0) {
                        N[i] += modulus;
                    }
                }
            }
            System.out.println(N[N.length - 1]);
        }
    }
    public static long pow(long base, int height, int modulus) {
        // Time complexity O(log n).
        long result = 1;
        while (height > 0) {
            if ((height & 0x1) == 1) {
                // (result * tmp) % modulus = ((result % modulus) * (tmp & modulus)) % modulus
                result *= base;
                result = (result % modulus);
            }
            base *= base;
            base = base % modulus;
            height = (height >> 1);
        }
        return result;
    }
}
