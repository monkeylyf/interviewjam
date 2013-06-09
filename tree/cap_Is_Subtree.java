/*Is_Subtree
careercup

You have two very large binary trees: T1, with millions of nodes, and T2, with
hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
*/

class cap_Is_Subtree {
		
	/** We can preorder traverse both of the tree and construct string representation of both trees.
	 *
	 *  Then we can check if a string is the substring of other. But given two large binary trees, 
	 *  the string will consumes a lot of extra memory.
	 *  
	 *  A recursive way is better way.
	 */


	public static void main(String[] args) {
		// test case 1.
		TreeNode p = new TreeNode(3);
		p.left = new TreeNode(2);
		p.right = new TreeNode(1);
		p.right.left = new TreeNode(4);
		p.right.right = new TreeNode(5);

		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(4);
		q.right = new TreeNode(5);

		System.out.println(isSubTree(p, q));
		
		// test case 2.
		TreeNode a = null;
		System.out.println(isSubTree(p, a));
	}
	
	
	public static boolean isSubTree(TreeNode p, TreeNode q) {
		if (q == null) {
			return true;	
		} else {
			return isSubTreeUtil(p, q);
		}
	}

	public static boolean isSubTreeUtil(TreeNode p, TreeNode q) {
		if (p == null) {
			return false;	
		} else if (p.val == q.val && sameTree(p, q)) {
			return true;
		} else {
			return isSubTreeUtil(p.left, q)	|| isSubTreeUtil(p.right, q);
		}
	}

	public static boolean sameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == q;	
		} else if (p.val != q.val) {
			return false;	
		} else {
			return sameTree(p.left, q.left)	 && sameTree(p.right, q.right);
		}
	}
}


class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int val) {
		this.left = null;
		this.right = null;
		this.val = val;
	}
}
