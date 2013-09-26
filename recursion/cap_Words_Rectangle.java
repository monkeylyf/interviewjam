/*Words_Rectangle
careercup

Given a dictionary of millions of words, give an algorithm to find the
largest possible rectangle of letters such that every row forms a word (reading
left to right) and every column forms a word (reading top to bottom)
*/

import java.util.*;


public public class cap_Words_Rectangle {

    public static void main(String[] args) {
        // Unit tests;
        ArrayList<String> dict = new ArrayList<String>();
        Collections.addAll(dict, "shit", "fuck", "dude", "word",
								 "list", "hoop", "lamp", "pond",
								 "heap", "wfts", "tank", "ouah",
								 "rcni", "dkkt");
        WordsRectangle solution = new WordsRectangle(dict);
        System.out.println(solution.largestRectangle());
    }
}


class WordsRectangle {

    public HashMap<Integer, ArrayList<String>> dict;
    public ArrayList<Integer> lens;
    public PriorityQueue<Area> priorityQueue;

    WordsRectangle(ArrayList<String> arr) { // Constructor.
        this.priorityQueue = new PriorityQueue<Area>();
        this.dict = new HashMap<Integer, ArrayList<String>>();
        this.lens = new ArrayList<Integer>();
        // Pre-processing dict.
        for (String str : arr) {
            int len = str.length();
            ArrayList<String> tmp = null;
            if (this.dict.containsKey(len)) {
                tmp = this.dict.get(len);
            } else {
                tmp = new ArrayList<String>();
            }
            tmp.add(str);
            this.dict.put(len, tmp);
        }
        this.lens.addAll(this.dict.keySet());
        for (int i : this.lens) {
            for (int j : this.lens) {
                this.priorityQueue.offer(new Area(i, j)); // Priority queue for possible rectangles.
            }
        }
    } // End of contructor.

    public int largestRectangle() {
        while (!this.priorityQueue.isEmpty()) {
            Area cur = this.priorityQueue.poll(); // Pop the largest rectangle with largest area.
            if (isValidRectangle(cur.length, cur.width)) { // Check if it can makes a valid rectangle.
                return cur.area;
            }
        }
        return 0;
    }

    private boolean isValidRectangle(int n, int m) {
        ArrayList<String> arr = new ArrayList<String>(this.dict.get(n));
        boolean[] used = new boolean[arr.size()];
        Trie suffix = new Trie(new ArrayList<String>(this.dict.get(m)));
        return fillNextRow(new char[n][m], arr, 0, suffix, used);
    }

    private boolean fillNextRow(char[][] rect, ArrayList<String> arr, int curRowIndex, Trie suffix, boolean[] used) {
        // DFS.
        if (curRowIndex == rect.length) {
            return true; 
        } else {
            for (int i = 0; i < arr.size(); ++i) {
                if (!used[i]) {
                    rect[curRowIndex] = arr.get(i).toCharArray();
                    used[i] = true;
                    if (isValidRect(rect, suffix, curRowIndex)) {
                        if (fillNextRow(rect, arr, curRowIndex + 1, suffix, used)) {
                            return true;
                        }
                    }
                    rect[curRowIndex] = new char[rect[0].length];
                    used[i] = false;
                }
            }
            return false;
        }
    }

    private boolean isValidRect(char[][] rect, Trie suffix, int curRowIndex) {
        // Using suffix tree to verify rectangle.
        for (int j = 0; j < rect[0].length; ++j) {
            String str = "";
            for (int i = 0; i <=curRowIndex; ++i) {
                str += rect[i][j] + "";
            }
            if (suffix.getIndexes(str) == null) {
                check();
                return false;
            }
        }
        return true;
    }

    public void print(char[][] m) {
        for (int i = 0; i < m.length; ++i) {
            for (Character c : m[i]) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


class Area implements Comparable<Area> {
    public int length;
    public int width;
    public int area;
    Area(int i, int j) {
        this.length = i;
        this.width = j;
        this.area = i * j;
    }
    public int compareTo(Area obj) {
        return obj.area - this.area;
    }
}


class Trie {
    TrieNode root;
    Trie(ArrayList<String> arr) {
        root = new TrieNode();
        for (String str : arr) {
            for (int i = 0; i < str.length(); ++i) {
                root.insert(str.substring(i), i);
            }
        }
    }
    public ArrayList<Integer> getIndexes(String s) {
        return root.getIndexes(s);
    }
}


class TrieNode {
    public HashMap<Character, TrieNode> kids;
    public ArrayList<Integer> indexes; // I am not sure if i need this here.
    char val;
    TrieNode() {
        this.kids = new HashMap<Character, TrieNode>();
        this.indexes = new ArrayList<Integer>();
    }
    public void insert(String s, int index) {
        if (s == null || s.length() <= 0) {
            return;
        }
        this.indexes.add(index);
        this.val = s.charAt(0);
        TrieNode child = null;
        if (this.kids.containsKey(this.val)) {
            child = kids.get(this.val);
        } else {
            child = new TrieNode();
            kids.put(this.val, child);
        }
        child.insert(s.substring(1), index);
    }
    public ArrayList<Integer> getIndexes(String s) {
        if (s == null || s.length() == 0) {
            return this.indexes;
        } else {
            char first = s.charAt(0);
            if (this.kids.containsKey(first)) {
                return this.kids.get(first).getIndexes(s.substring(1));
            }
        }
        return null;
    }
}
