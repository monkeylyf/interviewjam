/*Cutting_String_to_Palindrome

Given a string A, you can divide this string into several substrings.
Design an algorithm to find the minimun number of n, so that each substring
is palindrome

For example:
A = "abbab"
n = 1
"abba", "b"
*/


class Cutting_String_to_Palindrome {
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
    public static int toPalindrome1(String A) {
        // Time complex O(N^2) but need extra O(N^2) space 
        int n = A.length();
        int[] status = new int[n];
        boolean[][] palindrome = new boolean[n][n];
        // Precomputing.
        for (int i = 0; i < n; ++i) {
            palindrome[i][i] = true;
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                // dp-based.
                if (j - i == 1) {
                    palindrome[i][j] = (A.charAt(i) == A.charAt(j)) ? true : false;
                } else {
                    palindrome[i][j] = (A.charAt(i) == A.charAt(j) && palindrome[i + 1][j - 1]) ? true : false;
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            if (palindrome[0][i]) {
                status[i] = 0; // Cur substr is palindrome, 0 cut.
            } else {
                int minCut = Integer.MAX_VALUE;
                for (int j = 1; j <= i; ++j) {
                    if (palindrome[j][i]) {
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
    public static void printMatrix(boolean[][] A) {
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[i].length; ++j) {
                if (A[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
        System.out.println("----------");
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
