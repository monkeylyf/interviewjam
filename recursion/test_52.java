/*Write a method to compute all the permutations of a sing
FOLLOW UP
K-permutation.
k-conbination.
*/

import java.util.*;

class test_52 {
	public static void main(String[] args) {
		permutate("abc");
		kPermutate("abcde", 4);
		kConbination("abc", 2);
	}
	public static void permutate(String str) {
		ArrayList<String> all = new ArrayList<String>();
		permutation("", str, all);
		for (String i : all) System.out.println(i);
	}
	private static void permutation(String partial, String set, ArrayList<String> all) {
		if (set.length() == 0) all.add(partial);
		else {
			for (int i = 0; i < set.length(); ++i) {
				permutation(partial + set.charAt(i),
					    set.substring(0, i) + set.substring(i + 1, set.length()),
					    all);
			}
		}
	}
	public static void kPermutate(String str, int k) {
		ArrayList<String> all = new ArrayList<String>();
		kPermutation("", str, k, all);
		for (String i : all) System.out.println(i);
	}
	private static void kPermutation(String partial, String set, int k, ArrayList<String> all) {
		if (partial.length() == k) all.add(partial);
		else {
			for (int i = 0; i < set.length(); ++i) {
				kPermutation(partial + set.charAt(i),
					    set.substring(0, i) + set.substring(i + 1, set.length()),
					    k,
					    all);
			}
		}
	}
	public static void kConbination(String str, int k) {
		ArrayList<String> all = new ArrayList<String>();
		kConbine("", str, k, all);
		for (String i : all) System.out.println(i);
	}
	private static void kConbine(String partial, String set, int k, ArrayList<String> all) {
		if (k == 0) all.add(partial);
		else if (set.length() == 0) return;
		else {
			kConbine(partial + set.charAt(0), set.substring(1, set.length()), k - 1, all);
			kConbine(partial, set.substring(1, set.length()), k, all);
		}
	}
}
