/*K_Permutation
careercup

A(k, n)
*/


import java.util.*;


public class cap_K_Permutation {
	
	public static void main(String[] args) {
		kPermutation("abcd", 3);		
		kPermutation("abc", 2);		
	}

	public static void kPermutation(String str, int k) {
		assert(k <= str.length());
		ArrayList<String> all = new ArrayList<String>();
		String acc = "";
		kPermutationUtil("", str, k, all);
		System.out.println(all);
	}

	public static void kPermutationUtil(String acc, String str, int k, ArrayList<String> all) {
		if (acc.length()== k) {
			all.add(acc);
		} else {
			// Simulating the process 'randomly pick one from arr'.
			for (int i = 0; i < str.length(); ++i) {
				kPermutationUtil(acc + str.charAt(i),
								 str.substring(0, i) + str.substring(i + 1),
								 k,
								 all);
			}	
		}
	}
}
