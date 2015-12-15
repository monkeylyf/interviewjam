/*
 * Merge_k_Sorted_Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 */


import java.util.ArrayList;
import java.util.List;


class leetcode_Merge_k_Sorted_Lists {

  public static void main(String[] args) {
  }

  public static ListNode mergeTwo(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    ListNode dummy = new ListNode(0);
    ListNode cursor = dummy;

    while (l1 != null && l2 !=null) {
      if (l1.val > l2.val) {
        cursor.next = l2;
        l2 = l2.next;
      } else {
        cursor.next = l1;
        l1 = l1.next;
      }
      cursor = cursor.next;
    }

    if (l1 != null) {
      cursor.next = l1;
    } else {
      cursor.next = l2;
    }

    return dummy.next;
  }

  public static ListNode mergeKLists(List<ListNode> lists) {
    if (lists.size() == 0) {
      return null;
    }

    while (lists.size() > 1) {
      List<ListNode> toBeMerged = new ArrayList<ListNode>();
      int i = 0;
      for (; i < lists.size() - 2; i += 2) {
        ListNode merged = mergeTwo(lists.get(i), lists.get(i + 1));
        toBeMerged.add(merged);
      }

      if (i == lists.size() - 1) {
        toBeMerged.add(lists.get(i));
      }

      lists = toBeMerged;
    }

    return lists.get(0);
  }

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}

/* Python Version
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if not lists:
            return None

        while len(lists) > 1:
            to_be_merged = []

            i = 0
            while i + 1 < len(lists):
                to_be_merged.append(self.mergeTwo(lists[i], lists[i + 1]))
                i += 2
            if i == len(lists) - 1:
                to_be_merged.append(lists[i])
            lists = to_be_merged
        return lists[0]

    def mergeTwo(self, a, b):
        if a is None:
            return b
        if b is None:
            return a

        dummy = ListNode(0)
        cursor = dummy
        while a is not None and b is not None:
            if a.val > b.val:
                cursor.next = b
                b = b.next
            else:
                cursor.next = a
                a = a.next
            cursor = cursor.next
        if a is not None:
            cursor.next = a
        else:
            cursor.next = b
        return dummy.next
*/
