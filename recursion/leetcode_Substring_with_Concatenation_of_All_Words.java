/*Substring_with_Concatenation_of_All_Words

You are given a string, S, and a list of words, L, that are all of the same
length. Find all starting indices of substring(s) in S that is a concatenation
of each word in L exactly once and without any intervening characters.
For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
*/

import java.util.ArrayList;
import java.util.HashSet;


public class leetcode_Substring_with_Concatenation_of_All_Words {

    public static void main(String[] args) {
        findSubstring("sheateateseatea", new String[] {"sea","tea","ate"});
    }

    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        // The idea behind this is to get all possible permutations of given set.
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashSet<String> all = new HashSet<String>();
        int len = L[0].length() * L.length; // The length of given words do not need to be same.
        nextString(L, all, "" );
        for (int i = 0; i <= S.length() - len; ++i) {
            if (all.contains(S.substring(i, i + len))) {
                res.add(i);
            }
        }
        return res;
    }

    public static void nextString(String[] L, HashSet<String> all, String acc) {
        if (L.length == 0) {
            all.add(acc);
        } else {
            for (int i = 0; i < L.length; ++i) {
                nextString(removedEle(L, i), all, acc + L[i]);
            }
        }
    }

    public static String[] removedEle(String[] L, int index) {
        String[] res = new String[L.length - 1];
        int j = 0;
        for (int i = 0; i < L.length; ++i) {
            if (i != index) {
                res[j] = L[i];
                ++j;
            }
        }
        return res;
    }
}
