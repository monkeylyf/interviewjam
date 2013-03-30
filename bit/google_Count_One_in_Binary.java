/*Count_One_in_Binary
google

Given a integer in binary presentation, count the number of 1s in it.
*/


import java.util.*;


class google_Count_One_in_Binary {
    public static void main(String[] args) {
        // Test cases for count function.
        System.out.println(count(0) == 0); // 0
        System.out.println(count(1) == 1); // 1
        System.out.println(count(2) == 1); // 10
        System.out.println(count(3) == 2); // 11
        System.out.println(count(4) == 1); // 100
        System.out.println(count(5) == 2); // 101
        System.out.println(count(6) == 2); // 110
        System.out.println(count(7) == 3); // 111
        System.out.println(count(8) == 1); // 1000
        System.out.println(count(9) == 2); // 1001
        // Test cases for countByShift.
        System.out.println(countByShift(0) == 0); // 0
        System.out.println(countByShift(1) == 1); // 1
        System.out.println(countByShift(2) == 1); // 10
        System.out.println(countByShift(3) == 2); // 11
        System.out.println(countByShift(4) == 1); // 100
        System.out.println(countByShift(5) == 2); // 101
        System.out.println(countByShift(6) == 2); // 110
        System.out.println(countByShift(7) == 3); // 111
        System.out.println(countByShift(8) == 1); // 1000
        System.out.println(countByShift(9) == 2); // 1001
    }

    public static int count(int n) {
        int ret = 0;
        while (n > 0) {
            ret += 1; // If n > 0, there is at lease one '1' in n.
            n = n & (n - 1); // set the rightmost '1' to 0.
        }
        return ret;
    }

    public static int countByShift(int n) {
        // Count by digit.
        int ret = 0;
        while (n > 0) {
            ret += n - (n >> 1 << 1);
            n = n >> 1;
        }
        return ret;
    }
}
