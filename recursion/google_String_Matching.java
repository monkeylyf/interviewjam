/*String_Matching
google

Given a string with length t.
for example char str ="adg?b?dd?g", Each ? represents either '0' or '1'

print out all combinations of the string.
*/


public class google_String_Matching {

	/* Recursion + backtracking
	 * Or, you can permutate all 1/0 with given number of '?' then substitute the origin string.
	 */
	public static void main(String[] args) {
		stringMatching("1??");	
	}

	public static void stringMatching(String pattern) {
		char[] arr = pattern.toCharArray();
		stringMatchingUtil(arr, 0);
	}

	private static void stringMatchingUtil(char[] arr, int index) {
		if (index == arr.length) {
			System.out.println(new String(arr));	
		} else {
			if (arr[index] == '?') {
				arr[index] = '1';
				stringMatchingUtil(arr, index + 1);
				arr[index] = '0';
				stringMatchingUtil(arr, index + 1);
				arr[index] = '?';
			} else {
				stringMatchingUtil(arr, index + 1);
			}
		}
	}
}
