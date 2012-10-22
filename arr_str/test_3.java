/*Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer
NOTE: One or two additional variables are fine. An extra copy of the array is not
FOLLOW UP
Write the test cases for this method
*/

class test_3 {
	public static void main(String[] args) {
		String input = "abbbcdee";
		removeDuplicates(input.toCharArray());
	}

	// This is the example answer.
	public static void removeDuplicates(char[] str) {
		if (str == null) return; // If it's null, do nothing.
		if (str.length == 1) return; // If it's one char array, do nothing.

		int len = str.length;
		int processed = 1;
		for (int cur = 1; cur < len; ++cur) {
			int j;
			for (j = 0; j < processed; ++j) {if (str[cur] == str[j]) break;}
			if (j == processed) { // means before j, no duplicate detected.
				str[processed] = str[cur];
				++processed;
			} // else. nothing. processed pointer stays.
			System.out.println(processed);
		}
		str[processed] = 0;
		System.out.println(str);
	}
}
