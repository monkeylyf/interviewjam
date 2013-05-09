/*Suffix_Trie
careercup

Given a string s and an array of smaller strings T, design a method to search
s for each small string in T

More for suffix tree:
http://en.wikipedia.org/wiki/Suffix_tree
Application for suffix tree:
http://en.wikipedia.org/wiki/Suffix_tree#Applications
*/


import java.util.*;


class cap_Suffix_Trie {
    public static void main(String[] args) {
        SuffixTrie t = new SuffixTrie("BANANA");
        for (int i = 0; i < "BANANA".length(); ++i) {
            System.out.println(t.getIndexes("BANANA".substring(i)));
        }
        System.out.println("test with empty string: " + t.getIndexes(""));
        System.out.println("neg test: " + t.getIndexes("fuckyou"));
    }   
}   


class SuffixTrie {
    SuffixTrieNode root;

    SuffixTrie(String s) { // Constructor.
		this.root = new SuffixTrieNode();
        for (int i = 0;i < s.length(); ++i) {
			// Inserting all suffix.
            this.root.insert(s.substring(i), i);
        }
    }

    public ArrayList<Integer> getIndexes(String s) {
        return root.getIndexes(s);
    }
}


class SuffixTrieNode {
    ArrayList<Integer> indexes; // Store the all indexes of a specific char. 
    HashMap<Character, SuffixTrieNode> kids;
    char val;

    SuffixTrieNode() {
        this.indexes = new ArrayList<Integer>();
        this.kids = new HashMap<Character, SuffixTrieNode>();
    }

    public void insert(String s, int index) {
        this.indexes.add(index);
        if (s != null && s.length() > 0) {
            this.val = s.charAt(0);
            SuffixTrieNode child = this.kids.get(this.val);
            if (child == null) {
                child = new SuffixTrieNode();
                kids.put(this.val, child); // Cache char/node pair if cur char hasn't been cached.
            }
            child.insert(s.substring(1), index); // Recursion.
        }
    }

    public ArrayList<Integer> getIndexes(String s) {
        if (s == null || s.length() == 0) {
            return this.indexes;
        } else {
            char first = s.charAt(0);
            if (this.kids.containsKey(first)) {
                return this.kids.get(first).getIndexes(s.substring(1));
            } else {
				return null; // Non-existing suffix string
			}
        }
    }
}
