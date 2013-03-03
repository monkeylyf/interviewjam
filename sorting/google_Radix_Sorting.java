/*Radix Sorting /Google/

Implement Radix sort.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Radix_Sort {
    public static void main(String[] args) {
        Solution test = new Solution();
        for (int i : test.radix_sort(new int[] {170, 45, 75, 90, 802, 24, 2, 66})) System.out.print(i + " ");
    }
}


class Solution {
    private HashMap<Integer, ArrayList<Integer>> buckets;
    private int m;
    private int n;
    private boolean nextDigit;
    Solution() {
        this.buckets = new HashMap<Integer, ArrayList<Integer>>();
        this.m = 10;
        this.n = 1;
        nextDigit = true;
    }
    public int[] radix_sort(int[] A) {
        while (nextDigit) {
            boolean shouldContinue = false;
            for (int i : A) {
                if (i / n >= 10) {
                    shouldContinue = true;
                }
                int digit = (i % m) / n;
                ArrayList<Integer> bucket = buckets.get(digit);
                if (bucket == null) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(i);
                    buckets.put(digit, tmp);
                } else {
                    bucket.add(i);
                    buckets.put(digit, bucket);
                }
            }
            int count = 0;
            for (int i = 0; i <= 9; ++i) {
                ArrayList<Integer> bucket = buckets.get(i);
                if (bucket != null) {
                    System.out.println(bucket);
                    for (int j : bucket) {
                        A[count++] = j;
                    }
                }
            }
            this.m *= 10;
            this.n *= 10;
            this.buckets = new HashMap<Integer, ArrayList<Integer>>();
            this.nextDigit = shouldContinue;
        }
        return A;
    }
}
