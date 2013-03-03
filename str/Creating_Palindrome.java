/*Creating_Palindrome

Given a String s, you are allowed to add one character at any position within this string.
How many operertions do you need to create a palindrome work with the given string?
*/


class Creating_Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome("abc"));
        System.out.println(palindrome("abcc"));
        System.out.println(palindrome("abccb"));
        System.out.println(palindrome("abccba"));
    }
    public static int palindrome(String s) {
        int n = s.length();
        int[][] status = new int[n][n];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                status[i][j] = (s.charAt(i) == s.charAt(j)) ? status[i + 1][j - 1] : 1 + Math.min(status[i + 1][j], status[i][j - 1]);
            }
        }
        return status[0][n - 1];
    }
}
