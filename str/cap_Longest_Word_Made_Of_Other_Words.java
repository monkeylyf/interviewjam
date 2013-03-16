/*Longest_Word_Made_Of_Other_Words
careercup

Write a program to find the longest word made of other words
*/


import java.util.*;


class cap_Longest_Word_Made_Of_Other_Words {
	public static void main(String[] args) {
        System.out.println(findLongestWord(new String[] {"wohaojimo", "stoop", "shit"}, new String[] {"sto", "op", "shit", "dump", "oo"}));
	}
    public static String findLongestWord(String[] words, String[] dict) {
        // This problem can be solved by dp.
        // Pre-processing dict to HashSet.
        HashSet<String> set = new HashSet<String>();
        for (String str : dict) {
            set.add(str);
        }
        Arrays.sort(words);
        for (int i = words.length - 1; i >= 0; --i) {
            String word = words[i];
            if (isMadeOfOtherWords(word, set)) {
                return word;
            }
        }
        return null;
    }
    public static boolean isMadeOfOtherWords(String word, HashSet<String> set) {
        if (word == null || word.length() == 0) {
            return false;
        } else if (set.contains(word)) {
            return true;
        } else {
            for (int i = 1; i < word.length(); ++i) {
                if (isMadeOfOtherWords(word.substring(0, i), set) && isMadeOfOtherWords(word.substring(i), set)) {
                    return true;
                }
            }
            return false;
        }
    }
}
