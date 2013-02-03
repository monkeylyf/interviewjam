/*Text_Justification

Given an array of words and a length L, format the text such that each line has
exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as
you can in each line. Pad extra spaces ' ' when necessary so that each line has
exactly L characters.
Extra spaces between words should be distributed as evenly as possible. If the
number of spaces on a line do not divide evenly between words, the empty slots
on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is
inserted between words.
For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.
Return the formatted lines as:
[
   "This    is    an",
    "example  of text",
    "justification.  "
]
*/


import java.util.ArrayList;


class leetcode_Text_Justification {
    public static void main(String[] args) {
        String[] words = new String[] {"Here", "is", "an", "example", "of", "text", "justification."};
        fullJustify(new String[] {"What","must","be","shall","be."}, 12);
    }
    public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> str = new ArrayList<String>();
        String layer = words[0];
        str.add(words[0]);
        for (int i = 1; i < words.length; ++i) {
            if (layer.length() + 1 + words[i].length() <= L) {
                // As many as words with one space between each two word in a line.
                layer += " " + words[i];
                str.add(words[i]);
            } else {
                res.add(evenlyDistributed(str, L));
                layer = words[i];
                str = new ArrayList<String>();
                str.add(words[i]);
            }
        }
        // For the last line of text, it should be left justified and no extra space is
        // inserted between words.
        res.add(layer + new String(new char[L - layer.length()]).replace('\0', ' '));
        return res;
    }
    public static String evenlyDistributed(ArrayList<String> str, int L) {
        for (String word : str) {
            L -= word.length(); // How manay spaces.
        }
        if (str.size() == 1) {
            // A line other than the last line might contain only one word,
            // in this case, that line should be left-justified.
            return str.get(0) + new String(new char[L]).replace('\0', ' ');
        } else {
            int numOfSpace = str.size() - 1;
            int even = L / numOfSpace;
            int mod = L % numOfSpace;
            String res = "";
            for (int i = 0; i < numOfSpace; ++i) {
                int space = (i < mod) ? even + 1 : even; // How many trailing spaces current word should have.
                res += str.get(i) + new String(new char[space]).replace('\0', ' ');
            }
            return res + str.get(numOfSpace); // Last word have no trailing spaces.
        }
    }
}
