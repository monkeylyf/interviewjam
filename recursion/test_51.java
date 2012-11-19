/*Write a method that returns all subsets of a set.*/

import java.util.*;

class test_51 {
	public static void main(String[] args) {
		char[] input = "abcd".toCharArray();
		subset(input);
	}

	public static void subset(char[] input) {
		ArrayList<char[]> all = new ArrayList<char[]>();
		nextSubset(input, all);
		for (char[] i : all) System.out.println(i);
	}

	public static void nextSubset(char[] input, ArrayList<char[]> all) {
		if (input.length == 0) {all.add(input); return;}
		nextSubset(removeIndex(input, 0), all);
		ArrayList<char[]> tmp = new ArrayList<char[]>();
		for (char[] j : all) tmp.add(j);
		for (char[] i :  tmp) all.add((new String(i) + input[0]).toCharArray());
	}

	public static char[] removeIndex(char[] input, int i) {
		String retval = "";
		for (int j = 0; j < input.length; ++j) {if (j != i) retval += input[j];}
		return retval.toCharArray();
	}
}
