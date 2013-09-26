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
import java.util.HashMap;
import java.util.Iterator;


public class leetcode_Word_Ladder_II {

    public static void main(String[] args) {
        HashSet<String> dict1 = new HashSet<String>();
        Collections.addAll(dict1, "ted","tex","red","tax","tad","den","rex","pee");
        test("red", "tax", dict1);
        HashSet<String> dict2 = new HashSet<String>();
        Collections.addAll(dict2, "hot", "dot");
        test("hot", "hot", dict2);
    }

    public static ArrayList<ArrayList<String>> test(String start, String end, HashSet<String> dict) {
        // The idea behind this is BFS + caching paths.
        // Since the shortest path is asked for then DFS is not an efficienty way to solve this.
        // Need two HashMap path & tmPath, one for global path and another for path at current level.
        // Need two Queue curLevel & nextTovVisit to record graph level.
        HashMap<String, ArrayList<String>> path = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> tmpPath = new HashMap<String, ArrayList<String>>();
        Queue<String> curLevel = new LinkedList<String>();
        Queue<String> nextLevel = new LinkedList<String>();
        curLevel.add(start);
        boolean isShortestLevel = false;
        while (!curLevel.isEmpty()) {
            String str = curLevel.remove();
            for (int i = 0; i < start.length(); ++i) {
                for(char j = 'a'; j <= 'z'; ++j){
                    // Change the str then check if the dict contains it.
                    char[] chs = str.toCharArray();
                    chs[i] = j;
                    String oneCharDiff = new String(chs);
                    if (oneCharDiff.equals(str)) {
                        continue; // new string is exactly same as the unchanged.
                    }
                    if (oneCharDiff.equals(end)) {
                        isShortestLevel = true; // Reach the shortest path.
                    }
                    if (!path.containsKey(oneCharDiff) && dict.contains(oneCharDiff)) {
                        if (!tmpPath.containsKey(oneCharDiff)) {
                            ArrayList<String> arr = new ArrayList<String>();
                            arr.add(str);
                            tmpPath.put(oneCharDiff, arr);
                            nextLevel.add(oneCharDiff);
                        } else {
                            ArrayList<String> arr = tmpPath.get(oneCharDiff);
                            arr.add(str);
                            tmpPath.put(oneCharDiff, arr);
                        }
                    }
                }
            }
            if (curLevel.isEmpty()) {
                Queue<String> tmp = nextLevel; // Swap nextLevel and curLevel.
                nextLevel = curLevel;
                curLevel = tmp;
                path.putAll(tmpPath); // Move all paths hashed as this level to global path map.
                tmpPath = new HashMap<String, ArrayList<String>>(); // tmpPath.clear()
                if (isShortestLevel) {
                    return dfsPath(path, start, end); // Finished with level with shortest path. Start reconstructing path.
                }
            }
        }
        return new ArrayList<ArrayList<String>>();
    }

    public static ArrayList<ArrayList<String>> dfsPath(HashMap<String, ArrayList<String>> path, String start, String end) {
        // Standord DFS.
        ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
        ArrayList<String> one = new ArrayList<String>();
        one.add(start);
        nextPath(path, start, end, all, one, 0);
        for (ArrayList<String> i : all) System.out.println(i);
        return all;
    }

    public static void nextPath(HashMap<String, ArrayList<String>> path, String start, String end, ArrayList<ArrayList<String>> all, ArrayList<String> one, int level) {
        // :param level: type int. for corner cases like "hot", "hot", ["hot", "dot"]
        // At the first level start might equal to end, but the recursion should keep going.
        if (end.equals(start) && level > 0) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (String i : one) {
                tmp.add(i);
            }
            all.add(tmp);
        } else {
            one.add(1, end);
            for (String i : path.get(end)) {
                nextPath(path, start, i, all, one, level + 1);
            }
            one.remove(1);
        }
    }
}
