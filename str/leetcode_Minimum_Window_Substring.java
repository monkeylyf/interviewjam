/*Minimum_Window_Substring

Given a string S and a string T, find the minimum window in S which will
contain all the characters in T in complexity O(n).
For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".
Note:
If there is no such window in S that covers all characters in T, return the
emtpy string "".
If there are multiple such windows, you are guaranteed that there will always
be only one unique minimum window in S.
*/

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.Iterator;


class leetcode_Minimum_Window_Substring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String S, String T) {
        // A window is asked for so gotta create a window to scan the string.
        // The idea behind this is scan the string first to mark the existing
        // char assuming all ASCII. Using two pointers front and back to create
        // a window.
        String ret = "";
        if (T.length() > S.length() || T.length() == 0) {
            return ret;
        }
        // Assume all chars are ascii code.
        int[] count = new int[256];
        int[] t = new int[256];
        int matched = 0;
        int minWin = S.length() + 1; // Bigger than max possible as its init value.
        for (int i = 0; i < T.length(); ++i) {
            ++t[(int)T.charAt(i)]; // Index/count pair for ACSII with given string.
        }
        int back = 0, front = 0;
        while (front <= S.length() && back < S.length()) {
            int ascii;
            if (matched == T.length()) { 
                // You have found a window.
                // If cur window is smaller than previous one, mark it.
                ret = (front - back < minWin) ? S.substring(back , front) : ret;
                minWin = Math.min(front - back, minWin);
                // Now need to increase back.
                ascii = (int)S.charAt(back);
                --count[ascii];
                if (count[ascii] < t[ascii]) {
                    --matched;
                }
                ++back;
                while (back < S.length() && t[(int)S.charAt(back)] == 0) {
                    // Look for the next char in S that appears in T as well.
                    // Pointer back will move forward (moving the left size of window to right.)
                    ++back;
                }
            } else if (front < S.length()){
                ascii = (int)S.charAt(front);
                ++count[ascii];
                if (count[ascii] <= t[ascii]) {
                    // The char appears in T and the char has not been matched more than necessary.
                    ++matched;
                }
                ++front;
            } else {
                // front == S.length() && matched < T.length()
                // front has scan the whole string.
                break;
            }
        }   
        return ret; 
    }
}
