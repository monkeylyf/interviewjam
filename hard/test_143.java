/*Given two words of equal length that are in a dictionary, write a method to
transform one word into another word by changing only one letter at a time. The
new word you get in each step must be in the dictionary
EXAMPLE:
Input: DAMP, LIKE
Output: DAMP -> LAMP -> LIMP -> LIME ->LIKE
*/

import java.util.*;

class test_143 {
	public static void main(String[] args) {
		String[] dict = {"DAMP","LAMP","LIMP","LIME","LIKP","LAKP","LIKE","SHIT"};	
		my(dict, "DAMP", "LIKE");
	}

	public static void my(String[] dict, String input, String output) {
		Queue<Node> unvisited = new LinkedList<Node>();
		Node root = new Node(input);
		root.depth = 0;
		unvisited.add(root);
		while(!unvisited.isEmpty()) {
			Node cur = unvisited.remove();
			if (cur.str == output) {
				Node tail = cur;
				while (cur != null) {
					System.out.print("<--" + cur.str);
					cur = cur.parent;
				}
				System.out.println("");
				break;
			}
			if (cur.depth > input.length()) {
				System.out.println("Can't transform '" + input + "' to '" + output);
				break;
			}
			for (String word : dict) {
				if (diffByOne(word, cur.str)) {
					Node node = new Node(word);
					node.parent = cur;
					node.depth = cur.depth + 1;
					unvisited.add(node);
				}
			}
		}
	}

	public static boolean diffByOne(String a, String b) {
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		if (aa.length != bb.length) return false;
		int diff = 0;
		for (int i = 0; i < aa.length; ++i) if (aa[i] != bb[i]) ++diff;
		if (diff == 1) return true;
		return false;
	}
}


class Node {
	Node parent;
	String str;
	int depth;
	public Node(String data) {
		parent = null;
		str = data;
		depth = 0;
	}
}
