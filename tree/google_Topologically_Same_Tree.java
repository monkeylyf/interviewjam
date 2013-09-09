/*Topologically_Same_Tree
google

Given two binary trees, write a function to check if they are topologically
equivalent.
Two binary trees are considered topologically equivalent if they are
structurally identical.
*/

import java.util.*;


public class google_Topologically_Same_Tree {

    public static void main(String[] args) {
    
    }

    public static boolean isSameStructuredNode(TreeNode a, TreeNode b) {
        // Recursive way. More conpact but interviewer might ask you for non-recursive answer.
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else {
            return isSameStructuredNode(a.left, b.left) && isSameStructuredNode(a.right, b.right);
        }
    }

    public static boolean isSame(TreeNode a, TreeNode b) {
        // Non-recursive answer. Based on BFS.
        Queue<TreeNode> aQueue = new LinkedList<TreeNode>(), bQueue = new LinkedList<TreeNode>();
        TreeNode A, B;
        aQueue.add(a);
        bQueue.add(b);
        while (!aQueue.isEmpty() && !bQueue.isEmpty()) {
            A = aQueue.poll();
            B = bQueue.poll();
            if (A == null && B == null) {
                continue;
            }
			if (A == null ^ b == null) {
                return false; // Either of the two nodes are null.
            }
            aQueue.add(A.left);
            aQueue.add(A.right);
            bQueue.add(B.left);
            bQueue.add(B.right);
        }
        return true;
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
        this.left = null;
        this.right = null;
        this.val = x;
    }
}
