/*Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary
representation. If the number can not be represented accurately in binary, print “ERROR*/

class test_29 {
	public static void main(String[] args) {
		decimalToBinary(256);
		decimalToBinary(0);
		System.out.println("-----------");
		System.out.println("3.82".split("."));
		allToBinary("3.72");
	}

	public static void decimalToBinary(int input) {
		if (input == 0) {System.out.println(0); return;}
		int index = 0;
		while (true) {
			if (Math.pow(2, index) > input) break;
			++index;
		}
		System.out.print(1);
		input = input - (int)Math.pow(2, index - 1);
		for (int i = index - 2; i >= 0; --i) {
			if (Math.pow(2, i) > input) {System.out.print(0);
			} else {input = input - (int)Math.pow(i, 2);
				System.out.print(1);
			}
		}
		System.out.println("");
	}

	public static void allToBinary(String input) {
		String[] arr = input.split(".");

		for (String i : arr) {System.out.println(i);}
	}
}
