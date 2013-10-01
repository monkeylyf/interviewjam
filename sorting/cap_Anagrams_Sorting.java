/*Anagrams_Sorting
careercup

Write a method to sort an array of strings so that all the anagrams are next
to each other
*/


import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;


public class cap_Anagrams_Sorting {

	public static void main(String[] args) {
		String[] a = {"aba", "ag", "aab", "c", "baa", "ga"};
		for (String i : a) System.out.print(i + " ");
		System.out.println();
        System.out.println(sortingAnagram(a));
	}

    public static ArrayList<String> sortingAnagram(String[] A) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        ArrayList<String> retval = new ArrayList<String>();
        for (int i = 0; i < A.length; ++i) {
            String sorted = sortChars(A[i]);
            if (map.containsKey(sorted)) {
                ArrayList<Integer> tmp = map.get(sorted);
                tmp.add(i);
                map.put(sorted, tmp);
            } else {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                map.put(sorted, tmp);
            }
        }
        for (String i : map.keySet()) {
            ArrayList<Integer> tmp = map.get(i);
            for (int j : tmp) {
                retval.add(A[j]);
            }
        }
        return retval;
        
    }

	public static String sortChars(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
