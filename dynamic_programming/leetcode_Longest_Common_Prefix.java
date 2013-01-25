/*Longest_Common_Prefix

Given a string S, find the longest palindromic substring in S. You may assume
that the maximum length of S is 1000, and there exists one unique longest
palindromic substring.
*/

class leetcode_Longest_Common_Prefix {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abadd"));
    }
    public static String longestPalindrome(String s) {
        // Reverse the input String then the problem becomes
        // the famous "longest common substring".
        if (s.length() == 0) {
            return "";
        }
        String reverse = "";
        for (int i = 0; i < s.length(); ++i) {
            reverse = s.charAt(i) + reverse;
        }
        return longestCommonSubstring(s, reverse);
    }
    public static String longestCommonSubstring(String a, String b) {
        // dp-based method.
        int longestSubstring = 0;
        int index = 0;
        int[] track = new int[a.length() + 1];
        for (int i = 0; i < b.length(); ++i) {
            int[] nextTrack = new int[a.length() + 1];
            for (int j = 0; j < a.length(); ++j) {
                // C(a, b) = C(a.substr(0,len-1), b.substr(0, len-1)) + 1 (if a.lastChar == b.lastChar)
                //           0      (if a.lastChar != b.lastChar)
                if (a.charAt(j) == b.charAt(i)) {
                    nextTrack[j + 1] = track[j] + 1;
                } else {
                    nextTrack[j + 1] = 0;
                }
            }
            track = nextTrack;
            // Iterater to find the largest.
            for (int h = 0; h <= a.length(); ++h) {
                if (track[h] > longestSubstring) {
                    longestSubstring = track[h];
                    index = h;
                } 
            }
        }
        return a.substring(index - longestSubstring, index); 
    }
}
