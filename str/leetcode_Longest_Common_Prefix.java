/*Longest_Common_Prefix

Write a function to find the longest common prefix string amongst an array of strings.
*/


class leetcode_Longest_Common_Prefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"abab","aba","abc"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }   
        String res = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            int j = 0;
            for (; j < res.length() && j < strs[i].length(); ++j) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
        }
        return res;
    }
}
