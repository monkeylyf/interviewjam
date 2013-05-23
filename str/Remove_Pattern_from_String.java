/*Remove_Pattern_from_String
google

Given a string, eliminate all “b” and “ac” in the string, you have to replace
them in-place, and you are only allowed to iterate over the string once.

Examples:

acbac   ==>  ""
aaac    ==>  aa
ababac  ==>   aa
bbbbd   ==>   d

*/


import java.util.*;

public class Remove_Pattern_from_String {

	/**
	 */
	public static void main(String[] args) {
		remove("ad", "ac", "b");
		remove("acbac", "ac", "b");
		remove("aaac", "ac", "b");
		remove("react", "ac", "b");
		remove("aa", "ac", "b");
		remove("ababaac", "ac", "b");
	}
	
	public static void remove(String str, String ptn1, String ptn2) {
		int n = str.length(), i;
		int ptr = 0;
		char[] arr = str.toCharArray();
		for (i = 0; i < n; ++i) {
			if (arr[i] == 'b') {
				continue;
			} else if (i + 1 < n && arr[i] == 'a' && arr[i + 1] == 'c') {
				++i; // When the loop is over i increases by one again.
			} else {
				arr[ptr++] = arr[i]; // Copy char to head.
			}
		}
		char[] ret = Arrays.copyOfRange(arr, 0, ptr);
		System.out.println(new String(ret));
	}
}
