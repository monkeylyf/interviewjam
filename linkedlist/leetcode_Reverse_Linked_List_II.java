/*Reverse_Linked_List_II

Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.
Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

class leetcode_Reverse_Linked_List_II {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(-3);
        reverseBetween(head, 1, 1);
    
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = null;
        ListNode end = res;
        while (true) {
            if (count >= m && count < n) {
                // Paradigm of reverse linked list.
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            } else if (count < m) {
                // Move by one node.
                end = prev;
                prev = cur;
                cur = cur.next;
            } else if (count == n) {
                end.next.next = cur; // last node of reverse part pointing to rest of ll.
                end.next = prev; // part which less than m, pointing to the begining of reversed part.
                break;
            }
            ++count;
        }
        return res.next;
    }
    // Do a simple reverse LinkList first to brush it up.
    // Recursive way.
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode second = head.next;
        head.next = null;
        ListNode reversed = reverse(second);
        second.next = head;
        return reversed;
    }
    // While loop way which I prefer.
    public static ListNode rev(ListNode head) {
        ListNode end = head, prev = head, cur = head.next, next = null;
        while (cur != null) {
            next = cur.next; // Preference for cur.next so after reverse loop can move on.
            cur.next = prev; // Pointing cur.next from next one to previous one.
            // Move on by on node.
            prev = cur;
            cur = next;
        }
        end.next = null; // Pointing the first node to null. Complete reversing.
        return prev;
    }
}


class ListNode {
    ListNode next;
    int val;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
