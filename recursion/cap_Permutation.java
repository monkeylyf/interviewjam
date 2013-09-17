/*Permutation
careercup

Write a method to compute all the permutations of a string
FOLLOW UP
K-permutation. Check: ./cap_K_Permutation.java
k-conbination. Check: ./cap_K_Conbination.java
*/

import java.util.*;

public class cap_Permutation {

	public static void main(String[] args) {
		permutate("abc");
	}

	// Full permutation.
	public static void permutate(String str) {
		ArrayList<String> all = new ArrayList<String>();
		permutation("", str, all);
		System.out.println(all);
	}

	private static void permutation(String partial, String str, ArrayList<String> all) {
		if (str.length() == 0) {
			all.add(partial);
		} else {
			// Iterately pick one char from string and go recursively.
			for (int i = 0; i < str.length(); ++i) {
				permutation(partial + str.charAt(i),
					    str.substring(0, i) + str.substring(i + 1, str.length()),
					    all);
			}
		}
	}
}
