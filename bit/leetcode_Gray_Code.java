/*Gray_Code

The gray code is a binary numeral system where two successive values differ
in only one bit.
Given a non-negative integer n representing the total number of bits in the
code, print the sequence of gray code. A gray code sequence must begin with 0.
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence according to the
above definition.
For now, the judge is able to judge based on one instance of gray code
sequence. Sorry about that.
*/

import java.util.ArrayList;


public class leetcode_Gray_Code {

    public static void main(String[] args) {
        for (int i : grayCode(2)) System.out.println(i);
    }

    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> all = new ArrayList<Integer>();
        for (int i = 0; i < Math.pow(2, n); ++i) {
            all.add((i >> 1) ^ i);
        }
        return all;
    }
}
