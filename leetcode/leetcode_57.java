/*Minimum Window Substring

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


class leetcode_57 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("B", "A"));
    }
    public static String minWindow(String S, String T) {
        if (T.length() > S.length() || T.length() == 0) return "";
        // Assume all chars are ascii code.
        int[] count = new int[256];
        int[] t = new int[256];
        int matched = 0;
        int minWin = S.length() + 1; //bigger than max possible as its init value
        String ret = "";
        for (int i = 0; i < 256; i++) count[i] = t[i] = 0;
        for (int i = 0; i < T.length(); i++) t[(int) T.charAt(i)]++; 
        for (int back = 0, front = back; front <= S.length() && back < S.length();) {
            int ascii = 0;  
            if (matched == T.length()) {//you have found a window
                int wSize = front-back; 
                if (wSize < minWin) {
                    minWin = wSize;
                    ret = S.substring(back, front);
                }
                //now need to increase back
                ascii = (int)S.charAt(back);
                --count[ascii];
                if (count[ascii] < t[ascii] && t[ascii] > 0) {
                    --matched;
                }
                ++back;
                while(back < S.length() && t[ascii = (int)S.charAt(back)] == 0) {
                //look for the next char in S that appears in T as well
                    ++back;
                }
            }
            else if (front < S.length()){
                ascii = (int)S.charAt(front);
                ++count[ascii];
                if (t[ascii] > 0 && count[ascii] <= t[ascii]) {
                //the char appears in T and the char has not been matched more than necessary
                    matched++; //one more matched
                }
                ++front;
            }
            else {
                //front == S.length(), and matched < T.length()
                break;
            }
        }   
        return ret; 
    }
}
