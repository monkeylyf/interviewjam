/*Bits_Combination_And_Mapping
careercup

1. How many different binary numbers having a number of 1 and b number of 0?
2. Put all the possible numbers in a sorted list. Given a index, could you
calculate what that number is?
3. Given the number in this list, could you calculate its index?

Solution for question 1:
C a (a + b)
*/



public class cap_Bits_Combination_And_Mapping {

	public static void main(String[] args) {
		// Test case for getNumber.
		// 00011
		// 00101
		// 00110
		// 01001
		// 01010
		// 01100
		// 10001
		// 10010
		// 10100
		// 11000
		String[] testSuite = new String[] {"00011", "00101", "00110", "01001", "01010",
									 "01100", "10001", "10010", "10100", "11000"};
		for (int i = 0; i < testSuite.length; ++i) {
			System.out.println(getNumber(2, 3, i).equals(testSuite[i]));
		}
		// Test case for getIndex.
		for (int i = 0; i < testSuite.length; ++i) {
			System.out.println(getIndex(testSuite[i], 2, 3) == i);	
		}
	}

    // Given index, get number.
    public static String getNumber(int oneNum, int zeroNum, int index) {
		assert(conb(oneNum, oneNum + zeroNum) > index);
		String acc = "";
		return getNumberUtil(acc, oneNum, zeroNum, index);
	}

	// Util function for getNumber.
	public static String getNumberUtil(String acc, int oneNum, int zeroNum, int index) {
        if (zeroNum == 0) {
			return acc + new String(new char[oneNum]).replace("\0", "1");
        } else if (oneNum == 0) {
			return acc + new String(new char[zeroNum]).replace("\0", "0");
        } else {
			// Count how many are starts with zero since sorted ascending order.
			// Combination question: pick a - 1 from a + b - 1.
            int thredhold = conb(zeroNum - 1, zeroNum + oneNum - 1);
            if (index >= thredhold) {
				return getNumberUtil(acc + "1", oneNum - 1, zeroNum, index - thredhold);
			} else {
				return getNumberUtil(acc + "0", oneNum, zeroNum - 1, index);
			}
        }
    }


    // Given number, get index.
    public static int getIndex(String num, int oneNum, int zeroNum) {
		int index = 0;
		return getIndexUtil(num, oneNum, zeroNum, index);
	}

	public static int getIndexUtil(String num, int oneNum, int zeroNum, int index) {
        if (oneNum == 0 || zeroNum == 0) {
			return index;
        } else if (num.charAt(0) == '0') {
				return getIndexUtil(num.substring(1, num.length()), oneNum,
						zeroNum - 1, index);
		} else {
				return getIndexUtil(num.substring(1, num.length()), oneNum - 1,
						 zeroNum, index + conb(zeroNum - 1, zeroNum - 1 + oneNum));
        }
    }

	// Helper function.
    public static int factorial(int n) {
        if (n == 0) {
			return 1;
		}

        int retval = 1;
        for (int i = 1; i <= n; ++i) {
			retval *= i;
		}
        return retval;
    }

	// Calculate C(a, b)
    public static int conb(int a, int b) {
		if (a == 0) {
			return 1;
		} else {
			return factorial(b) / factorial(a) / factorial(b - a);
		}
    }
}
