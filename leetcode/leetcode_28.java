/*Divide two integers without using multiplication, division and mod operator.*/

class leetcode_28 {
    public static void main(String[] args) {
        System.out.println(divide(27, 3));
        System.out.println(divide(28, 3));
        System.out.println(divide(29, 3));
        System.out.println(divide(30, 3));
        System.out.println(divide(30, 15));
    }
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int dividend_pos = dividend >> 31;
        int divisor_pos = divisor >> 31;
        int res = 0;
        while (a >= b) {
            int exponential = 1;
            while (a >= b << 1) {
                exponential = exponential << 1;
                b = b << 1;
            }
            res += exponential;
            a -= b;
            b = Math.abs(divisor);
        }
        if (dividend_pos + divisor_pos == -1) return -res;
        else return res;
    }
}
