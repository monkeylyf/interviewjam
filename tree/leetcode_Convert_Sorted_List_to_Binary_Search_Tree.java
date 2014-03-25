/*Convert_Sorted_List_to_Binary_Search_Tree

Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.
*/

public class leetcode_Convert_Sorted_List_to_Binary_Search_Tree {

  public static void main(String[] args) {

  }

  public static TreeNode sortedListToBST(ListNode head) {
	if (head == null) {
	  return null;
	}
	if (head.next == null) {
	  return new TreeNode(head.val);
	}

	ListNode dummy = new ListNode(-1);
	dummy.next = head;
	ListNode prev = dummy;
	ListNode mid = head;
	ListNode tail = head;

	while (tail != null && tail.next != null) {
	  prev = prev.next;
	  mid = mid.next;
	  tail = tail.next.next;
	}

	ListNode right = mid.next;
	mid.next = null;
	prev.next = null;
	TreeNode ret = new TreeNode(mid.val);
	ret.left = sortedListToBST(head);
	ret.right = sortedListToBST(right);

	return ret;
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


/* Python Version (Did not pass OJ, do not know why:()
class Solution:
    # @param head, a list node
    # @return a tree node
    def sortedListToBST(self, head):
        if not head:
            return None
        
        if not head.next:
            return TreeNode(head.val)
        
        #
        dummy = ListNode(-1)
        dummy.next = head
        
        prev = dummy
        slow = head
        fast = head
        while fast and fast.next:
            prev = prev.next
            slow = slow.next
            fast = fast.next.next
        
        cur = ListNode(slow.val)
        prev.next = None
        right = slow.next
        slow.next = None
        cur.left = self.sortedListToBST(head)
        cur.right = self.sortedListToBST(right)
        return cur
*/
