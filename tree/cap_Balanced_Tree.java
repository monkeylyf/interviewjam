/*Balanced_Tree
Careercup

Implement a function to check if a tree is balanced. For the purposes of this
question, a balanced tree is defined to be a tree such that no two leaf nodes
differ in distance from the root by more than one*/

class cap_Balanced_Tree {
	public static void main(String[] args) {
        // Create tree.
		Tree t = new Tree();
		t.insert(1);
		t.insert(2);
		t.insert(0);
		t.insert(12);
		t.insert(-8);
		t.insert(-5);
		t.insert(5);
		System.out.println(t.maxDepth(t.root));
		System.out.println(t.minDepth(t.root));
		System.out.println(t.isBalanced(t.root));
	}
}


class Tree {
	public Node root;
	// Find.
	public Node findNext(Node entry, int key) {
		if (entry == null) return null;
		if (entry.data == key) return entry;
		if (key < entry.data) return findNext(entry.l, key);
		else return findNext(entry.r, key);
	}
	public Node find(int key) {
        return findNext(root, key);
    }
	// Insert.
	public void insert(int key) {
		Node node = new Node();
		node.data = key;
		root = insertNext(root, node);
	}
	public Node insertNext(Node entry, Node node) {
		if (entry == null) entry = node;
		else if (entry.data > node.data ) entry.l = insertNext(entry.l, node);
		else entry.r = insertNext(entry.r, node);
		return entry;
	}
	// In-, pre-, post-order traverse.
	public void inorder(Node entry) {
		if (entry != null) {
			inorder(entry.l);
			System.out.println(entry.data);
			inorder(entry.r);
		}
	}
	public void preorder(Node entry) {
		if (entry != null) {
			System.out.println(entry.data);
			preorder(entry.l);
			preorder(entry.r);
		}
	}
	public void postorder(Node entry) {
		if (entry != null) {
			postorder(entry.l);
			postorder(entry.r);
			System.out.println(entry.data);
		}
	}
    // isBalanced.
	public int maxDepth(Node entry) {
		if (entry == null) return 0;
		return 1 + Math.max(maxDepth(entry.r), maxDepth(entry.l));
	}
	public int minDepth(Node entry) {
		if (entry == null) return 0;
		return 1 + Math.min(minDepth(entry.r), maxDepth(entry.l));
	}
	public boolean isBalanced(Node entry) {
		return (maxDepth(root) <= minDepth(root) + 1);
	}
}


class Node {
	Node r;
	Node l;
	int data;
	public Node() {
		r = null;
		l = null;
		data = 0;
	}
}
