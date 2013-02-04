/*Wildcard_Matching

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") â†’ false
isMatch("aa","aa") â†’ true
isMatch("aaa","aa") â†’ false
isMatch("aa", "*") â†’ true
isMatch("aa", "a*") â†’ true
isMatch("ab", "?*") â†’ true
isMatch("aab", "c*a*b") â†’ false
*/


class leetcode_Wildcard_Matching {
    public static void main(String[] args) {
        isMatch("", "*");
    }
    public static boolean isMatch(String s, String p) {
        // The idea behind this is basically same as Regular_Expression_Matching.
        boolean[] prev = new boolean[p.length() + 1];
        prev[0] = true;
        for (int i = 0; i < p.length(); ++i) {
            if (p.charAt(i) == '*') {
                prev[i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            char charS = s.charAt(i);
            boolean[] next = new boolean[p.length() + 1];
            for (int j = 0; j < p.length(); ++j) {
                char charP = p.charAt(j);
                if (charS == charP || charP == '?') {
                    // '?' Matches any single character.
                    next[j + 1] = prev[j];
                } else if (charP == '*') {
                    // '*' Matches any sequence of characters (including the empty sequence).
                    next[j + 1] = next[j] || prev[j] || prev[j + 1];
                } else {
                    // Mismatch. This else is not necessary because the default is false.
                    next[j + 1] = false;
                }
            }
            prev = next;
        }
        return prev[prev.length - 1];
    }
}
