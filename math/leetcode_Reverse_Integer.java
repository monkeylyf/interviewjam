/*Reverse_Integer

Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
*/

class leetcode_Reverse_Integer {
    public static void main(String[] args) {
    }
    public static int reverse(int x) {
        boolean negtive = false;
        int res = 0;
        if (x < 0) {
            x = -x;
            negtive = true;
        }
        while (x > 0) {
            int last = x % 10;
            res = res * 10 + last;
            x /= 10;
        }
        if (negtive) {
            res = - res;
        }
        return res;
    }
}
