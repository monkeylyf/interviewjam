/*Given a string s and an array of smaller strings T, design a method to search
s for each small string in T*/

import java.util.*;


class test_141 {
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("bibs");
		System.out.println("Depth 1: ");
		for (Node n : t.root.child) System.out.println(n.data);
		System.out.println("Depth 2: ");
		for (Node n : t.root.child.get(0).child) System.out.println(n.data);
		System.out.println(t.root.child.get(1).child.get(0).data);
		System.out.println("Depth 3: ");
		System.out.println(t.root.child.get(0).child.get(0).child.get(0).data);
		System.out.println(t.root.child.get(1).child.get(0).child.get(0).data);
		System.out.println("Depth 4: ");
		System.out.println(t.root.child.get(0).child.get(0).child.get(0).child.get(0).data);


		String[] T = {"ib", "hit", "bs", "bi", "tas", "gas", "ibs"};
		for (String str : T) {
			t.search(str);
			System.out.println("--------------");	
		}
	}
}

class Trie {
	Node root;
	
	public Trie() {root = new Node();}
	public void insert(String str) {
		for (int i = 0; i < str.length(); ++i) {
			Node node = root;
			for (int j = i; j < str.length(); ++j) {
				System.out.println("Starting processing char: " + str.charAt(j));
				if (node.child.size() == 0) {
					System.out.println("Current node has no child. Adding new node.");
					Node x = new Node();
					x.data = str.charAt(j);
					node.child.add(x);
					node = x;
				} else {
					boolean hasChar = false;
					for (Node kid : node.child) {
						if (kid.data == str.charAt(j)) {
							System.out.println("Current node has a child containg char " + str.charAt(j));
							System.out.println("Pointing current node to this node");
							node = kid;
							hasChar = true;
							break;
						}
					}
					if (!hasChar) {
						System.out.println("Current node has no child. Adding new node.");
						Node x = new Node();
						x.data = str.charAt(j);
						node.child.add(x);
						node = x;
					}
				}	
			}
			System.out.println("");
		}
	}
	public boolean search(String str) {
		System.out.println("Starting searching " + str);
		Node node = root;
		for (int i = 0; i < str.length(); ++i) {
			boolean found = false;
			for (Node kid : node.child) {
				if (kid.data == str.charAt(i)) {
					found = true;
					node = kid;
					break;
				}
			}
			if (!found) return false;
		}
		System.out.println("String " + str + " found");
		return true;
	}
}

class Node {
	ArrayList<Node> child;
	char data;
	public Node() {child = new ArrayList<Node>();}
}
