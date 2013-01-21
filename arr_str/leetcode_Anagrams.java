/*Anagrams

Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

class leetcode_Anagrams {
    public static void main(String[] args) {
        anagrams(new String[] {"tea","and","ace","ad","eat","dans"});
    }
    public static ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> all = new ArrayList<String>();
        Hashtable<String, ArrayList<Integer>> dict = new Hashtable<String, ArrayList<Integer>>();
        ArrayList<Integer> tmp;
        for (int i = 0; i < strs.length; ++i) {
            String sorted = Sort(strs[i]);
            if (!dict.containsKey(sorted)) {
                tmp = new ArrayList<Integer>();
                tmp.add(i);
                dict.put(sorted, tmp);
            } else {
                ArrayList<Integer> arr = dict.get(sorted);
                arr.add(i);
                dict.put(sorted, arr);
            }
        }
        Set set = dict.keySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            String str = (String) itr.next();
            if (dict.get(str).size() > 1) {
                for (int i : dict.get(str)) all.add(strs[i]);
            }
        }
        return all;
    }
    public static String Sort(String a) {
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
