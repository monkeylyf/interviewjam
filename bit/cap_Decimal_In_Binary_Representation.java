/*Decimal_In_Binary_Representation
careercup

Given a (decimal - e.g. 3.72) number that is passed in as a string, print the
binary representation. If the number can not be represented accurately in
binary, print "ERROR"
*/


public class cap_Decimal_In_Binary_Representation {

	public static void main(String[] args) {
		// Test case 1 for intToBinary.
		for (int i = 0; i < 17; ++i) {
			System.out.println(i + " " + intToBinary(i));
		}
		// Test case for deciToBinary.
		System.out.println(deciToBinary(0.75));
		System.out.println(deciToBinary(0.99));
		System.out.println(deciToBinary(0.50));
		System.out.println(deciToBinary(0.125));
		System.out.println(deciToBinary(0.72));

		// Test case for toBinary.
		System.out.println(toBinary("3.72"));
		System.out.println(toBinary("3.75"));
	}

	public static String intToBinary(int val) {
		if (val == 0) {
			return "0"; // Special case.
		}
		String res = "";
		int digit = 0, cur;
		// Count how many digits binary repre has.
		while (true) {
			cur = (int) Math.pow(2, digit);
			if (cur >= val) {
				if (cur > val) {
					--digit;
				}
				break;	
			}
			++digit;
		}
		// Starting structing binary repre from left.
		while (digit >= 0) {
			cur = (int) Math.pow(2, digit);	
			if (cur <= val) {
				res += "1";
				val -= cur;
			} else {
				res += "0";
			}
			--digit;
		}
		return res;
	}

	public static String deciToBinary(double val) {
		String res = ".";
		double base = 0.5;
		int loopLimit = 20;
		while (val != 0 && loopLimit-- > 0) {
			if (val >= base) {
				val -= base;
				res += "1";
			} else {
				res += "0";
			}
			base /= 2;
		}
		if (loopLimit == -1) {
			return "ERROR";
		} else {
			return res;
		}
	}

	public static String toBinary(String num) {
		// split takes regex. Use '//' to escape.
		String[] arr = num.split("\\.");
		assert(arr.length == 2);
		
		double deci = Double.parseDouble("0." + arr[1]);
		String res = deciToBinary(deci);
		if (res.equals("ERROR")) {
			return res;			
		} else {
			return intToBinary(Integer.parseInt(arr[0])) + res;
		}
	}
}
