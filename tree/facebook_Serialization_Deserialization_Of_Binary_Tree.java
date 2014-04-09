/** facebook_Serialization_Deserialization_Of_Binary_Tree.
 * 
 * Marked as duplicates ofgoogle_BST_Serialization_Deserialization.java
 * The diff is serialize can be implemented with iterative way.
 *
 * not sure how to implement deserialize in iterative way.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class facebook_Serialization_Deserialization_Of_Binary_Tree {
	
	public static void main(String[] args) {
		facebook_Serialization_Deserialization_Of_Binary_Tree instance = new facebook_Serialization_Deserialization_Of_Binary_Tree();
		instance.solve();
	}
	
	public void solve() {
		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(50);
		root.right.left = new TreeNode(45);
		root.right.right = new TreeNode(35);
		System.out.println(serialize(root));
	}
	
	public TreeNode deserialize(ArrayList<String> serial) {
		if (serial == null || serial.size() == 0 || serial.get(0).equals("#")) {
			return null;
		} else {
			Queue<String> q = new LinkedList<String>(serial);
			return deserializeUtil(q);
		}
	}
	
	private TreeNode deserializeUtil(Queue<String> serial) {
		String str = serial.poll();
		if (str.equals("#")) {
			return null;
		} else {
			int val = Integer.parseInt(str);
			TreeNode node = new TreeNode(val);
			if (!serial.isEmpty()) {
				node.left = deserializeUtil(serial);
			}
			if (!serial.isEmpty()) {
				node.right = deserializeUtil(serial);
			}
			return node;
		}
	}	
	
	public ArrayList<String> serialize(TreeNode root) {
		ArrayList<String> serial = new ArrayList<String>();
		
		if (root == null) {
			serial.add("#");
			return serial;
		}
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode cur = s.pop();
			if (cur == null) {
				serial.add("#");
				continue;
			}
			serial.add(cur.val + "");
			s.push(cur.right);
			s.push(cur.left);
		}
		
		return serial;
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
