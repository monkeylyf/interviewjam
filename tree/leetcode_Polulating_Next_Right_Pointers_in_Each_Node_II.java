/*Polulating_Next_Right_Pointers_in_Each_Node_II

Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution
still work?
Note:
You may only use constant extra space.
For example,
Given the following binary tree,
        1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
        1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/


class leetcode_Polulating_Next_Right_Pointers_in_Each_Node_II {
    public static void main(String[] args) {
    }
    // This method is based on print layer by layer traversal.
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> unvisited = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> ll = new LinkedList<TreeLinkNode>();
        unvisited.add(root);
        int count = 1;
        while (true) {
            TreeLinkNode node = unvisited.remove();
            ll.add(node);
            if (node.left != null) {
                unvisited.add(node.left);
            }
            if (node.right != null) {
                unvisited.add(node.right);
            }
            if (--count == 0) {
                for (int i = 0; i < ll.size() - 1; ++i) {
                    ll.get(i).next = ll.get(i + 1);
                }
                ll = new LinkedList<TreeLinkNode>();
                count = unvisited.size();
            }
            if (unvisited.isEmpty()) {
                break;
            }
        }
    }
}


TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {
        val = x;
    }
}
