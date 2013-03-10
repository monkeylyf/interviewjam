/*Remove_Duplicates_from_Array
careercup

Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer
NOTE: One or two additional variables are fine. An extra copy of the array is not
FOLLOW UP
Write the test cases for this method
*/

class cap_Remove_Duplicates_from_Array {
	public static void main(String[] args) {
		String input = "abbbcdee";
		removeDuplicates(input.toCharArray());
		removeDuplicates("abcabcefg".toCharArray());
	}
	public static void removeDuplicates(char[] str) {
        // Sort it first then check: leetcode_Remove_Duplicates_from_Sorted_Array.java
        // Time complexity O(n^2)
		if (str == null) {
            return; // If it's null, do nothing.
        }
		if (str.length == 1) {
            return; // If it's one char array, do nothing.
        }
		int len = str.length;
		int processed = 1;
		for (int cur = 1; cur < len; ++cur) {
			int j;
			for (j = 0; j < processed; ++j) {
                if (str[cur] == str[j]) {
                    break;
                }
            }
			if (j == processed) { // means before j, no duplicate detected.
				str[processed] = str[cur];
				++processed;
			} // else. nothing. processed pointer stays.
		}
		System.out.println("Input is " + new String(str));
		String s = new String(str);
		System.out.println("Output is " + s.substring(0, processed));
	}
    public static void remove(char[] str) {
        // Unsorted array.
        // O(nlogn) + O(n).
        Arrays.sort(str);
        if (A == null || A.length = 0) {
            return  0;
        }   
        int processed = 1;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] != A[i - 1]) {
                A[processed++] = A[i];
            }   
        }   
        return processed;
    }   

}
