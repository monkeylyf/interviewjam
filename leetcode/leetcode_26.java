/*A message containing letters from A-Z is being encoded to numbers using the
following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways
to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/


class leetcode_26 {
    public static void main(String[] args) {
        String test = "17";
        System.out.println(numDecodings(test));
    }
    public static int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int c1;
        if (s.charAt(0) == '0') return 0;
        else c1 = 1;
        int c0 = 1;
        for (int i = 1; i < s.length(); ++i) {
            int decodeTwo = Integer.parseInt(s.substring(i - 1, i + 1));
            int decodeOne = Integer.parseInt(s.substring(i, i + 1));
            boolean two = ((decodeTwo >= 10) && (decodeTwo <= 26));
            boolean one = decodeOne != 0;
            if (two && one) {
                c1 += c0;
                c0 = c1 - c0;
            } else if (two == true && one == false) {
                int swap = c1;
                c1 = c0;
                c0 = swap;
            } else if (two == false && one == true) {
                c0 = c1; 
            } else {
                return 0;
            }
        }
        return c1;
    }
}
