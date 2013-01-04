/*Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.
*/

class leetcode_62 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12334));
        System.out.println(isPalindrome(12331));
        System.out.println(isPalindrome(-2147483648));
        System.out.println(isPalindrome(2147447412));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int left_dividor = 1;
        int right_dividor = 1;
        int tmp = Math.abs(x);
        while (tmp / left_dividor >= 10 && left_dividor < Integer.MAX_VALUE / 10) {
            left_dividor *= 10;
        }
        while (left_dividor >= right_dividor) {
            if (tmp / left_dividor % 10 != tmp / right_dividor % 10) return false;
            left_dividor /= 10;
            right_dividor *= 10;
        }
        return true;
    }
}
