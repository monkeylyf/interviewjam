/** Binary_Tree_With_All_Nodes_On_Right_At_Same_Level.
 *
 * Define treenode with one more attribute ArrayList<TreeNode>
 * that contais all node on the right side of current node with the same depth.
 * Given a binary tree without this attribute initilized. How to implement this?
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class facebook_Binary_Tree_With_All_Nodes_On_Right_At_Same_Level {
	public static void main(String[] arg) {
		Binary_Tree_With_All_Nodes_On_Right_At_Same_Level instance = new Binary_Tree_With_All_Nodes_On_Right_At_Same_Level();
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(0);
		head.right = new TreeNode(2);
		head.left.left = new TreeNode(-1);
		instance.solve(head);
	}
	
	public void solve(TreeNode head) {
		if (head == null) {
			return;
		}
		
		Queue<TreeNode> cur_level = new LinkedList<TreeNode>();
		Queue<TreeNode> next_level = new LinkedList<TreeNode>();
		cur_level.add(head);
		
		while (!cur_level.isEmpty()) {
			TreeNode node = cur_level.poll();
			if (node.left != null) {
				next_level.add(node.left);
			}
			if (node.right != null) {
				next_level.add(node.right);
			}
			
			if (cur_level.isEmpty()) {
				collectNodeOnRight(next_level);
				cur_level = next_level;
				System.out.println(cur_level);
				next_level = new LinkedList<TreeNode>();
			}
		}
	}
	
	private void collectNodeOnRight(Queue<TreeNode> q) {
		if (q.size() == 0) {
			return;
		}
		
		ArrayList<TreeNode> all = new ArrayList<TreeNode>();
		for (TreeNode node : q) {
			all.add(node);
		}
		
		while (all.size() > 0) {
			TreeNode node = all.remove(0);
			for (TreeNode n : all) {
				node.nodesOnRight.add(n);
			}
		}
	}
	
	static class TreeNode {
		ArrayList<TreeNode> nodesOnRight;
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val) {
			this.nodesOnRight = new ArrayList<TreeNode>();
			this.left = null;
			this.right = null;
			this.val = val;
		}
		
		public String toString() {
			return "" + this.val + " " + this.nodesOnRight;
		}
	}
}
