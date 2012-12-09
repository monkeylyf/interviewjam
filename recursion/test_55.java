/*Given an infinite number of quarters (25 cents), dimes (10 cents), nickels
(5 cents) and pennies (1 cent), write code to calculate the number of ways
of representing n cents.

dynamic programming:
C(n) = C(25 cents) + C(no 25 cents)
C(no 25 cents) = C(10 cents) + C(no 10 cents)
...
*/

import java.util.*;

class test_55 {
	public static void main(String[] args) {
        //coinChange(100);
        my(100, new int[] {25, 10, 5, 1});
	}
    // Dynamic programming.
    public static void my(int val, int[] set) {
        ArrayList<int[]> sol = new ArrayList<int[]>();
        int[] count = new int[set.length];
        nextCoin(val, set, 0, sol, count);
        System.out.println("Total # of solutions are: " + sol.size());
    }
    public static void nextCoin(int val, int[] set, int index, ArrayList<int[]> sol, int[] count) {
        if (set[index] == 1 || val == 0) {
            if (set[index] == 1) count[index] = val;
            sol.add(count);
            for (int j : count) System.out.print(j + ", ");
            System.out.println("");
            count[index] = 0;
        } else {
            nextCoin(val, set, index + 1, sol, count);
            for (int i = 1; i <= val / set[index]; ++ i) {
                count[index] += 1;
                nextCoin(val - i * set[index], set, index + 1, sol, count);
            }
            count[index] = 0;
        }
    }
    // Stupidest way.
    public static void coinChange(int val) {
        ArrayList<int[]> solution = new ArrayList<int[]>();
        for (int i = 0; i <= val / 1; ++i) {
            for (int j = 0; j <= val / 5; ++j) {
                for (int k = 0; k <= val / 10; ++k) {
                    for (int h = 0; h <= val / 25; ++h) {
                        if ((i * 1 + j * 5 + k * 10 + h * 25) == val) solution.add(new int[] {i, j, k, h});
                    }
                }
            }
        }
        int count = 0;
        for (int[] sol : solution) {
            ++count;
            System.out.print(sol[0] + "; " + sol[1] + "; " + sol[2] + "; " + sol[3]);
            System.out.println("");
        }
        System.out.println("Total # of solutions are: " + count);
    }
}
