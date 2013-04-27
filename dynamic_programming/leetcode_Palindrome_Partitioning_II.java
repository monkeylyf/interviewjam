/*Palindrome_Partitioning_II

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/


class leetcode_Palindrome_Partitioning_II {
    public static void main(String[] args) {
        System.out.println(toPalindrome("tattarrattat")); 
        System.out.println(toPalindrome1("tattarrattat")); 
        System.out.println(toPalindrome("abbaa")); 
        System.out.println(toPalindrome1("abbaa")); 
        System.out.println(toPalindrome("babcbabcbaccba")); 
        System.out.println(toPalindrome1("babcbabcbaccba")); 
        //System.out.println(allPalindrome("abbab")); 
    }
    public static int toPalindrome(String A) {
        // Time complexity O(N^3).
        int[] status = new int[A.length()];
        for (int i = 1; i < A.length(); ++i) {
            if (isPalindrome(A.substring(0, i + 1))) {
                status[i] = 0; // Cur substr is palindrome, 0 cut.
            } else {
                int minCut = Integer.MAX_VALUE;
                for (int j = 1; j <= i; ++j) {
                    if (isPalindrome(A.substring(j, i + 1))) {
                        // iterator through all substr end with index i
                        // Record the min cut number for rest of cur string.
                        minCut = Math.min(minCut, status[j - 1]);
                    }
                    status[i] = minCut + 1;
                }
            }
        }
        return status[status.length - 1];
    }

    public static int toPalindrome1(String str) {
        // Time complex O(N^2) but need extra O(N^2) space 
        int n = str.length(), i, j;
        boolean[][] dp = new boolean[n][n];
        // init dp state.
        for (i = 0; i < n; ++i) {
            dp[i][i] = true;
        }
        // palindrome dp matrix.
        for (i = n - 2; i >= 0; --i) {
            // check for string of length equals 2.    
            dp[i][i + 1] = (str.charAt(i) == str.charAt(i + 1)) ?  true : false;
            for (j = i + 2; j < n; ++j) {
                // check for string of length more than 2.
                dp[i][j] = (str.charAt(i) == str.charAt(j)) ? dp[i + 1][j - 1] : false;
            }
        }
        int[] status = new int[n];
        for (i = 1; i < n; ++i) {
            if (dp[0][i]) {
                status[i] = 0; // is str.substring(0,i+1) is palindrome, needs 0 cut.
            } else {
                status[i] = status[i - 1] + 1; // cut init.
                for (j = 1; j < i; ++j) {
                    status[i] = (dp[j][i]) ? Math.min(status[i], status[j - 1] + 1) : status[i];
                }
            }
        }
        return status[n - 1];
    }
    public static boolean isPalindrome(String A) {
        int head = 0, tail = A.length() - 1;
        while (head <= tail) {
            if (A.charAt(head) == A.charAt(tail)) {
                ++head;
                --tail;
            } else {
                return false;
            }
        }
        return true;
    }
    // Manacher algorithm.
    public static String preProcess(String s) {
        // "abba" ==> "^#a#b#b#a#$".
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        String ret = "^"; // Starting with "^"
        for (int i = 0; i < n; ++i) {
            ret += "#" + s.substring(i, i + 1);
        }
        ret += "#$"; // Ending with "$"
        return ret;
    }
    public static int[] allPalindrome(String A) {
        String T = preProcess(A);
        int n = T.length();
        int[] status = new int[n];
        int pivot = 0, radius = 0;
        for (int i = 1; i < n - 1; ++i) {
            int mirror = 2 * pivot - i; // pivot = (i + mirror) / 2. Find the symmetry point of i based on pivot.
            // radius > i, symmetry range is indexOfBoudary
            // radius <= i, set to 0.
            status[i] = (radius > i) ? Math.min(radius - i, status[mirror]) : 0;
            while (T.charAt(i + 1 + status[i]) == T.charAt(i - 1 - status[i])) {
                // expand if semmetry char is equal.
                ++status[i];
            }
            if (i + status[i] > radius) { // Updating pivot and radius.
                pivot = i;
                radius = status[i];
            }
        }
        return status;
    }
}
