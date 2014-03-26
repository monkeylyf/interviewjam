/*Merge_k_Sorted_Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and
describe its complexity.
*/


import java.util.ArrayList;


class leetcode_Merge_k_Sorted_Lists {
    public static void main(String[] args) {
    }
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            mergeTwo(head, lists.get(i));
        }
        return head.next;
    }
    public static void mergeTwo(ListNode head, ListNode list){
        ListNode tmp = head.next;
        ListNode prev = head; 
        if (tmp == null) {
            head.next = list;
        }
        while (tmp != null && list != null) {
            if (tmp.val < list.val) {
                if (tmp.next != null) {
                    // tmp ptr and prev ptr move by one step.
                    prev = tmp;
                    tmp = tmp.next;
                } else {
                    // Simply copy list to tmp.next and done.
                    tmp.next = list;
                    break;
                }
            } else {
                // Must be: prev.val >= list.val >= tmp.val.
                ListNode temp = list.next;
                prev.next = list;
                list.next = tmp;
                // Move by one step.
                prev = list;
                list = temp;
            }
        }
    }
    // Time limit exceeded.
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        ArrayList<ListNode> tmp = lists;
        ListNode res = new ListNode(0);
        ListNode head = res;
        res = res.next;
        for (int i = 0; i < tmp.size(); ++i) {
            if (tmp.get(i) == null) {
                tmp.remove(i);
            }
        }
        if (tmp.size() == 0) return null;
        if (tmp.size() == 1) return lists.get(0);
        int minIndex;
        while (tmp.size() != 0) {
            minIndex = 0;
            for (int i = 1; i < tmp.size(); ++i) {
                if (tmp.get(i).val < tmp.get(minIndex).val) {
                    minIndex = i;
                }
            }
            ListNode min = tmp.get(minIndex);
            res = new ListNode(min.val);
            res = res.next;
            if (min.next != null) min = min.next;
            else tmp.remove(minIndex);
        }
        return head.next;
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

/* Python Version (alright, TLE)
class Solution:
    # @param a list of ListNode
    # @return a ListNode
    def mergeKLists(self, lists):
        if not lists:
            return None

        while len(lists) > 1:
            nex = []
            for i in xrange(0, len(lists), 2):
                try:
                    nex.append(self.mergeTwo(lists[i], lists[i + 1]))
                except IndexError:
                    nex.append(lists[i])
            lists = nex
        return lists[-1]
        
    def mergeTwo(self, a, b):
        if not a:
            return b
        if not b:
            return a

        # use a as base.
        dummy = ListNode(-1)
        dummy.next = a
        prev = dummy
        while a and b:
            if b.val >= a.val:
                print 'hit'
                a = a.next
                prev = prev.next
            else:
                nex = b.next
                prev.next = b
                b.next = a
                b = nex
                prev = prev.next

        if b:
            prev.next = b
        return dummy.next
*/
