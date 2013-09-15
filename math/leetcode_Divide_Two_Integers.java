/*Divide_Two_Integers
leetcode

Divide two integers without using multiplication, division and mod operator.
*/

public class leetcode_Divide_Two_Integers {

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 1));
    }

    public static int divide(int dividend, int divisor) {
        int q = 1;
        // Possible integer overflow here if dividend or divisor == minimum int
        // A special case about java:
        // Math.abs(Integer.MIN_VALUE == Integer.MIN_VALUE)
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        if (b == Integer.MIN_VALUE && a != b) {
            return 0;
        }
        if (a == Integer.MIN_VALUE) {
            if (divisor > 0) {
                return -1 + divide(dividend + b, divisor);
            }
            else if (divisor < 0) {
                return 1 + divide(dividend + b, divisor);
            }
        }
        boolean neg = false;
        if ((divisor > 0 && dividend < 0) || (divisor < 0 && dividend > 0)) {
            neg = true;
        }
        if (b == 0) {
            return Integer.MAX_VALUE;
        }
        if (a < b) {
            return 0;
        }
        if (a == b) {
			return (neg) ? -1 : 1;
        }
        //use a binary search to find the q
        int product = b;
        /*My original code as below. It has integer overflow
          problem when a == 1 << 30 and b = 1. Because 1 << 31
          is negative.
        while (product <= a) {
            product = product << 1;
            q = q << 1;
        }
        product = product >> 1;
        q = q >> 1;
        */
        while (product <= a - product) {
            product = product << 1;
            q = q << 1;
        }
        q = q + divide(a - product, b);
		return (neg) ? -q : q;
    }
}
