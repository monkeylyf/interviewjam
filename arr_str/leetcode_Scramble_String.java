/*Scramble_String

Given a string s1, we may represent it as a binary tree by partitioning it to
two non-empty substrings recursively.
Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t

To scramble the string, we may choose any non-leaf node and swap its two
children.
For example, if we choose the node "gr" and swap its two children, it
produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t

We say that "rgeat" is a scrambled string of "great".
Similarly, if we continue to swap the children of nodes "eat" and "at", it
produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a

We say that "rgtae" is a scrambled string of "great".
Given two strings s1 and s2 of the same length, determine if s2 is a scrambled
string of s1.
*/

class leetcode_Scramble_String {
    public static void main(String[] args) {
        //System.out.println(isScramble("abcde", "bacdef"));
        System.out.println(isScramble("great", "rgtae"));
    }
    public static boolean isScramble(String s1, String s2) {
        // The idea behind is swapping.
        int n = s1.length();
        if (n == 1) {
            return s1.equals(s2);
        } else {
            for (int i = 1; i <= s2.length() / 2; i++) {
                if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                    return true;
                }
                if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                    return true;
                }
                if (isScramble(s1.substring(n - i), s2.substring(0, i)) &&
                    isScramble(s1.substring(0, n - i), s2.substring(i))) {
                    return true;
                }
                if (isScramble(s1.substring(n - i), s2.substring(n - i)) && 
                    isScramble(s1.substring(0, n - i), s2.substring(0, n - i))) {
                    return true;
                }
            }
            return false;
        }
    }
}
