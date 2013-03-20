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


import java.util.*;


public class Lego_Blocks {
    public static void main(String[] args) {
        lego(new int[][] {{10, 10},});
    }
    public static void lego(int[][] arr) {
        int width;
        double height;
        double[] P, C, N;
        for (int k = 0; k < arr.length; ++k) {
            height = arr[k][0];
            width = arr[k][1];
            P = new double[width + 1];
            C = new double[width + 1];
            N = new double[width + 1];
            // Pre-processing number of ways to build 1 * 1 * width. DP-based. 
            P[0] = 1;
            int i;
            for (i = 1; i < P.length; ++i) {
                for (int prevBlock = 1; prevBlock <= 4; ++prevBlock) {
                    if (i - prevBlock >= 0) {
                        P[i] += P[i - prevBlock];
                    } else {
                        break;
                    }
                }
            }
            for (i = 0; i <= width; ++i) {
                P[i] = Math.pow(P[i], height);
            }
            // Calculate N. DB-based. 
            for (i = 1; i < P.length; ++i) {
                for (int j = 1; j <= i - 1; ++j) {
                    C[i] += P[j] * N[i - j];
                }
                N[i] = P[i] - C[i];
            }
            print(P);
            print(C);
            print(N);
            System.out.println((int)(N[N.length - 1] % 1000000007));
        }
    }
    public static void print(double[] arr) {
        for (double i : arr) System.out.print(i + " ");
        System.out.println();
    }
}


class Count {
    public int remainder;
    public int result;
    Count(int x) {
        this.remainder = x % 1000000007;
        this.result = x / 1000000007;
    }
    public Count multiply(Count obj) {
        Count ret = new Count(0);
        ret.result = this.result * obj.result * 1000000007 + this.result * obj.remainder + this.remainder * obj.result + (this.remainder + obj.remainder) / 1000000007;
        ret.remainder = (this.remainder + obj.remainder) % 1000000007;
        return ret;
    }
    public Count add(Count obj) {
        Count ret = new Count(0);
        ret.result = this.result + obj.result + (this.remainder + obj.remainder) / 1000000007;
        ret.remainder = (this.remainder + obj.remainder) % 1000000007;
        return ret;
    }
}
