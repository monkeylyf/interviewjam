/**google_Is_BST.
 */


public class google_Is_BST {
  
  public static void main(String[] args) {
	
  }  

  public static boolean isBST(TreeNode root) {
	if (root == null) {
	  return true; // Should check with your interviewer with this edge case  
	} else {
	  return isBSTUtil(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
  }

  public static boolean isBSTUtil(TreeNode node, int max, int min) {
	if (node == null) {
	  return true;  
	} else if (node.val > max || node.val <= min) { // Shoudl check with your interviewer about the def of BST
	  return false
	} else {
	  return isBSTUtil(node.left, node.val, min) && isBSTUtil(node.right, max, node.val);
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
