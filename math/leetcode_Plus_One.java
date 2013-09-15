/*Plus_One

Given a number represented as an array of digits, plus one to the number.
*/

public class leetcode_Plus_One {

    public static void main(String[] args) {

    }

    public static int[] plusOne(int[] digits) {
        // Take care of the last one.
        int carry = (digits[digits.length - 1] + 1 >= 10) ? 1 : 0;
        digits[digits.length - 1] = (digits[digits.length - 1] + 1) % 10;
        for (int i = digits.length - 2; i >= 0; --i) {
            int digit = digits[i];
            digits[i] = (digit + carry) % 10;
            carry = (digit + carry >= 10) ? 1 : 0;
        }

        // After iteration, check if carry equals 1.
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; ++i) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;
    }
}
