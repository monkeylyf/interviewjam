/*Reverse_Integer

Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321


Questions you should ask your interviewer:
1. last digit is 0: 10, 100
How to reverse? 01 or 001 or just 1?
2. int overflow
Assuming 32-bit integer, reverse of 100000003 will cause overflows
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

/*Python Version
Using str to reverse. yeah it's cheating.

def reverse(self, x):
    neg = False if x > 0 else True
    x = abs(x)
    x = int(''.join(reversed(str(x))))
	return -x if neg else x

def reverse(self, x):
    neg = False if x > 0 else True
    x = abs(x)
    ret = 0
    
    while x:
        ret *= 10
        ret += x % 10
        x /= 10
    return -ret if neg else ret
*/
