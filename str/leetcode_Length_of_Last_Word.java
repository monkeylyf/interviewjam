/*Length_of_Last_Word

Given a string s consists of upper/lower-case alphabets and empty space
characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
For example, 
Given s = "Hello World",
return 5.*/


class leetcode_Length_of_Last_Word {
    public static void main(String[] args) {
    }
    public static int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char cur = s.charAt(i);
            if (cur != ' ') {
                ++count;
            } else {
                if (count != 0) break;
            }
        }
        return count;
    }
    public int lastWord(String s) {
        // Interviewer might want you not to use the split method,
        // but this might be better.
        String[] arr = s.split(" ");
        if (arr.length == 0) return 0;
        else return arr[arr.length - 1].length();
    }
}
