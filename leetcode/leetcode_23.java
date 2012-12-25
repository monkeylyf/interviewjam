/*Given an array where elements are sorted in ascending order, convert it to a
height balanced BST.
*/

class leetcode_23 {
    public static void main(String[] args) {
        sortedArrayToBST(new int[] {1, 3});
    }
    public static TreeNode sortedArrayToBST(int[] num) {
        return nextNode(num, 0, num.length - 1);
    }
    public static TreeNode nextNode(int[] num, int head, int tail) {
        if (head <= tail) {
            int middle = (head + tail) / 2;
            TreeNode node = new TreeNode(num[middle]);
            node.left = nextNode(num, head, middle - 1);
            node.right = nextNode(num, middle + 1, tail);
            return node;
        } else {
            return null;
        }
    }
}


class TreeNode{
    TreeNode right;
    TreeNode left;
    int val;
    TreeNode(int x) {
        val = x;
    }
}
