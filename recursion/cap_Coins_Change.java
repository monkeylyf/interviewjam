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

public class cap_Coins_Change {

	public static void main(String[] args) {
        System.out.println(my(100, new int[] {25, 10, 5, 1}));
	}

	/* Dynamic programming based solution.
	 * for (int i = 1; i <= value; ++i) for (int value : set) if (value <= i) dp[i] += dp[i - value]
	 * This dp relationship is not correct because the order of cents does not matter. The outer loop
	 * should be different types of coins.
	 */
    public static int my(int val, int[] set) {
		// Init dp. dp[i] represents how many ways for value i.
        int[] dp = new int[val + 1];
        dp[0] = 1;
        for (int value : set) {
            for (int j = value; j <= val; ++j) {
                dp[j] += dp[j - value];
            }
			print(dp);
        }
        return dp[val];
    }

	// Recursion.
    public static void coinChange(int val, int[] set) {
        ArrayList<int[]> all = new ArrayList<int[]>();
        int[] count = new int[set.length];
        nextCoin(val, set, 0, all, count);
        for (int[] one : all) {
			print(one);
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

	// Helper function.
	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
