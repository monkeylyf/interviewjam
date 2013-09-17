/*Boggle

Boggle game
http://en.wikipedia.org/wiki/Boggle
*/

import java.util.*;


public class Boggle {

    public static void main(String[] args) {
        testSuite1();
        testSuite2();
    }
    
    public static void testSuite2() {
        HashSet<String> dict = new HashSet<String>();
        Collections.addAll(dict, "cat", "cate", "apple", "pear", "haha", "great");
        char[][] board = { { 'a', 'b', 'c', 'd' }, { 'v', 'r', 'a', 'f' },
                { 'j', 't', 'e', 'p' }, { 'k', 'g', 'r', 'o' } };
        long t1 = System.currentTimeMillis();
        System.out.println(boggleWithTrie(board, dict));
        System.out.println("Time cost of testSuite2: " + (System.currentTimeMillis() - t1)
                / 1000.0 + " secs");
    }

    public static void testSuite1() {
        HashSet<String> dict = new HashSet<String>();
        Collections.addAll(dict, "cat", "cate", "apple", "pear", "haha", "great");
        char[][] board = { { 'a', 'b', 'c', 'd' }, { 'v', 'r', 'a', 'f' },
                { 'j', 't', 'e', 'p' }, { 'k', 'g', 'r', 'o' } };
        long t1 = System.currentTimeMillis();
        System.out.println(boggle(board, dict));
        System.out.println("Time cost of testSuite1: " + (System.currentTimeMillis() - t1)
                / 1000.0 + " secs");
    }

    public static HashMap<Integer, ArrayList<String>> boggleWithTrie(
            char[][] board, HashSet<String> dict) {
        // Pre-process dict.
        TrieDict trie = new TrieDict(dict);
        // 
        int i, j, n = board.length;
        boolean[][] visited;
        HashMap<Integer, ArrayList<String>> words = new HashMap<Integer, ArrayList<String>>();
        for (i = 0; i < n; ++i) {
            for (j = 0; j < n; ++j) {
                visited = new boolean[n][n];
                nextCharWithTrie(board, visited, "", words, i, j, trie, dict);
            }
        }
        return words;
    }
    
    public static void nextCharWithTrie(char[][] board, boolean[][] visited,
            String cur, HashMap<Integer, ArrayList<String>> words, int i,
            int j, TrieDict trie, HashSet<String> dict) {
        if (i < 0 || j < 0 || i >= board.length || j >= board.length
                || visited[i][j] || cur.length() > 8 || trie.getIndexes(cur) == null) {
            return;
        }
        cur = cur + board[i][j];
        if (cur.length() >= 3 && dict.contains(cur)) {
            ArrayList<String> arr = words.get(cur.length());
            if (arr == null) {
                arr = new ArrayList<String>();
            }
            arr.add(cur);
            words.put(cur.length(), arr);
        }
        visited[i][j] = true;
        int Xshift, Yshift, x, y;
        for (Xshift = -1; Xshift <= 1; ++Xshift) {
            x = i - Xshift;
            for (Yshift = 1; Yshift >= -1; --Yshift) {
                y = j - Yshift;
                nextCharWithTrie(board, visited, cur, words, x, y, trie, dict);
            }
        }
        visited[i][j] = false;
    }

	// General solution without trie. Exponential time complexity.
    public static HashMap<Integer, ArrayList<String>> boggle(char[][] board,
            HashSet<String> dict) {
        int i, j, n = board.length;
        boolean[][] visited;
        HashMap<Integer, ArrayList<String>> words = new HashMap<Integer, ArrayList<String>>();
        for (i = 0; i < n; ++i) {
            for (j = 0; j < n; ++j) {
                visited = new boolean[n][n];
                nextChar(board, visited, "", words, i, j, dict);
            }
        }
        return words;
    }

    public static void nextChar(char[][] board, boolean[][] visited,
            String cur, HashMap<Integer, ArrayList<String>> words, int i,
            int j, HashSet<String> dict) {
        if (i < 0 || j < 0 || i >= board.length || j >= board.length
                || visited[i][j] || cur.length() > 8) {
            return;
        }
        cur = cur + board[i][j];
        if (cur.length() >= 3 && dict.contains(cur)) {
            ArrayList<String> arr = words.get(cur.length());
            if (arr == null) {
                arr = new ArrayList<String>();
            }
            arr.add(cur);
            words.put(cur.length(), arr);
        }
        visited[i][j] = true;
        int Xshift, Yshift, x, y;
        for (Xshift = -1; Xshift <= 1; ++Xshift) {
            x = i - Xshift;
            for (Yshift = 1; Yshift >= -1; --Yshift) {
                y = j - Yshift;
                nextChar(board, visited, cur, words, x, y, dict);
            }
        }
        visited[i][j] = false;
    }
}


class TrieDict {
    TrieNodeDict root;

    TrieDict(HashSet<String> dict) { // Constructor.
        this.root = new TrieNodeDict();
        int i;
        for (String str : dict) {
            for (i = 0; i < str.length(); ++i) {
                root.insert(str.substring(i), i);
            } 
        }
    }

    public ArrayList<Integer> getIndexes(String s) {
        return root.getIndexes(s);
    }
}


class TrieNodeDict {
    ArrayList<Integer> indexes; // Store the all indexes of a specific char.
    HashMap<Character, TrieNodeDict> kids;
    char val;

    TrieNodeDict() {
        this.indexes = new ArrayList<Integer>();
        this.kids = new HashMap<Character, TrieNodeDict>();
    }

    public void insert(String s, int index) {
        this.indexes.add(index);
        if (s != null && s.length() > 0) {
            this.val = s.charAt(0);
            TrieNodeDict child = this.kids.get(this.val);
            if (child == null) {
                child = new TrieNodeDict();
                kids.put(this.val, child);
            }
            child.insert(s.substring(1), index);
        }
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
