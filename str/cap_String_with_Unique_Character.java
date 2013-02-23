/*String_with_Unique_Character
careercup

Implement an algorithm to determine if a string has all unique characters. What if you
can not use additional data structures?*/

import java.util.*;

class cap_String_with_Unique_Character {
	public static void main(String[] args) {
		System.out.println(isUnique("Premithius"));
		System.out.println(isUnique("Premithus"));
		System.out.println(isUniqueChar("premithius"));
		}
	// Assuming the char set it ASCii.
	public static boolean isUnique(String str) {
		boolean[] char_set = new boolean[256];
		// Convert String to CharArray otherwise foreach loop will report error.
		for (char i : str.toCharArray()) {
			if (char_set[i]) {
				System.out.println("Found again: " + i);
				return false;
			} else {char_set[i] = true;}
		}
		return true;
	}
    public static boolean isUniqueCharacter(String str) {
        HashSet<Character> hashset = new HashSet<Character>();
        for (char i : str.toCharArray()) {
            if (hashset.contains(i)) {
                return false;
            } else {
                hashset.add(i);
            }
        }
        return true;
    }
	// if it's only 'a' to 'z' totally 26 chars. We can use bit mask.
	// MAX 32 bits. so ASCII can not fit in.
	public static boolean isUniqueChar(String str) {
		int checker = 0;
		for (char i : str.toCharArray()) {
			int val = i - 'a'; // 0 - 25
			if ((checker & (1 << val)) > 0) { // Use AND to check if it's marked already
				System.out.println("Found again: " + i);
				return false;
			}
			checker |= (1 << val); // use OR to update the checker.
		}
		return true;
	}
}


