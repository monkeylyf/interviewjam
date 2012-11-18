/*Write a method to sort an array of strings so that all the anagrams are next
to each other*/
import java.util.Arrays;


class test_58 {
	public static void main(String[] args) {
		String[] a = {"aba", "ag", "aab", "c", "baa", "ga"};
		for (String i : a) System.out.print(" " + i);
		System.out.println("");

		System.out.println(sortChars("abca"));
	}

	public static String sortChars(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
