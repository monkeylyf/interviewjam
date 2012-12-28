/*Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
For example,
Given:
s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/


class leetcode_37 {
    public static void main(String[] args) {
        System.out.println(isInterleave("a", "", "a"));
        System.out.println(isInterleave("a", "b", "ab"));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        return nextChar(s1, s2, s3);
    }
    public static boolean nextChar(String s1, String s2, String s3) {
        if (s1.length() == 0) return s2.equals(s3);
        else if (s2.length() == 0) return s1.equals(s3);
        else if (s3.length() == 0) return (s1.length() == 0 && s2.length() == 0);

        char s3LastChar = s3.charAt(s3.length() - 1);
        boolean s1Path = false;
        boolean s2Path = false;
        if (s1.charAt(s1.length() - 1) == s3LastChar) {
            s1Path = nextChar(s1.substring(0, s1.length() - 1), s2, s3.substring(0, s3.length() - 1));
        }
        if (s2.charAt(s2.length() - 1) == s3LastChar) {
            s2Path = nextChar(s1, s2.substring(0, s2.length() - 1), s3.substring(0, s3.length() - 1));
        }
        return s1Path || s2Path;
    }
}
