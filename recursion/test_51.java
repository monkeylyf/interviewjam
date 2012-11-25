/*Write a method that returns all subsets of a set.*/

import java.util.*;

class test_51 {
	public static void main(String[] args) {
		String input = "abcd";
		subset(input);
	}

	public static void subset(String input) {
		ArrayList<String> all = new ArrayList<String>();
		nextSubset(input, all);
		for (String i : all) System.out.println(i);
	}

	public static void nextSubset(String input, ArrayList<String> all) {
		if (input.length() == 0) {all.add(input); return;}
		nextSubset(input.substring(1, input.length()), all);
		ArrayList<String> tmp = new ArrayList<String>();
		for (String j : all) tmp.add(j);
		for (String i : tmp) all.add(input.charAt(0) + i);
	}
}
