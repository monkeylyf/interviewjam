/*Two_Sum
google

Given a BST and a value target. Find two nodes in the tree whose sum is equal
x. Additional space: O(height of the tree). It is not allowed to modify the
tree
*/

import java.util.Stack;
import java.util.ArrayList;


class google_Two_Sum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        for (int i = 0; i <= 13; ++i) {
            twoSum(root, i);
            two(root, i);
        }
    }
    public static int twoSum(TreeNode root, int target) {
        // The idea behind this is similar to find two sum in a sorted array.
        // Using two stacks to store the left track of nodes and right track of node.
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        TreeNode scan = root;
        while (scan != null) {
            leftStack.add(scan);
            scan = scan.left;
        }
        scan = root;
        while (scan != null) {
            rightStack.add(scan);
            scan = scan.right;
        }
        while (leftStack.peek().val < rightStack.peek().val) {// exists when root.val == root.val
            if (leftStack.peek().val + rightStack.peek().val > target) {
                // cur sum larger than target.
                // reduce the tail(rightStack)
                TreeNode rightElem = rightStack.pop();
                if (rightElem.left != null) {
                    // Push the left child of cur node and all of its right children to stack. 
                    scan = rightElem.left;
                    while (scan != null) {
                        rightStack.add(scan);
                        scan = scan.right;
                    }
                }
            } else if (leftStack.peek().val + rightStack.peek().val < target) {
                TreeNode leftElem = leftStack.pop();
                if (leftElem.right != null) {
                    scan = leftElem.right;
                    while (scan != null) {
                        leftStack.add(scan);
                        scan = scan.left;
                    }
                }
            } else {
                System.out.println(leftStack.peek().val + ", "
                        + rightStack.peek().val);
                return leftStack.peek().val + rightStack.peek().val;
            }
        }
        System.out.println("not found");
        return Integer.MAX_VALUE;
    }
    public static int two(TreeNode root, int target) {
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        inorderTraversal(root, arr);
        int head = 0;
        int tail = arr.size() - 1;
        while (head < tail) {
            if (arr.get(head).val + arr.get(tail).val < target) {
                ++head;
            } else if (arr.get(head).val + arr.get(tail).val > target) {
                --tail;
            } else {
                // Found.
                System.out.println("jimo " + arr.get(head).val + ", " + arr.get(tail).val);
                return arr.get(head).val + arr.get(tail).val;
            }
        }
        return Integer.MAX_VALUE;
    }
    public static void inorderTraversal(TreeNode root, ArrayList<TreeNode> arr) {
        if (root != null) {
            inorderTraversal(root.left, arr);
            arr.add(root);
            inorderTraversal(root.right, arr);
        }
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
