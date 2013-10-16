/*isSubstring
careercup

Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings,s1 and s2, write code to check if s2 is a rotation of 
s1 using only one call to isSubstring (i e , “waterbottle” is a rotation of
“erbottlewat”)*/

public class cap_isSubstring {

	public static void main(String[] args) {
		String a = "fuckthisshit";
		String b = "ckthisshitfu";
		isRotation(a, b);
	}
	public static boolean isSubstring(String a, String b) {
		// Check KMP or strStr.
		return false;	
	}
	public static boolean isRotation(String a, String b) {
		if (a.length() != b.length()) {
            return false;
        } else {
			return isSubstring(a, a + b);
		}
	}
}
