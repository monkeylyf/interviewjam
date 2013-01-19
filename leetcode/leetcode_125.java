/*ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of
rows like this: (you may want to display this pattern in a fixed font for
better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number
of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

import java.util.ArrayList;


class leetcode_125 {
    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }
    public static String convert(String s, int nRows) {
        if (nRows == 1) return s;
        String res = "";
        ArrayList<ArrayList<Character>> all = new ArrayList<ArrayList<Character>>();
        for (int i = 0; i < nRows; ++i) {
            ArrayList<Character> tmp = new ArrayList<Character>();
            all.add(tmp);
        }
        for (int i = 0; i < s.length(); ++i) {
            int mod = i % (2 * (nRows - 1));
            all.get((mod < nRows) ?  mod : 2 * nRows - 2 - mod).add(s.charAt(i));
        }
        for (ArrayList<Character> i : all) {
            for (char j : i) res += j; 
        }
        return res;
    }
}
