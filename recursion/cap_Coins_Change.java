/*Coins_Change

Given an infinite number of quarters (25 cents), dimes (10 cents), nickels
(5 cents) and pennies (1 cent), write code to calculate the number of ways
of representing n cents.

FOLLOWUP
What are those ways of representing n cents?

dynamic programming:
C(n) = C(25 cents) + C(no 25 cents)
C(no 25 cents) = C(10 cents) + C(no 10 cents)
...
*/

import java.util.*;

class cap_Coins_Change {
	public static void main(String[] args) {
        System.out.println(my(100, new int[] {25, 10, 5, 1}));
	}
    public static int my(int val, int[] set) {
        // Dynamic programming based solution.
        int[] table = new int[val + 1];
        table[0] = 1;
        for (int i = 0; i < set.length; ++i) {
            for (int j = set[i]; j <= val; ++j) {
                table[j] += table[j - set[i]];
            }
        }
        return table[val];
    }
    public static void coinChange(int val, int[] set) {
        // Recursion.
        ArrayList<int[]> all = new ArrayList<int[]>();
        int[] count = new int[set.length];
        nextCoin(val, set, 0, all, count);
        for (int[] one : all) {
            for (int i : one) System.out.print(i + " ");
            System.out.println();
        }
        System.out.println("Total # of solutions are: " + all.size());
    }
    public static void nextCoin(int val, int[] set, int index, ArrayList<int[]> all, int[] count) {
        if (val == 0 && index == set.length) {
            // If all coins with diff val have been used for targeted value
            // then we got our answer.
            int[] tmp = new int[count.length];
            for (int i = 0; i < count.length; ++i) {
                tmp[i] = count[i];
            }   
            all.add(tmp);
        } else if (index < set.length) {
            for (int i = 0; i <= val / set[index]; ++i) {
                // e.g. number of 25cents can be chosen from 0 to 4.
                count[index] = i;
                nextCoin(val - set[index] * i, set, index + 1, all, count);
            }
        }
    }
}
