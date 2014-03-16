/*Longest_Substring_Without_Repeating_Characters

Given a string, find the length of the longest substring without repeating
characters. For example, the longest substring without repeating letters for
"abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
is "b", with the length of 1.
*/

import java.util.*;


class leetcode_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("hchzvfrkmlnozjk");
    }
    public static int lengthOfLongestSubstring(String s) {
        // Time complexity O()
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        int ret = 0, head = 0, i = 0;
        char curChar;
        while (i < s.length()) {
            curChar = s.charAt(i);
            if (dict.containsKey(curChar)) {
                ret = Math.max(ret, i - head); // Update 
                // next loop start from the next char of next duplicate char.
                i = dict.get(curChar) + 1;
                head = i;
                dict.clear(); // clear cache.
            }
            dict.put(s.charAt(i), i);
            ++i;
        }
        ret = Math.max(ret, i - head);
        return ret;        
    }
}

/* Python version.
def lengthOfLongestSubstring(self, s):
    ret = 0
    
    head = 0
    tail = 0
    dic = {}
    
    while tail < len(s):
        if s[tail] in dic:
            ret = max(ret, tail - head)
            head = tail = dic[s[tail]] + 1
            dic.clear()
        else:
            dic[s[tail]] = tail
            tail += 1
            
    return max(ret, tail - head)
*/
