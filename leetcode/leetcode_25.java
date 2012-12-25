/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

*/

class leetcode_25 {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
    }
    public static String countAndSay(int n) {
        String cur = "1";
        while (--n > 0) {
            String tmp = "";
            char last_char = cur.charAt(0);
            int count = 0;
            for (int i = 0; i < cur.length(); ++i) {
                if (cur.charAt(i) == last_char) {
                    ++count;
                } else {
                    tmp += "" + count + last_char;
                    count = 1;
                    last_char = cur.charAt(i);
                }
            }
            tmp += "" + count + last_char;
            cur = tmp;
        }
        return cur;
    }
}
