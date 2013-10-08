/*google_BST_Serialization_Deserialization
google

*NOTE*: It has not to be a BST. Binary Tree is a more general case.

     30
	/  \
   10   20
  /    /  \
 50   45   35

Serialization: 30 10 50 # # # 20 45 # # 35 # #
*/


import java.util.*;


public class google_BST_Serialization_Deserialization {

	/**
	 * Assuming the order of serial is preorder.
	 * And it's not neccessary to be binary search tree. It applies to binary tree.
	 */
	
	public static void main(String[] args) {
		// Test case for serialize.
		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(50);
		root.right.left = new TreeNode(45);
		root.right.right = new TreeNode(35);
		serialize(root);
		// Test case for deserialize.
		String[] serial = new String[] {"30", "10", "50", "#", "#", "#", "20",
										"45", "#", "#", "35", "#", "#"};
		serialize(deserialize(serial));
	}

	// Deserialization.
	public static TreeNode deserialize(String[] serial) {
		Queue<String> q = new LinkedList<String>();
		for (String str : serial) {
			q.add(str);	
		}
		return deserializeUtil(q);
	}

	private static TreeNode deserializeUtil(Queue<String> q) {
		String str = q.poll();
		if (str.equals("#")) {
			return null;	
		} else {
			int val = Integer.parseInt(str);	
			TreeNode newNode = new TreeNode(val);
			if (!q.isEmpty()) {
				newNode.left = deserializeUtil(q);
			}
			if (!q.isEmpty()) {
				newNode.right = deserializeUtil(q);
			}
			return newNode;
		}
	}

	// Serialization.
	public static void serialize(TreeNode root) {
		ArrayList<String> serial = new ArrayList<String>();
		serializeUtil(root, serial);
		System.out.println(serial);
	}

	private static void serializeUtil(TreeNode root, ArrayList<String> serial) {
		if (root == null) {
			serial.add("#");
		} else {
			serial.add("" + root.val);
			serializeUtil(root.left, serial);	
			serializeUtil(root.right, serial);
		}
	}

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
