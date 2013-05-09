/*Prefix_Tree

More:
http://en.wikipedia.org/wiki/Trie

Applications:
http://en.wikipedia.org/wiki/Trie#Applications

*/


class Prefix_Tree {
    public static void main(String[] args) {
        String[] dict = {"cat", "cate", "apple", "pear", "av", "haha", "great"};
        PrefixTrie prefix_trie = new PrefixTrie(dict);
        prefix_trie.printAll();
    }

    public static void suffixTreeDemo() {
    }
}


class PrefixTrie {
    public PrefixTrieNode root;
    
    PrefixTrie(String[] dict) {
        this.root = new PrefixTrieNode('0', false);
		for (String str : dict) {
			this.root.add(str, 0);
		}
    }
    
    public void add(String str) {
        this.root.add(str, 0);
    }
    
    public void printAll() {
        for (PrefixTrieNode kid : this.root.kids) {
            if (kid != null) {
                kid.print("");
            }
        }
    }
}


class PrefixTrieNode {
    char Char; 
    PrefixTrieNode[] kids;
    boolean isLast;
    
    PrefixTrieNode(char Char, boolean isLast) {
        this.Char = Char;
        this.isLast = isLast;
        this.kids = new PrefixTrieNode[26]; // 26 lower case chars.
    }
    
    public void add(String str, int idx) {
        if (str.length() == idx) {
			this.isLast = true;
            return;
        }
        int child_idx = str.charAt(idx) - 'a';
        if (kids[child_idx] == null) {
            kids[child_idx] = new PrefixTrieNode(str.charAt(idx), idx == str.length() - 1);
        }
        kids[child_idx].add(str, idx + 1);

    }
    
    public void print(String acc) {
        if (this.isLast) {
            System.out.println(acc + this.Char);
        }
        for (PrefixTrieNode kid : kids) {
            if (kid != null) {
                kid.print(acc + this.Char);
            }
        }
    }

    public String toString() {
        return "Char: " + this.Char + " isLast: " + this.isLast;
    }
}
