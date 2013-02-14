/*Word_Ladder_II

Given two words (start and end), and a dictionary, find all shortest
transformation sequence(s) from start to end, such that:
Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
      ["hit","hot","dot","dog","cog"],
      ["hit","hot","lot","log","cog"]
  ]
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;


class leetcode_Word_Ladder_II {
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        Collections.addAll(dict, "ted","tex","red","tax","tad","den","rex","pee");
        //System.out.println(findLadders("hot", "dog", dict));
        my("red", "tax", dict);
    }
    public static ArrayList<ArrayList<String>> my(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
        Queue<String> unvisited = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        Hashtable<String, String> path = new Hashtable<String, String>();
        unvisited.add(start); // Init unvisited queue.
        visited.add(start);
        int count = 1; // Counter for the number of unvisited node at next level.
        boolean isShortestLevel = false;
        while (!unvisited.isEmpty()) {
            String str = unvisited.remove();
            System.out.println("current String " + str);
            for (String cur : generate(str, dict)) {
                if (cur.equals(end)) {
                    System.out.println("Found end " + cur);
                    ArrayList<String> res = new ArrayList<String>();
                    res.add(cur);
                    while (str != null) {
                        res.add(0, str);
                        str = path.get(str);
                    }
                    isShortestLevel = true;
                    System.out.println(res);
                    all.add(res);
                } else if (!visited.contains(cur)) {
                    unvisited.add(cur);
                    // Mark start as visited. If one of a string's one-char-diff strings
                    // equals it, make sure don't jump to it since we need the shortest
                    // path. no looping.
                    System.out.println("Add key: " + cur + " pair: " + str);
                    visited.add(cur);
                    path.put(cur, str);
                }
            }
            if (--count == 0) { // Done with the cur level.
                System.out.println("changing level");
                count = unvisited.size(); // Reset counter.
                if (isShortestLevel) { // Done with all unvisited node in shortest level then return.
                    for (ArrayList<String> i : all) System.out.println(i);
                    return all;
                }
            }
        }
        return all;
    }
    public static HashSet<String> generate(String s, HashSet<String> dict){
        HashSet<String> words = new HashSet<String>();
        for(int i = 0; i < s.length(); ++i){
            for(char j = 'a'; j <= 'z'; ++j){
                char[] chs = s.toCharArray();
                if(chs[i] != j ){
                    chs[i] = j;
                    String ns = new String(chs);
                    if(dict.contains(ns))
                        words.add(ns);
                }
            }
        }
        return words;
    }
    public static int ladderLength(String start, String end, HashSet<String> dict) {
        // The idea behind this is Depth first search. And this will not pass leetcode
        // onlinejudge Judge Large. Before the func jumps into the next recursion, it
        // iterates through all element in dict, which is extremly inefficient when the
        // size of dict is large.
        // BFS is more efficient because. For each char in given word we find out the
        // potential change by one char, then there is (26 - 1) * word.length() then check
        // if they are in dict (time complexity should be O(1)), which is much smaller than
        // iterating through dict to find the word differed by one char ( time complexity: 
        // dict.size() * word.length())
        // change on char of given word then look it up in dict VS iterate through dict and
        // find the one with one char diff.
        ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmp = new ArrayList<String>();
        tmp.add(start);
        int[] shortest = new int[] {Integer.MAX_VALUE};
        nextChange(start, end, dict, all, tmp, shortest);
        for (ArrayList<String> i : all) {
            System.out.println(i);
        }
        return shortest[0] + 1;
    }
    public static void nextChange(String start, String end, HashSet<String> dict, ArrayList<ArrayList<String>> all, ArrayList<String> tmp, int[] shortest) {
        if (diffByOneChar(start, end)) {
            if (tmp.size() <= shortest[0]) {
                ArrayList<String> answer = new ArrayList<String>();
                for (String i : tmp) {
                    answer.add(i);
                }
                answer.add(end);
                if (tmp.size() < shortest[0]) {
                    all.clear();
                    shortest[0] = tmp.size();
                }
                all.add(answer);
            }
        } else {
            ArrayList<String> mark = new ArrayList<String>();
            Iterator itr = dict.iterator();
            while (itr.hasNext()) {
                String str = (String) itr.next();
                if (diffByOneChar(str, start)) {
                    mark.add(str);
                }
            }
            for (String str : mark) {
                dict.remove(str);
                tmp.add(str);
                nextChange(str, end, dict, all, tmp, shortest);
                tmp.remove(tmp.size() - 1);
                dict.add(str);
            } 
        }
    }
    public static boolean diffByOneChar(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            int diff = 0;
            for (int i = 0; i < a.length(); ++i) {
                if (a.charAt(i) != b.charAt(i)) {
                    ++diff;
                }
                if (diff > 1) {
                    return false;
                }
            }
            return diff == 1;
        }
    }
    // Still can not pass the onlinejudge Judge Large.
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmp = new ArrayList<String>();
        tmp.add(start);
        int[] shortest = new int[] {Integer.MAX_VALUE};
        nextChar(start, end, dict, all, tmp, shortest);
        for (ArrayList<String> i : all) {
            System.out.println(i);
        }
        return all;
    }
    public static void nextChar(String start, String end, HashSet<String> dict, ArrayList<ArrayList<String>> all, ArrayList<String> tmp, int[] shortest) {
        if (diffByOneChar(start, end)) {
            if (tmp.size() <= shortest[0]) {
                ArrayList<String> answer = new ArrayList<String>();
                for (String i : tmp) {
                    answer.add(i);
                }
                answer.add(end);
                if (tmp.size() < shortest[0]) {
                    all.clear();
                    shortest[0] = tmp.size();
                }
                all.add(answer);
            }
        } else if (tmp.size() < shortest[0]) {
            for (String j : diffByGivenChar(start)) {
                if (dict.contains(j)) {
                    dict.remove(j);
                    tmp.add(j);
                    nextChar(j, end, dict, all, tmp, shortest);
                    tmp.remove(tmp.size() - 1);
                    dict.add(j);
                }
            }
        }
    }
    public static HashSet<String> diffByGivenChar(String word) {
        HashSet<String> all = new HashSet<String>();        
        for (int i = 0; i < word.length(); ++i) {
            char[] arr = word.toCharArray();
            for (char j = 'a'; j <= 'z'; ++j) {
                if (word.charAt(i) != j) {
                    arr[i] = j;
                    all.add(new String(arr));
                }
            }
        }
        return all;
    }
}
