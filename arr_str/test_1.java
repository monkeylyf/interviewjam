/*Implement an algorithm to determine if a string has all unique characters. What if you
can not use additional data structures?*/

import java.util.*;

class test_1 {
	public static void main(String[] args) {
		boolean[] char_set = new boolean[256];

		String input = "Premithius";
		System.out.println(input.length());
		int i = 0;
		while(i < input.length()) {
			int val = input.charAt(i);
			System.out.println(input.charAt(i) + " is " + val);
			char_set[i] = true;
			i++;
			}

		System.out.println(isUnique(input));
		System.out.println(isUniqueChar("premithius"));
		}
	// Assuming the char set it ASCii.
	public static boolean isUnique(String str) {
		boolean[] char_set = new boolean[256];

		int i = 0;
		while(i < str.length()) {
			int val = str.charAt(i);
			if (char_set[val]) {
				System.out.println("Found again: " + str.charAt(i));
				return false;
			}
			char_set[val] = true;
			i++;
		}
		return true;
	}
	public static boolean isUniqueChar(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				System.out.println("Found again: " + str.charAt(i));
				return false;
			}
			checker |= (1 << val);
			System.out.println("" + checker);
		}
		return true;
	
	}


}


