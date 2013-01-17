/*Text Justification

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


class leetcode_110 {
    public static void main(String[] args) {
        String[] words = new String[] {"Here", "is", "an", "example", "of", "text", "justification."};
        fullJustify(new String[] {"What","must","be","shall","be."}, 12);
    }
    public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<Integer> index = new ArrayList<Integer>();
        String layer = words[0];
        index.add(0);
        for (int i = 1; i < words.length; ++i) {
            if (layer.length() + 1 + words[i].length() <= L) {
                layer += " " + words[i];
                index.add(i);
            } else {
                res.add(evenlyDistributed(words, index, L));
                layer = words[i];
                index = new ArrayList<Integer>();
                index.add(i);
            }
        }
        // For the last line of text, it should be left justified and no extra space is
        // inserted between words.
        res.add(layer + new String(new char[L - layer.length()]).replace('\0', ' '));
        for (String i : res) System.out.println(i);
        return res;
    }
    public static String evenlyDistributed(String[] words, ArrayList<Integer> index, int L) {
        for (int i : index) {
            L -= words[i].length();
        }
        if (index.size() == 1) {
            return words[index.get(0)] + new String(new char[L]).replace('\0', ' ');
        } else {
            int numOfSpace = index.size() - 1;
            int[] space = new int[numOfSpace];
            int even = L / numOfSpace;
            for (int i = 0; i < space.length; ++i) {
                space[i] = even;
            }
            int mod = L % numOfSpace;
            int j = 0;
            while (mod > 0) {
                space[j] += 1;
                ++j;
                --mod;
            }
            String res = "";
            for (int i = 0; i < space.length; ++i) {
                res += words[index.get(i)] + new String(new char[space[i]]).replace('\0', ' ');
            }
            return res + words[index.get(numOfSpace)];
        }
    }
}
