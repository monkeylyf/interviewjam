/*Pow(x, n)

Implement pow(x, n).
*/


class leetcode_74 {
    public static void main(String[] args) {
    }
    public double pow(double x, int n) {
        if (n == 0) return 1;
        boolean negtive = false;
        if (n < 0) {
            negtive = true;
            n = -n;
        }
        double res = 1;
        while (n > 0) {
            if (n % 2 == 1) res *= x;
            n /= 2;
            x *= x;
        }
        if (negtive) return 1 / res;
        else return res;
    }
}
