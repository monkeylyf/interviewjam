/*hackerrank_Billboards
hackerrank

Input description 

Ist line contain two space seperated integers N and K. Then follow N lines
describing the profit value of each billboard i.e ith line contains the profit
value of ith billboard.

Sample Input
6 2 
1
2
3
1
6
10 

Sample Output
21

Explanation

In given input there are 6 billboards and after the process no more than 2
should be together.
So remove 1st and 4th billboards giving a configuration _ 2 3 _ 6 10 having a
profit of 21. No other configuration has a profit more than 21.So the answer is 21.

Constraints
1 <= N <= 1,00,000(10^5)
1 <= K <= N
0 <= profit value of any billboard <= 2,000,000,000(2*10^9)
*/


import java.util.*;


public class Billboards {
    public static void main(String[] args) {
        // Unit tests batch 1.
        System.out.println("test batch 1");
        System.out.println(billboard(new int[] {1, 2, 3, 1, 6, 10}, 0) == 0);
        System.out.println(billboard(new int[] {1, 2, 3, 1, 6, 10}, 1) == 9);
        System.out.println(billboard(new int[] {1, 2, 3, 1, 6, 10}, 2) == 2);
        System.out.println(billboard(new int[] {1, 2, 3, 1, 6, 10}, 3) == 1);
        System.out.println(billboard(new int[] {1, 2, 3, 1, 6, 10}, 4) == 1);
        System.out.println(billboard(new int[] {1, 2, 3, 1, 6, 10}, 5) == 1);
        System.out.println(billboard(new int[] {1, 2, 3, 1, 6, 10}, 6) == 0);
        // Unit tests batch 2.
        System.out.println("test batch 2");
        System.out.println(billboard(new int[] {}, 1) == 0);
        System.out.println(billboard(new int[] {1}, 1) == 0);
        System.out.println(billboard(new int[] {1, 2}, 0) == 0);
        System.out.println(billboard(new int[] {1, 2}, 1) == 1);
        System.out.println(billboard(new int[] {1, 2}, 2) == 0);
        // Unit tests batch 3.
        System.out.println("test batch 3");
        System.out.println(billboard(new int[] {3,2,1,4,5,6,3,4,5}, 0) == 0);
        System.out.println(billboard(new int[] {3,2,1,4,5,6,3,4,5}, 1) == 15);
        System.out.println(billboard(new int[] {3,2,1,4,5,6,3,4,5}, 2));
        System.out.println(billboard(new int[] {3,2,1,4,5,6,3,4,5}, 3));
        System.out.println(billboard(new int[] {3,2,1,4,5,6,3,4,5}, 4));
        System.out.println(billboard(new int[] {3,2,1,4,5,6,3,4,5}, 5));
        System.out.println(billboard(new int[] {3,2,1,4,5,6,3,4,5}, 6));
        System.out.println(billboard(new int[] {3,2,1,4,5,6,3,4,5}, 7));
        System.out.println(billboard(new int[] {3,2,1,4,5,6,3,4,5}, 8));
        System.out.println(billboard(new int[] {3,2,1,4,5,6,3,4,5}, 9));
    }
    public static long billboard(int[] arr, int k) {
        if (arr.length <= k || k <= 0) {
            return 0;
        }
        long sum = 0;
        long[] local = new long[] {Integer.MAX_VALUE, 0}; // local[0]; localMin local[1]: localMinIndex
        long[] status = new long[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            status[i] = arr[i];
        }
        for (int i = k + 1; i < status.length; ++i) {
            // Update localMin and localMinIndex.
            updateLocalMin(local, status, i - 1 - k, i - 1);
            status[i] += local[0];
        }
        updateLocalMin(local, status, status.length - 1 - k, status.length - 1);
        //print(status);
        return sum - local[0];
    }
    public static void print(long[] status) {
        for (long i : status) System.out.print(i + " ");
        System.out.println();
    }
    public static void updateLocalMin(long[] local, long[] status, int start, int end) {
        if (start == 0 || local[1] == start - 1) {
            // Sliding window just passed localMin or sliding window hasn't been initialized.
            // Rescan new window.
            local[0] = status[start];
            local[1] = start;
            for (int index = start + 1; index <= end; ++index) {
                if (status[index] < local[0]) {
                    local[0] = status[index];
                    local[1] = index;
                }
            }
        } else if (status[end] <= local[0]) {
            local[1] = end; // Index update. When status[end] == local[0], index updated to right most.
            local[0] = Math.max(status[end], local[0]); // update localMin.
        }       
    }
}
