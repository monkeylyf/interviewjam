/*Lowest_Common_Ancestor_of_a_Binary_Search_Tree

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
LCA of nodes 2 and 8 is 6. LCA of 2 and 4 should be 2.
*/


public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public static void main(String[] args) {
    
    }

    public static TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == null || b == null) {
            return null;
        }
        if (Math.min(a.val, b.val) > root.val) {
            return lca(root.right, a, b);
        } else if (Math.max(a.val, b.val) < root.val) {
            return lca(root.left, a, b);
        } else {
            return root; 
        }
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) {
            left = null;
            right = null;
            val = x;
        }
    }
}
