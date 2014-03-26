/*Recover_Binary_Search_Tree

Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a
constant space solution?
*/


import java.util.ArrayList;


public class leetcode_Recover_Binary_Search_Tree {

    public static void main(String[] args) {

    }

    public static void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> inorder = new ArrayList<TreeNode>();
        inorderTraverse(root, inorder); // inorder traversal of tree.
        TreeNode nodeOne = null, nodeTwo = null;
        // Now the question become two elements of a sorted array are swap by
        // mistake. Recover thee array.
        for (int i = 0; i < inorder.size() - 1; ++i) {
            if (inorder.get(i).val > inorder.get(i + 1).val) {
                nodeOne = inorder.get(i);
                break;
            }
        }
        for (int i = inorder.size() - 1; i > 0; --i) {
            if (inorder.get(i).val < inorder.get(i - 1).val) {
                nodeTwo = inorder.get(i);
                break;
            }
        }
        int swap = nodeOne.val;
        nodeOne.val = nodeTwo.val;
        nodeTwo.val = swap;
    }

    public static void inorderTraverse(TreeNode root, ArrayList<TreeNode> inorder) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left, inorder);
        inorder.add(root);
        inorderTraverse(root.right, inorder);
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


/* Python Version 
def recoverTree(self, root):
    def inorder(root, arr):
        if not root:
            return
        inorder(root.left, arr)
        arr.append(root.val)
        inorder(root.right, arr)
    arr = []
    inorder(root, arr)

    a = b = None
    for i in xrange(len(arr) - 1):
        if arr[i] > arr[i + 1]:
            a = arr[i]
            break
    for i in reversed(xrange(1, len(arr))):
        if arr[i - 1] > arr[i]:
            b = arr[i]
            break
    self.swap(root, a, b)
    return root
    
def swap(self, root, a, b):
    if not root:
        return
    elif root.val == a:
        root.val = b
    elif root.val == b:
        root.val = a
        
    self.swap(root.left, a, b)
    self.swap(root.right, a, b)
*/
