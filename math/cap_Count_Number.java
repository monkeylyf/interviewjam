/*Count_Number
careercup

Write a method to count the number of 2s between 0 and n.
FOLLOWUP
If your input N is int type and this method returns N.
*/

public class cap_Count_Number {

	public static void main(String[] args) {
		countTwo(191);
		countTwo(125);
		countTwo(221);
		countTwo(250);
	}

	public static void countTwo(int n) {
		int retval = (n + 8) / 10; // First digit case: count within [0, 9]
		int base = 10;
		while (n > base) { // Loop from second digit case to largest digit.
			int num = n / base;
			retval += ((num + 7) / 10) * base; // e.g., num = 127 / 10 = 12. Count all 2s on second digit [0, 119]
			if (num % 10 == 2) {
                retval += n % base + 1; // then count all 2s on second digit [120, 127]
            }
			base *= 10; // Next digit case.
		}
		System.out.println("Total " + retval + " counted.");
	}
}
