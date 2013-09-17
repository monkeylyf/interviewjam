/*K_Conbination
careercup

C(k, n)
*/

import java.util.*;

public class cap_K_Conbination {
	
	public static void main(String[] args) {
		// Test case.
		kConbination("abcd", 3);
		kConbination("abc", 3);
	}

	public static void kConbination(String str, int k) {
		assert(k <= str.length());
		ArrayList<String> all = new ArrayList<String>();
		String acc = "";
		kConbinationUtil(acc, str, k, all);
		System.out.println(all);
	}

	public static void kConbinationUtil(String acc, String str, int k, ArrayList<String> all) {
		if (k == 0) {
			all.add(acc);
		} else {
			// Take the first char of the string, go recursively
			kConbinationUtil(acc + str.charAt(0), str.substring(1), k - 1, all);
			// Skip the first char as long as the length of the string is larger than k.
			// Otherwise rest of the string can not even sum up to a k-length conbination.
			if (k < str.length()) {
				kConbinationUtil(acc, str.substring(1), k, all);
			}
		}
	}
	
}
