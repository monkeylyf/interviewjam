/**leetcode_Linked_List_Cycle_II.
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.

 * Follow up:
 * Can you solve it without using extra space?
 */



public class leetcode_Linked_List_Cycle_II {
  
  public static void main(String[] args) {
	
	
  }  

  public static ListNode detect(ListNode head) {
	if (head == null || head.next == null || head.next.next == null) {
	  return null;
	}

	ListNode slow = head.next;
	ListNode fast = head.next.next;

	while (slow != fast) {
	  // If fast ever reaches null, then there is no cycle.
	  if (fast.next == null || fast.next.next == null) {
		return null;
	  }

	  fast = fast.next.next;
	  slow = slow.next;
	}


	ListNode ret = head;

	// Assuming: # of nodes before cycle begins is x, # of nodes in cycle and # of nodes 
	// slow visited in cycle. Then you have:
    // (x + t) * 2 = x + y + t. Then you got: x + t = y
    // Since slow/fast is at t, when you travel at the same speed with head, they meet at 
    // then entrance of the cycle.
	while (ret != fast) {
	  ret = ret.next;
	  fast = fast.next;
	}

	return ret;
  }

  static class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
	  this.val = val;
	  this.next = null;
	}
  }
}
