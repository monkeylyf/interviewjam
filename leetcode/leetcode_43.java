/*Write a function to find the longest common prefix string amongst an array of strings.
*/


class leetcode_43 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"abab","aba","abc"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            String longer;
            String shorter;
            int count = 0;
            if (res.length() > strs[i].length()) {
                longer = res;
                shorter = strs[i];
            } else {
                longer = strs[i];
                shorter = res;
            }
            for (int j = 0; j < shorter.length(); ++j) {
                if (shorter.charAt(j) == longer.charAt(j)) ++count;
                else break;
            }
            res = shorter.substring(0, count);
        }
        return res;
    }
}
