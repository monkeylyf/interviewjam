/*Palindrome_Number

Determine whether an integer is a palindrome. Do this without extra space.
*/

public class leetcode_Palindrome_Number {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12334));
        System.out.println(isPalindrome(12331));
        System.out.println(isPalindrome(-2147483648));
        System.out.println(isPalindrome(2147447412));
    }

    public static boolean isPalindrome(int x) {
        // Be aware of integer overflow.
        if (x < 0) {
            // Here is the confusing part. For leetcode OJ, for negative number
            // the func returns false (-2147447412), but my understanding is a
            // negative integer can be a palindrome number if its positive
            // counterpart is a palindrome. 2147447412 is a palindrome.
            return false;
        }
        int left_dividor = 1;
        int right_dividor = 1;
        int tmp = Math.abs(x);
        // Find the possible largest left_dividor.
        while (tmp / left_dividor >= 10 && left_dividor < Integer.MAX_VALUE / 10) {
            // tmp / left_divdor >= 10 -->
            // left_dividor < Integer.MAX_VALUE / 10 prevent integer overflow.
            left_dividor *= 10;
        }
        while (left_dividor >= right_dividor) {
            if (tmp / left_dividor % 10 != tmp / right_dividor % 10) {
                return false;
            }
            left_dividor /= 10;
            right_dividor *= 10;
        }
        return true;
    }
}
