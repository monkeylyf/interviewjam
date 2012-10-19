import java.util.*;

class treeDemo {
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insertTwo(1);
		t.insertTwo(2);
		t.insertTwo(0);
		t.insertTwo(12);
		t.insertTwo(-8);
		t.insertTwo(-5);
		t.insertTwo(5);

		t.inOrder(t.root);
		System.out.println("-----------");
		t.preOrder(t.root);
		System.out.println("-----------");
		t.postOrder(t.root);
		System.out.println("-----------");
		// System.out.println(t.find(-20));
		System.out.println(t.min());
		System.out.println("-----------");
		System.out.println(t.max());
		System.out.println("-----------");
		System.out.println(t.maxDepth(t.root));
		System.out.println("-----------");
		System.out.println(t.minDepth(t.root));
		System.out.println("-----------");
		System.out.println(t.isBalanced(t.root));
		System.out.println("-----------");
		System.out.println(t.root.data);
		System.out.println(t.root.l.data);
		System.out.println(t.root.l.l.data);
		System.out.println(t.root.l.l.r.data);
		System.out.println("-----------");
		System.out.println(t.root.r.data);
		System.out.println(t.root.r.r.data);
		System.out.println(t.root.r.r.l.data);
		System.out.println("-----------");
		t.bft(t.root);	
		System.out.println("-----------");
		t.dft(t.root);	
		Tree t1 = new Tree();
	}
}

class Tree {
	Node root;

	public Node find(int key) {
		if (root == null) return null;

		Node node = root;
		while (node.data != key) {
			if (node == null) return null;
			if (key < node.data) {node = node.l;}
			else {node = node.r;}
		}
		return node;
	}

	public Node findOne(int key) {
		return findNode(root, key);
	}

	public Node findNode(Node entryNode, int key) {
		if (entryNode == null) return null;
		else {
			if (entryNode.data == key) {return entryNode;
			} else if (key < entryNode.data) {
				return findNode(entryNode.l, key);
			} else return findNode(entryNode.r, key);
		}
	}

	public Node insert(Node entryNode, Node newNode) {
		if (entryNode == null) {entryNode = newNode;
		} else if (entryNode.data > newNode.data) {
			// Go left.
			entryNode.l = insert(entryNode.l, newNode);
		} else {
			// Go right.
			entryNode.r = insert(entryNode.r, newNode);
		}
		return entryNode;
	}

	public void insertTwo(int d) {
		Node newNode = new Node();
		newNode.data = d;
		root = insert(root, newNode);
	}

	public void inOrder(Node entry) {
		if (entry != null) {
			inOrder(entry.l);
			System.out.println(entry.data);
			inOrder(entry.r);
		}
	}

	public void preOrder(Node entry) {
		if (entry != null) {
			System.out.println(entry.data);
			preOrder(entry.l);
			preOrder(entry.r);
		}
	}

	public void postOrder(Node entry) {
		if (entry != null) {
			postOrder(entry.l);
			postOrder(entry.r);
			System.out.println(entry.data);
		}
	}

	public int min() {
		if (root == null) return Integer.MAX_VALUE;
		Node node = root;
		while (node.l != null) node = node.l;
		return node.data;
	}

	public int max() {
		if (root == null) return Integer.MIN_VALUE;
		Node node = root;
		while (node.r != null) node = node.r;
		return node.data;
	}

	public void delete(int key) {
		Node node = findOne(key);
		if (node.l == null && node.r == null) {
			
		}
	}

	public int maxDepth(Node entry) {
		if (entry == null) return 0;
		return 1 + Math.max(maxDepth(entry.l), maxDepth(entry.r));
	}

	public int minDepth(Node entry) {
		if (entry == null) return 0;
		return 1 + Math.min(minDepth(entry.l), minDepth(entry.r));
	}

	public boolean isBalanced(Node entry) {return (maxDepth(root) - minDepth(root) <= 1);}

	public void bft(Node entry) {
		Queue<Node> unvisited = new LinkedList<Node>();
		unvisited.add(entry);
		while (!unvisited.isEmpty()) {
			Node cur = unvisited.remove();
			if (cur.l != null) unvisited.add(cur.l);
			if (cur.r != null) unvisited.add(cur.r);
			System.out.println(cur.data);
		}
	}

	public void dft(Node entry) {
		Stack<Node> unvisited = new Stack<Node>();
		unvisited.push(entry);
		while (!unvisited.isEmpty()) {
			Node cur = unvisited.pop();
			if (cur.r != null) unvisited.add(cur.r);
			if (cur.l != null) unvisited.add(cur.l);
			System.out.println(cur.data);
		}
	}
}


class Node {
	Node l;
	Node r;
	int data;
	public Node() {
		l = null;
		r = null;
	}
}
