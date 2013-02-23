/*Longest_Substring_Without_Repeating_Characters

Given a string, find the length of the longest substring without repeating
characters. For example, the longest substring without repeating letters for
"abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
is "b", with the length of 1.
*/

import java.util.Hashtable;


class leetcode_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("hchzvfrkmlnozjk");
    }
    public static int lengthOfLongestSubstring(String s) {
        Hashtable<Character, Integer> dict = new Hashtable<Character, Integer>();
        int ptr = 0;
        int length = 0;
        int cur_index = 0;
        int i = 0;
        while (i < s.length()) {
            char curChar = s.charAt(i);
            if (dict.containsKey(curChar)) {
                if (i - cur_index > length) {
                    // Longer length.
                    length = i - cur_index;
                    ptr = cur_index;
                }
                // next loop start from the next char of next duplicate char.
                i = dict.get(curChar) + 1;
                cur_index = i;
                dict = new Hashtable<Character, Integer>();
            }
            dict.put(s.charAt(i), i);
            ++i;
        }
        if (s.length() - cur_index > length) {
            length = s.length() - cur_index;
            ptr = cur_index;
        }
        return length;
    }
}
