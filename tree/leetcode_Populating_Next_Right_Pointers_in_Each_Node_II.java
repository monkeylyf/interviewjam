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

import java.util.*;


public class leetcode_Populating_Next_Right_Pointers_in_Each_Node_II {

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
		TreeLinkNode node;
        while (!unvisited.isEmpty()) {
            node = unvisited.remove();
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
        }
    }
}


class TreeLinkNode {
    TreeLinkNode left;
    TreeLinkNode right;
	TreeLinkNode next;
    int val;

    TreeLinkNode(int val) {
		this.left = null;
		this.right = null;
		this.next = null;
        this.val = val;
    }
}

/* Python Version
def connect(self, root):
    if not root:
        return
    
    pipe = [root]
    next_level = []
    
    while pipe:
        cur = pipe.pop(0)
        
        if cur.left:
            next_level.append(cur.left)
        if cur.right:
            next_level.append(cur.right)
        
        if not pipe and next_level:
            # Connecting...
            for i in xrange(len(next_level) - 1):
                next_level[i].next = next_level[i + 1]
                
            next_level[-1].next = None
            
            pipe = next_level
            next_level = []
*/
