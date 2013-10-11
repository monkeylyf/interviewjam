/*Are_Two_Mirror_Tree
linkedin

Tree 1

     a
	/ \
   b   c
      / \
	 d   e


Tree 2

	 a
	/ \
   c   b
  / \
 e   d
*/

public class linkedin_Are_Two_Mirror_Tree {
	
	public static void main(String[] args) {
		
	}

	public boolean areMirror(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;	
		} else if (node1 == null || node2 == null) {
			return false;	
		} else if (node1.item != node2.item) {
			return false;	
		} else {
			return areMirror(node1.left, node2.right) && areMirror(node1.right, node2.left);	
		}
		
	}

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		char item;

		TreeNode(char item) {
			this.left = null;
			this.right = null;
			this.item = item;
		}
	}
}
