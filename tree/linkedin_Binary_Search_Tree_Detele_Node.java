/*Binary_Search_Tree_Detele_Node
LinkedIn

Delete a given node in bst.
*/

class linkedin_Binary_Search_Tree_Detele_Node {
    public static void main(String[] args) {
     
    }
    public static void addNode(int target, TreeNode root) {
        TreeNode parent = null;
        TreeNode cursor = root;
        while (cursor != null) {
            parent = cursor;
            if (cursor.val < target) {
                cursor = cursor.right;
            } else {
                cursor = cursor.left;
            }
        }
        TreeNode newNode = new TreeNode(target);
        if (parent == null) { // root is null so while loop is skipped.
            root = newNode;
        } else if (cursor.val < target) {
            cursor.right = newNode;
        } else {
            cursor.left = newNode;
        }
    }
    public static void delete(int target, TreeNode root) {
        TreeNode parent = null;
        TreeNode cursor = root;
        while (cursor != null) {
            parent = cursor;
            if (cursor.val < target) {
                cursor = cursor.right;
            } else if (cursor.val > target) {
                cursor = cursor.left;
            } else { // cursor.val == target. Node to be deleted found.
                break;
            }
        }
        if (cursor != null) {// cursor == null meaning after search the entire tree but didn't find the target node.
            boolean isParentLeftKid = parent.val > target;
            if (cursor.left == null && cursor.right == null) {
                // Case one: target node has no kids.
                if (isParentLeftKid) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (cursor.left == null) {
                // Case two: only target node's left kid is null.
                if (isParentLeftKid) {
                    parent.left = cursor.right;
                } else {
                    parent.right = cursor.right;
                }
            } else if (cursor.right == null) {
                // Case three: only target node's right kid is null.
                if (isParentLeftKid) {
                    parent.left = cursor.left;
                } else {
                    parent.right = cursor.right;
                }
            } else {
                // Tricky case four: target node has two kids
                if (isParentLeftKid) {
                    TreeNode succesor = cursor.right;
                    TreeNode succesorParent = null;
                    while (succesor.left != null) { // Trying to find succesor of cursor node.
                        succesorParent = succesor;
                        succesor = succesor.left;
                    }
                    cursor.val = succesor.val; // Swap the val of succesor and cursor.
                    if (succesorParent == null) { // if succesor is cursor's right kid
                        cursor.right = succesor.right;
                    } else { // Delete succesor and take care of succesor's right kid.
                        succesorParent.left = succesor.right;
                    }
                    
                } else {
                    TreeNode succesor = cursor.left;
                    TreeNode succesorParent = null;
                    while (succesor.right != null) {
                        succesorParent = succesor;
                        succesor = succesor.right;
                    }
                    cursor.val = succesor.val;
                    if (succesorParent == null) {
                        cursor.left = succesor.left;
                    } else {
                        succesorParent.right = succesor.left;
                    }
                }
            }
        }
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
