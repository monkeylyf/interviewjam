/*Regular_Expression_Matching

Implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
The function prototype should be:
bool isMatch(const char *s, const char *p)
Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/


import java.util.ArrayList;


class leetcode_Regular_Expression_Matching {
    public static void main(String[] args) {
        //isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s");
        //isMatch("aaca", "ab*a*c*a");
        //isMatch("abcdede", "ab.*de");
        //isMatch("bbbba", ".*a*a");
        isMatch("kabb", ".abb*");
    }
    public static boolean isMatch(String s, String p) {
        ArrayList<String> regex = new ArrayList<String>(); // parse the regex.
        for (int i = p.length() - 1; i >= 0; --i) {
            if (p.charAt(i) == '*') {
                regex.add(0, p.substring(i - 1, i + 1));
                --i;
            } else {
                regex.add(0, p.charAt(i) + "");
            }
        }
        boolean[] prev = new boolean[regex.size() + 1]; // previous row of dp-based matrix
        prev[0] = true; // Empty str "" match empty str "".
        for (int i = 0; i < regex.size(); ++i) {
            if (regex.get(i).length() == 2) {
                prev[i + 1] = true; // i
            } else {
                break; // Once a mismatch seen, the rest of them are all mismatch.
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            boolean[] next = new boolean[regex.size() + 1];
            for (int j = 0; j < regex.size(); ++j) {
                String cur = regex.get(j);
                if (cur.length() == 2) {
                    if (cur.charAt(0) == '.' || cur.charAt(0) == s.charAt(i)) {
                        // isMatch(yya, xxa*) = isMatch(yy, xx) || isMatch(yya, xx).
                        next[j + 1] = next[j] || prev[j];
                        if (i > 0 && (cur.charAt(0) == s.charAt(i - 1) || cur.charAt(0) == '.')) {
                            // 'x*' case: Check if the previous (i > 0) char equals cur char. 
                            // '.*' case: matches anything. 
                            // These two case can match zero or more of the preceding element.
                            // isMatch(yya, xxa*) = isMatch(yy, xx) || isMatch(yya, xx) || isMatch(yy, xxa*)
                            next[j + 1] = next[j + 1] || prev[j + 1];
                        }
                    } else {
                        // isMatch(yya, xxb*) = isMatch(yya, xx).
                        next[j + 1] = next[j]; 
                    }
                } else {
                    // length() == 1.
                    if (cur.equals(".") || cur.equals(s.charAt(i) + "")) {
                        // isMatch(yya, xxa) = isMatch(yy, xx)
                        next[j + 1] = prev[j];
                    } else {
                        // Mismatch.
                        next[j + 1] = false; 
                    }
                }
            }
            prev = next;
        }
        return prev[prev.length - 1];
    }
}
