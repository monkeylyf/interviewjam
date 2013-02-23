/*Implement_strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if
needle is not part of haystack.
*/


class leetcode_Implement_strStr {
    public static void main(String[] args) {
        strStr("mississippi", "issip");
    }
    public static String strStr(String haystack, String needle) {
        // KMP algorithm O(m+n)is better than this one O(m * n)
        if (needle == "") {
            return haystack;
        }
        if (haystack.length() < needle.length()) {
            return null;
        }
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
                if (j == needle.length()) {
                    return haystack.substring(i - j);
                }
            } else {
                i = i - j + 1; // Jump back to char right after the first char match.
                j = 0;
            }
        }
        return null;
    }
}
