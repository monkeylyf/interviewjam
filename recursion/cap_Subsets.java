/*Subsets
careercup

Write a method that returns all subsets of a set.
*/

import java.util.*;

public class cap_Subsets {

	public static void main(String[] args) {
		// Test case 1.
		String input = "abcd";
		allSubsets(input);
		// Test case 2.
		allSubsets("1");
	}

	public static void allSubsets(String str) {
		ArrayList<String> subsets = new ArrayList<String>();
		allSubsetsUtil(0, subsets, str);
		for (String i : subsets) System.out.println(i);
	}

	public static void allSubsetsUtil(int index, ArrayList<String> subsets, String str) {
		if (index == str.length()) {
			subsets.add(""); // Empty string is a subset of every string.
		} else {
			allSubsetsUtil(index + 1, subsets, str);
			// The subset of str[i:] = the subset of str[i+1:] + [ str + str[i] for str in subset of str[i+1:] ]
			for (String iter : new ArrayList<String>(subsets)) {
				subsets.add(str.charAt(index) + iter);	
			}
		}
	}
}
