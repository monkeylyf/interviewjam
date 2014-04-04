/*Partition_List

Given a linked list and a value x, partition it such that all nodes less than x
come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two
partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

class leetcode_Partition_List {
    public static void main(String[] args) {
        ListNode less = new ListNode(1);
        less.next = new ListNode(2);
        partition(less, 2);
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode lessPtr = less;
        ListNode more = new ListNode(0);
        ListNode morePtr = more;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                lessPtr.next = new ListNode(node.val);
                lessPtr = lessPtr.next;
            } else {
                morePtr.next = new ListNode(node.val);
                morePtr = morePtr.next;
            }
            node = node.next;
        }
        if (less.next == null) {
            return more.next;
        } else {
            lessPtr.next = more.next;
        }
        return less.next;
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

/* Python Version
*Note* Dummy head is necessary in such case since you do not know
if the head will be partitioned or not.

def partition(self, head, x):
    if not head:
        return head
    
    # Create dummy head for head
    less = ListNode(-1)
    cursor_less = less
    
    # Create dummy head for right part
    more = ListNode(-1)
    more.next = head
    cursor_more = more
    
    while cursor_more.next:
        if cursor_more.next.val >= x:
            cursor_less.next = cursor_more.next
            cursor_more.next = cursor_more.next.next
            cursor_less = cursor_less.next
            cursor_less.next = None
        else:
            cursor_more = cursor_more.next
    
    cursor_more.next = less.next
    return more.next
*/
