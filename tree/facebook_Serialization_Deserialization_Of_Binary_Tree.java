/** facebook_Serialization_Deserialization_Of_Binary_Tree.
 *
 * Marked as duplicates of google_BST_Serialization_Deserialization.java
 * The diff is serialize can be implemented in an iterative fashion.
 *
 * not sure how to implement deserialize in iterative way.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class facebook_Serialization_Deserialization_Of_Binary_Tree {

	public static void main(String[] args) {
		facebook_Serialization_Deserialization_Of_Binary_Tree instance = new facebook_Serialization_Deserialization_Of_Binary_Tree();
		instance.solve();
	}

	public void solve() {
        /*
         *           30
         *        10    20
         *      50    45 35
         */
		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(50);
		root.right.left = new TreeNode(45);
		root.right.right = new TreeNode(35);
		System.out.println(serialize(root));
		System.out.println(serialize(null));
	}

    /**
     * Deserialize a List of String to a BST.
     *
     * @param serial, Queue<String>
     */
	public TreeNode deserialize(List<String> serial) {
		if (serial == null || serial.size() == 0 || serial.get(0).equals("#")) {
			return null;
		} else {
			Queue<String> q = new LinkedList<String>(serial);
			return deserializeUtil(q);
		}
	}

	private TreeNode deserializeUtil(Queue<String> serial) {
        if (serial.isEmpty()) {
            return null;
        }
		String str = serial.poll();
		if (str.equals("#")) {
			return null;
		} else {
			int val = Integer.parseInt(str);
			TreeNode node = new TreeNode(val);
			node.left = deserializeUtil(serial);
			node.right = deserializeUtil(serial);
			return node;
		}
	}

    /**
     * Serialize a BST to List of String.
     *
     * @param root, TreeNode
     */
	public List<String> serialize(TreeNode root) {
		List<String> serial = new ArrayList<String>();

		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode cur = s.pop();
			if (cur == null) {
				serial.add("#");
				continue;
			}
			serial.add(cur.val + "");
            // Push right child first so left child pop out of stack first.
			s.push(cur.right);
			s.push(cur.left);
		}

		return serial;
	}

    /**
     * Private TreeNode class.
     *
     * @param val, int
     */
	static class TreeNode {

		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}
}
