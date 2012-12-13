/*
1. How many different binary numbers having a number of 1 and b number of 0?
2. Put all the possible numbers in a sorted list. Given a index, could you
calculate what that number is?
3. Given the number in this list, could you calculate its index?

Solution for question 1:
C a (a + b)
*/

import java.math.BigInteger;

class extra_1 {
	public static void main(String[] args) {
        nextBit("", 2, 3, 1);
        nextBit("", 2, 3, 2);
        nextBit("", 2, 3, 3);
        nextBit("", 2, 3, 4);
        nextBit("", 2, 3, 5);
        nextBit("", 2, 3, 6);
        nextBit("", 2, 3, 7);
        nextBit("", 2, 3, 8);
        nextBit("", 2, 3, 9);
        nextBit("", 2, 3, 10);
        getIndex("00011", 2, 3, 0);
        getIndex("00101", 2, 3, 0);
        getIndex("00110", 2, 3, 0);
        getIndex("01001", 2, 3, 0);
        getIndex("01010", 2, 3, 0);
        getIndex("01100", 2, 3, 0);
        getIndex("10001", 2, 3, 0);
        getIndex("10010", 2, 3, 0);
        getIndex("10100", 2, 3, 0);
        getIndex("11000", 2, 3, 0);
	}
    public static int factorial(int n) {
        if (n == 0) return 1;
        int retval = 1;
        for (int i = 1; i <= n; ++i) retval *= i;
        return retval;
    }
    public static int conbination(int a, int b) {
        int k = factorial(a) * factorial(b - a);
        return factorial(b) / k;
    }
    // Given index, get number.
    public static void nextBit(String set, int one, int zero, int index) {
        if (zero == 0 && one == 1) {
            set += "1";
            System.out.println(set);
        }
        else if (one == 0 && zero == 1) {
            set += "0";
            System.out.println(set);
        }
        else {
            int thredhold = conbination(zero - 1, zero - 1 + one);
            if (index > thredhold) nextBit(set + "1", one - 1, zero, index - thredhold);
            else nextBit(set + "0", one, zero - 1, index);
        }
    }
    // Given number, get index.
    public static void getIndex(String set, int one, int zero, int index) {
        if (one == 0 || zero == 0) System.out.println("This number is " + ++index + "th");
        else {
            if (set.charAt(0) == '0') getIndex(set.substring(1, set.length()), one, zero - 1, index);
            else getIndex(set.substring(1, set.length()), one - 1, zero, index + conbination(zero - 1, zero - 1 + one));
        }
    }
}
