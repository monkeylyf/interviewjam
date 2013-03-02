/*Knuth-Morris-Pratt algorithm

Given string A, target string B, return the occurrences of target
string B in A.
*/


class KMP {
    public static void main(String[] args) {
        //System.out.println(kmp("abababaababacb", "ababacb"));
        System.out.println(kmp("abababaababacb", "abcabcd"));
    }
    public static int kmp(String A, String target) {
        // e.g., target = "abaabcaba"
        // a        -1
        // ab       -1
        // aba       0
        // - -
        // abaa      0
        // -  -
        // abaab     1
        // -- --
        // abaabc   -1
        // abaabca   0
        // -     -
        // abaabcab  1
        // --    --
        // abaabcaba 2
        // ---   ---
        // abaabcabac 
        int[] overlay = new int[target.length()];
        overlay[0] = -1;
        for (int i = 1; i < target.length(); ++i) {
            // This part is db-based.
            int index = overlay[i - 1]; // Fetching index of previous substring's pattern.
            while (index >= 0 && target.charAt(i) != target.charAt(index + 1)) {
                // index == -1: End loop. For current substring, no previous found pattern
                // target.charAt(i) != target.charAt(index + 1): there is prev pattern
                // but next char of match substring is different.
                index = overlay[index]; // This is tricky
                // If this statement is executed. we know index >= 0
                // we know that for substring.(0, i - 1), first index substring equals to
                // last index substring. x1,x2,x3,..., x7,x8,x9
                // if for substring x1, x2, x3 there is a pattern, x1 = x3
                // then x1 = x3 = x7 = x9, x1 = x9 is what we what, we get the 
                // longest pattern for cur substring x1...x9.
                // then we continue to check if x1 == x10.
            }
            if (target.charAt(i) == target.charAt(index + 1)) {
                // if this condition ends the while loop above,
                // we got a match char. 
                overlay[i] = index + 1;
            } else {
                // The while loop above no char match.
                // And the loop already checked all the pattern found before.
                overlay[i] = -1;
            }
        }
        for (int i  = 0; i < target.length(); ++i) {
            System.out.println(target.substring(0, i + 1) + " " + overlay[i]);
        }
        int i = 0; // Pointer for A.
        int j = 0; // Pointer for target.
        while (i < A.length() && j < target.length()) {
            // Try to find i, j, so:
            // A.substring(i - j, i + 1) == target.substring(0, j + 1)
            if (A.charAt(i) == target.charAt(j)) {
                ++i;
                ++j;
            } else if (j == 0) {
                // first char of A.substr is not equal to first char of target
                // no need to check the rest of chars in substr.
                ++i; // Point to the next char of A.
            } else {
                // Try to find a new j which is less than current j
                // so A.substring(i - j, i + 1) == target.substring(0, j + 1)
                j = overlay[j - 1] + 1;
            }
        }
        if (j == target.length()) {
            return i - j;
        } else {
            return -1;
        }
    }
}
