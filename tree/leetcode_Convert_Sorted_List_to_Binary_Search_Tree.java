/*Convert_Sorted_List_to_Binary_Search_Tree

Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.
*/

public class leetcode_Convert_Sorted_List_to_Binary_Search_Tree {

    public static void main(String[] args) {
    
    }

    // Convert linked list to int array.
    public static TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ListNode node = head; 
        while (node != null) {
            arr.add(node.val);
            node = node.next;
        }
        int[] num = new int[arr.size()];
        for (int i = 0; i < arr.size(); ++i) {
            num[i] = arr.get(i);
        } 
        return nextNode(num, 0, num.length - 1);
    }

    public static TreeNode nextNode(int[] num, int head, int tail) {
        if (head <= tail) {
            int middle = head + (tail - head) / 2;
            TreeNode node = new TreeNode(num[middle]);
            node.left = nextNode(num, head, middle - 1);
            node.right = nextNode(num, middle + 1, tail);
            return node;
        } else {
            return null;
        }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
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
