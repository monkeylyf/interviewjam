/*Divide_Two_Integers
leetcode

Divide two integers without using multiplication, division and mod operator.
*/

public class leetcode_Divide_Two_Integers {

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 1));
    }

    public static int divide(int dividend, int divisor) {
		// Edge cases.
		if (dividend == 0) {
			return 0;
		}
		if (divisor == 1) {
			return dividend;
		}
		
		if (dividend == divisor) {
			return 1;
		}
	
		// Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE then the logic below will not work.
		// Two's complement 10000000000000000000000000000000 -> (-1) 011111111111111111111111111111111
		// -> (flip) 10000000000000000000000000000000 becomes itself.
		// Hack the divident by increasing its value to avoid int overflow.	
		if (dividend == Integer.MIN_VALUE) {
			return (divisor > 0) ? divide(dividend + divisor, divisor) - 1 : divide(dividend - divisor, divisor) + 1;
		}
		if (divisor == Integer.MIN_VALUE) {
			return 0;
		}
		boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		long dividendLong = Math.abs(dividend);
		long divisorLong = Math.abs(divisor);
	
		// Find the maximum idx that divisor << idx <= dividend
		int idx = 0;
		while ((divisorLong << (idx + 1) ) <= dividendLong) {
			++idx;
		}
		
		int res = 0;
		for (; idx >= 0; --idx) {
			long digitVal = divisorLong << idx;
			// Process as binay digit.
			if (digitVal <= dividendLong) {
				res = res | (1 << idx);
				dividendLong -= digitVal;
			}
		}
		
		return (neg) ? -res : res;
    }
}
