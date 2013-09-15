/*Reverse_Integer

Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class leetcode_Reverse_Integer {

    public static void main(String[] args) {

    }

    public static int reverse(int x) {
        boolean neg = (x < 0) ? true : false;
        x = (neg) ? -x : x;
        int ret = 0;
        while (x > 0) {
            ret *= 10;
            ret += x % 10;
            x /= 10;
        }
        if (neg) {
            return -ret;
        }
        return ret;
    }
}
