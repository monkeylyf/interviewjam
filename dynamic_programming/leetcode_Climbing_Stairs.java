/*Climbing_Stairs
leetcode

You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can
you climb to the top?
*/


class leetcode_Climbing_Stairs {
    public static void main(String[] args) {
    
    }
    public static int climbStairs(int n) {
        int f0 = 0; // if n = 0, there is no way.
        int f1 = 1; // if n = 1, there is only one way.
        int retval = 0;
        for (int i = 0; i < n; ++i) {
            retval = f0 + f1; // C(n) = C(n-1) + C(n-2)
            f0 = f1;
            f1 = retval;
        }
        return retval;
    }
}
