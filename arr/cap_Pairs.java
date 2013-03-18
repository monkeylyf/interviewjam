/*Pairs
careercup

Design an algorithm to find all pairs of integers within an array which sum
to a specified value

../arr/hackerrank_Pairs: find pairs with fixed diff.
*/


import java.util.*;


class cap_Pairs {
	public static void main(String[] args) {
		int[] input= {0, 3, 5, 14, 6, -1, 7, 8, 13, -2};
		System.out.println(printPair(input, 5));
	}

	public static ArrayList<ArrayList<Integer>> printPair(int[] arr, int sum) {
        // Find pairs with fixed sum.
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>(); 
        for (int i : arr) {
            if (set.contains(sum - i)) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                Collections.addAll(tmp, i, sum - i);
                all.add(tmp);
            }
            set.add(i);
        }
        return all;
	}
}
