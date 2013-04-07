/*Anagrams

Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case.
*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

class leetcode_Anagrams {
    public static void main(String[] args) {
        anagrams(new String[] {"tea","and","ace","ad","eat","dans"});
    }
    public static ArrayList<String> anagrams(String[] strs) {
        String anagram;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        char[] arr;
        ArrayList<String> tmp;
        for (String i : strs) {
            // Sort char array then converted to string to detect anagram.
            arr = i.toCharArray();
            Arrays.sort(arr);
            anagram = new String(arr);
            // Update cache.
            tmp = (map.containsKey(anagram)) ? map.get(anagram) : new ArrayList<String>();
            tmp.add(i);
            map.put(anagram, tmp);
        }
        ArrayList<String> ret = new ArrayList<String>();
        for (ArrayList<String> iter : map.values()) {
            // Traverse cache to find anagram group who has more than one menber.
            if (iter.size() > 1) {
                ret.addAll(iter);
            }
        }
        return ret;
    }
}
