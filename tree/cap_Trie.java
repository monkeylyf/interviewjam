/*Trie
careercup

Given a string s and an array of smaller strings T, design a method to search
s for each small string in T
*/


import java.util.*;


class cap_Trie {
    public static void main(String[] args) {
        Trie t = new Trie("BANANA");
        for (int i = 0; i < "BANANA".length(); ++i) {
            System.out.println(t.getIndexes("BANANA".substring(i)));
        }
    }   
}   


class Trie {
    TrieNode root = new TrieNode();
    Trie(String s) { // Constructor.
        for (int i = 0;i < s.length(); ++i) {
            root.insert(s.substring(i), i);
        }
    }
    public ArrayList<Integer> getIndexes(String s) {
        return root.getIndexes(s);
    }
}


class TrieNode {
    ArrayList<Integer> indexes; // Store the all indexes of a specific char. 
    HashMap<Character, TrieNode> kids;
    char val;
    TrieNode() {
        this.indexes = new ArrayList<Integer>();
        this.kids = new HashMap<Character, TrieNode>();
    }
    public void insert(String s, int index) {
        this.indexes.add(index);
        if (s != null && s.length() > 0) {
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
