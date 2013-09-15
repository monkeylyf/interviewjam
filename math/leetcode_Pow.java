/*Pow(x, n)

Implement pow(x, n).
*/


public class leetcode_Pow {

    public static void main(String[] args) {
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean negtive = false;
        if (n < 0) {
            negtive = true;
            n = -n;
        }
        double res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
            }
            n /= 2;
            x *= x;
        }
		return (negtive) ? 1 / res : res;
    }
}
