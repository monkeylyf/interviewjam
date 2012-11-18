/*Write a method to compute all the permutations of a sing*/
import java.util.*;

class test_52 {
	public static void main(String[] args) {
		String s = "abc";
		//for (String i : permutate(s)) System.out.println(i);
		permutate(s);
	}
	public static void permutate(String str) {
		permutation("", str);
	}
	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) System.out.println(prefix);
		else {
			for (int i = 0; i < n; ++i) {
				permutation(prefix + str.charAt(i),
					str.substring(0, i) + str.substring(i+1, n));
			}
		}
	}
}
