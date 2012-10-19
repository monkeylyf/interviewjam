/*Write a method to decide if two strings are anagrams or not*/

import java.util.*;

class test_4 {
	public static void main(String[] args) {
		// I should think of more test cases here.
		// e.g.:
		// 1.String does not contain any duplicates, e g: abcd
		// 2.String contains all duplicates, e g:  aaaa
		// 3.Null string
		// 4.Empty string
		// 5.String with all continuous duplicates, e g : aaabb
		// 6.String with non-contiguous duplicates, e g : abababa
		String a = "spell";
		String b = "lespl";
		System.out.println(Anagram(a, b));
		System.out.println(detectAnagram(a, b));
		String c = "fuckthissht";
		String d = "goddamnitit";
		System.out.println(detectAnagram(c, d));
		System.out.println(detectAnagram(c, d));
		String e = "asdf";
		String f = "asdfasdf";
		System.out.println(detectAnagram(e, f));
		System.out.println(detectAnagram(e, f));
		}
	// Solution 1.
	public static boolean detectAnagram(String a, String b) {
		if (a.length() != b.length()) return false;
		String aa = IntArray(a);
		String bb = IntArray(b);
		if (aa.equals(bb)) return true;
		return false;	
	}

	public static String IntArray(String a) {
		int[] counter = new int[256];
		int i = 0;
		while(i < a.length()) {
			int val = a.charAt(i);
			++counter[val];
			++i;
		}
		String output = Arrays.toString(counter);
		return output;

	}

	// Solution 2.
	public static boolean Anagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
			}
		return Sort(a).equals(Sort(b));
	}

	public static String Sort(String a) {
		char[] chars = a.toCharArray();
		Arrays.sort(chars);
		String sorted = new String(chars);
		return sorted;
	}
}
