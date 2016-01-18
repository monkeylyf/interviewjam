/*Ugly_Number

Ugly numbers are numbers whose only prime factors are 3, 5 or 7. The sequence
1, 3, 5, 7, 9, 15, 21...
shows the first couple of ugly numbers. By convention, 1 is included.
Write a program to find and print the nth ugly number.
*/


import java.util.*;


class Ugly_Number {
	public static void main(String[] args) {
		//for (int i = 1; i < 50; ++i) System.out.println(getKth(i) == solve(i));
        solve(5);
	}
	public static int getKth(int k) {
        // Stack based solution
		Queue<Integer> H3 = new LinkedList<Integer>();
		Queue<Integer> H5 = new LinkedList<Integer>();
		Queue<Integer> H7 = new LinkedList<Integer>();
		Stack<Integer> sorted = new Stack<Integer>();
		sorted.push(1); // By convention.
		H3.offer(3);
		H5.offer(5);
		H7.offer(7);
		for (int i = 0; i < k - 1; ++i) {
			int smallest = Math.min(Math.min(H3.peek(), H5.peek()), H7.peek());
			if (smallest == H3.peek()) {
				sorted.push(H3.poll());
				H3.offer(sorted.peek() * 3);
				H5.offer(sorted.peek() * 5);
				H7.offer(sorted.peek() * 7);
			}
			if (smallest == H5.peek()) {
				sorted.push(H5.poll());
				H5.offer(sorted.peek() * 5); // sorted.peek() * 3 has been pushed.
				H7.offer(sorted.peek() * 7);
			}
			if (smallest == H7.peek()) {
				sorted.push(H7.poll());
				H7.offer(sorted.peek() * 7);
			}
		}
		return sorted.peek();
	}
    public static int solve(int n) {
        // dp-based solution.  
        int last2 = 0, last3 = 0, last5 = 0, i;
        long prev;
        long[] dp = new long[n];
        dp[0] = 1;
        for (i = 1; i < n; ++i) {
            prev = dp[i - 1];
            System.out.println("i: " + i + " prev: " + prev);
            while (dp[last2] * 3 <= prev) {
                ++last2; // Find dp[n] which is closest to prev.
            }
            while (dp[last3] * 5 <= prev) {
                ++last3;
            }
            while (dp[last5] * 7 <= prev) {
                ++last5;
            }
            dp[i] = Math.min(dp[last2] * 3, Math.min(dp[last3] * 5, dp[last5] * 7));
        }
        return (int)(dp[n - 1]);
    }
}
