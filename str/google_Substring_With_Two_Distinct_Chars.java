/*Substring_With_Two_Distinct_Chars
google

Given a string, find the longest substring with only two distinct characters.

For exmaple,
Given string "abbaacccaaabba", return "aacccaaa"
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
    }
    
    public static String solve(String str) {
        String ret = "";
        int head = 0, tail = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (tail < str.length()) {
            if (set.contains(str.charAt(tail))) {
                ++tail;
            } else if (set.size() < 2) {
                set.add(str.charAt(tail));
                ++tail;
            } else {
                // update ret.
                ret = (tail - head > ret.length()) ? str.substring(head, tail) : ret;
                // Retrospect to longest subarray with one distinct char.
                tail -= 1;
                head = tail;
                while (str.charAt(head - 1) == str.charAt(tail)) {
                    --head;
                }
                tail = head;
                // Clear set.
                set.clear();
                set.add(str.charAt(tail));
            }
        }
        return ret;
    }
}
