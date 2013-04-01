/*Substring_With_Two_Distinct_Chars
google

Given a string, find the longest substring with only two distinct characters.

For exmaple,
Given string "abbaacccaaabba", return "aacccaaa"


You need to ask the interviewee about some edge cases you can think of like
"", which is an empty string input and "a" which contains only one distinct
char.
*/



import java.util.*;


public class Substring_With_Two_Distinct_Chars {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve("abbaacccaaabba").equals("aacccaaa"));
        System.out.println(solve("").equals(""));
        System.out.println(solve("a").equals(""));
        System.out.println(solve("abbaabbaa").equals("abbaabbaa"));
    }

    public static String solve(String str) {
        String ret = "";
        int head = 0, tail = 0, start = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (tail < str.length()) {
            if (set.contains(str.charAt(tail))) {
                ++tail;
            } else if (set.size() < 2) {
                set.add(str.charAt(tail));
                head = tail;
                ++tail;
            } else {
                // update ret.
                ret = (tail - start > ret.length()) ? str.substring(start, tail) : ret;
                // Retrospect to longest subarray with one distinct char backwards.
                tail = head;
                // Reset start for substring starting point mark.
                start = head;
                // Clear set.
                set.clear();
            }
        }
        if (set.size() != 2) { // For edge case like "a"
            return "";
        } else {
            return (tail - start > ret.length()) ? str.substring(start, tail) : ret;
        }
    }
}
