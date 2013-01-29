/*Populating_next_right_pointers_in_each_node

Given a binary tree
public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {
        val = x;
    }
}

Populate each next pointer to point to its next right node. If there is no next
right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Note:
You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same
level, and every parent has two children).
For example,
Given the following perfect binary tree,

        1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

        1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/


import java.util.Queue;
import java.util.LinkedList;


class leetcode_Populating_next_right_pointers_in_each_node {
    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        n1.left = n2;
        n1.right = n3;
        connect(n1);
    }
    // More elegant.
    public static void my(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            root.right.next = (root.next != null) ? root.next.left : null;
        }
        connect(root.left);
        connect(root.right);
    }
    // This method is familar to print the bst layer by layer.
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
                for (int i = 0; i < ll.size(); ++i) {
                    if (i + 1 < ll.size()) {
                        ll.get(i).next = ll.get(i + 1);
                    }
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


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {
        val = x;
    }
}
