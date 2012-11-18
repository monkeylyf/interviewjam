/*Write a method to count the number of 2s between 0 and n.
FOLLOWUP
If your input N is int type and this method returns N.
*/

class test_137 {
	public static void main(String[] args) {
		countTwo(191);
		countTwo(125);
		countTwo(221);
		countTwo(250);
	}

	public static void countTwo(int n) {
		int retval = (n + 8)/ 10;
		int shit = 10;
		while (n / shit > 1) {
			int num = n / shit;
			retval += ((num + 7) / 10) * shit;
			if (num % 10 == 2) retval += n % shit + 1;
			shit *= 10;
		}
		System.out.println("Total " + retval + " counted.");
	}
}
