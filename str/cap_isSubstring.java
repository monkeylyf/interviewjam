/*isSubstring
careercup

Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings,s1 and s2, write code to check if s2 is a rotation of 
s1 using only one call to isSubstring (i e , “waterbottle” is a rotation of
“erbottlewat”)*/

class cap_isSubstring {
	public static void main(String[] args) {
		String a = "fuckthisshit";
		String b = "ckthisshitfu";
		rotation(a, b);
	}
	public static boolean isSubstring(String a, String b) {
		return false;	
	}
	public static boolean rotation(String a, String b) {
		if (a.length() != b.length()) {
            return false;
        }
		if (isSubstring(a, a + b)) {
            return true;
		} else {
            return false;
        }
	}
}
