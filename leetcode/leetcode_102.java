/*Sqrt(x)

Implement int sqrt(int x).
Compute and return the square root of x.
*/


class leetcode_102 {
    public static void main(String[] args) {
        System.out.println(sqrt(2147395600));
    }
    public static int sqrt(int x) {
        if (x == 0) return 0;
        int res = 1;
        while (true) {
            if (res <= x / res && res + 1 > x / (res + 1)) {
                break;
            } else if (x / res >= 4 * res) {
                res = res * 2;
            } else {
                ++res;
            }
        }
        return res;
    }
}
