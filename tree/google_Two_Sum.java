/*Two_Sum
google

Given a BST and a value target. Find two nodes in the tree whose sum is equal
x. Additional space: O(height of the tree). It is not allowed to modify the
tree
*/

import java.util.Stack;
import java.util.ArrayList;


public class google_Two_Sum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		// Test case for two.
        for (int i = 0; i <= 13; ++i) {
            two(root, i);
        }
		// Test case for twoSum.
        for (int i = 0; i <= 13; ++i) {
            twoSum(root, i);
		}
		// Test case for answer exists only on left subtree.
		root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		twoSum(root, 3);
    }

	// Using two stacks to simulate the inorder traversal with two pointers solution.
	// Time complexity O(n).
	// Space complexity O(logn) (height of tree)
    public static void twoSum(TreeNode root, int target) {
        // The idea behind this is similar to find two sum in a sorted array.
        // Using two stacks to store the left track of nodes and right track of node.
        Stack<TreeNode> leftStack = new Stack<TreeNode>(), rightStack = new Stack<TreeNode>();
        TreeNode scan, leftElem, rightElem;
		populateRight(root, rightStack);
		populateLeft(root, leftStack);
        while (leftStack.peek().val < rightStack.peek().val) {// exits when root.val == root.val
            if (leftStack.peek().val + rightStack.peek().val > target) {
                // cur sum larger than target.
                // reduce the tail(rightStack)
                rightElem = rightStack.pop();
                if (rightElem.left != null) {
                    // Push the left child of cur node and all of its right children to stack. 
					for (scan = rightElem.left; scan != null; scan = scan.right) {
                        rightStack.add(scan);
                    }
                }
            } else if (leftStack.peek().val + rightStack.peek().val < target) {
                leftElem = leftStack.pop();
                if (leftElem.right != null) {
                    for (scan = leftElem.right; scan != null; scan = scan.left) {
                        leftStack.add(scan);
                    }
                }
            } else {
                System.out.println(String.format("%d + %d = %d", leftStack.peek().val, rightStack.peek().val, target));
				populateLeft(leftStack.pop().right, leftStack);
				populateRight(rightStack.pop().left, rightStack);
            }
        }
    }

	public static void populateLeft(TreeNode root,Stack<TreeNode> s) {
		while (root != null) {
			s.add(root);
			root = root.left;
		}	
	}

	public static void populateRight(TreeNode root,Stack<TreeNode> s) {
		while (root != null) {
			s.add(root);
			root = root.right;
		}	
	}

	// Inorder. Space complexity O(n). Time complexity O(n).
    public static void two(TreeNode root, int target) {
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
                System.out.println(String.format("%d + %d = %d", arr.get(head).val, arr.get(tail).val, target));
				++head;
				--tail;
            }
        }
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

    TreeNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }

	public String toString() {
		return String.format("<%d>", this.val);	
	}
}
