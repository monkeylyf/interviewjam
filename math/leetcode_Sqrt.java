/*Sqrt(x)

Implement int sqrt(int x).
Compute and return the square root of x.
*/


public class leetcode_Sqrt {

    public static void main(String[] args) {
        System.out.println(sqrt(2147395600));
    }


	// Based on Newton's method
	// http://en.wikipedia.org/wiki/Newton's_method
    public static int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int res = 1;
        while (true) {
            if (res <= x / res && res + 1 > x / (res + 1)) {
                break; // res ^ 2 <= x && (res + 1) ^ 2 > x, res is the answer.
            } else if (x / res >= 4 * res) {
                res *= 2; // x > (2 * res) ^ 2, base can be doubled.
            } else {
                ++res; // (res + 1)^ 2 < x < (2 * res) ^ 2. Very closed.
            }
        }
        return res;
    }
}
