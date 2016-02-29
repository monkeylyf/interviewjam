/**
 * Substring_with_Concatenation_of_All_Words.
 * leetcode
 *
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a concatenation
 * of each word in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class leetcode_Substring_with_Concatenation_of_All_Words {

  public static void main(String[] args) {
    leetcode_Substring_with_Concatenation_of_All_Words solution = new
      leetcode_Substring_with_Concatenation_of_All_Words();
	List<Integer> res = solution.findSubstring(
      "sheateateseatea", new String[] {"sea","tea","ate"});

    System.out.println(res);
  }

  public List<Integer> findSubstring(String S, String[] L) {
	List<Integer> ret = new ArrayList<>();
	Map<String, Integer> dict = new HashMap<>();
	for (String str : L) {
	  if (dict.containsKey(str)) {
		dict.put(str, dict.get(str) + 1);
	  } else {
		dict.put(str, 1);
	  }
	}

	Map<String, Integer> map = copy(dict);

	int strLen = L[0].length();
	for (int i = 0; i <= S.length() - L.length * strLen; ++i) {
	  for (int j = 0; j < L.length; ++j) {
		String str = S.substring(i + j * strLen, i + (j + 1) * strLen);
		if (map.containsKey(str)) {
		  Integer count = map.get(str);
		  if (count < 0) {
			break;
		  } else {
			map.put(str, count - 1);
		  }
		}
	  }
	  boolean zero = true;
	  for (Integer val : map.values()) {
		if (val != 0) {
		  zero = false;
		  break;
		}
	  }
	  if (zero) {
		ret.add(i);
	  }
	  map = copy(dict);
	}

	return ret;
  }

  public Map<String, Integer> copy(Map<String, Integer> map) {
	Map<String, Integer> ret = new HashMap<>();
	for (String key : map.keySet()) {
	  ret.put(key, map.get(key));
	}

	return ret;
  }

  /*The solution below is obsolete.
  public List<Integer> findSubstring(String S, String[] L) {
	// The idea behind this is to get all possible permutations of given set.
	List<Integer> res = new ArrayList<>();
	Set<String> all = new HashSet<String>();
	int len = L[0].length() * L.length; // The length of given words do not need to be same.
	nextString(L, all, "" );
	for (int i = 0; i <= S.length() - len; ++i) {
	  if (all.contains(S.substring(i, i + len))) {
		res.add(i);
	  }
	}
	return res;
  }

  public static void nextString(String[] L, Set<String> all, String acc) {
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
  */
}


/* Python Version
Ok, couple of notes here.
1. O(len(S) * len)
2. L might contain the mutilple same items in it, like ['a', 'b', 'a'] so hashset won't work.
3. Given 2, key/value pair(dict) is create to track the # of appearance, However, leetcode
   clearly does not support 'from copy import deepcopy' and reset the freq is really neccesary.
   Looks like manually copy is faster than recreate the dict


class Solution:
    # @param S, a string
    # @param L, a list of string
    # @return a list of integer
    def findSubstring(self, S, L):
        ret = []
        c = self.count(L)
        used = self.copy(c)
        i = 0
        length = len(L[0])

        while i <= len(S) - len(L) * length:
            for j in xrange(len(L)):
                token = S[i + j * length : i + (j + 1) * length ]
                if token in used and used[token] > 0:
                    used[token] -= 1
                else:
                    break

            #print used.values()
            if not any(used.values()):
                ret.append(i)
                i += length # Why step is length or 1?? Looks like length works. How to prove?
            else:
                i += 1
            used = self.copy(c)

        return ret

    def copy(self, d):
        ret = {}
        for key, value in d.iteritems():
            ret[key] = value
        return ret

    def count(self, L):
        used = {}
        for item in L:
            try:
                used[item] += 1
            except KeyError:
                used[item] = 1
        return used
*/
