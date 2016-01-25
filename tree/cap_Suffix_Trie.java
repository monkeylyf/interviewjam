/**
 * Suffix_Trie.
 * careercup
 *
 * Given a string s and an array of smaller strings T, design a method to search
 * s for each small string in T
 *
 * More for suffix tree:
 * http://en.wikipedia.org/wiki/Suffix_tree
 * Application for suffix tree:
 * http://en.wikipedia.org/wiki/Suffix_tree#Applications
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class cap_Suffix_Trie {

  public static void main(String[] args) {
    test();
  }

  private static void test() {
    SuffixTrie t = new SuffixTrie("BANANA");

    for (int i = 0; i < "BANANA".length(); ++i) {
      String subStr = "BANANA".substring(i);
      System.out.println(subStr + " " + t.getIndexes(subStr));
    }
    System.out.println("test with empty string: " + t.getIndexes(""));
    System.out.println("neg test: " + t.getIndexes("fuckyou"));
  }

  private static class SuffixTrie {

    private SuffixTrieNode root;

    /**
     * Constructor.
     */
    public SuffixTrie(String s) {
      this.root = new SuffixTrieNode();
      for (int i = 0; i < s.length(); ++i) {
        this.root.insert(s.substring(i), i);
      }
    }

    public List<Integer> getIndexes(String s) {
      return root.getIndexes(s);
    }
  }

  private static class SuffixTrieNode {

    private static final int ZERO = 0;

    private final List<Integer> indexes; // Store the all indexes of a specific char.
    private final Map<Character, SuffixTrieNode> kids;
    private char val;

    public SuffixTrieNode() {
      this.indexes = new ArrayList<>();
      this.kids = new HashMap<>();
    }

    public void insert(String s, int index) {
      this.indexes.add(index);
      if (s != null && s.length() > 0) {
        this.val = s.charAt(ZERO);
        SuffixTrieNode child = this.kids.get(this.val);
        if (child == null) {
          child = new SuffixTrieNode();
          kids.put(this.val, child); // Cache char/node pair if cur char hasn't been cached.
        }
        // Recursion.
        child.insert(s.substring(1), index);
      }
    }

    public List<Integer> getIndexes(String s) {
      if (s == null || s.length() == 0) {
        return this.indexes;
      } else {
        char first = s.charAt(ZERO);
        if (this.kids.containsKey(first)) {
          return this.kids.get(first).getIndexes(s.substring(1));
        } else {
          return Collections.emptyList(); // Non-existing suffix string
        }
      }
    }
  }
}
