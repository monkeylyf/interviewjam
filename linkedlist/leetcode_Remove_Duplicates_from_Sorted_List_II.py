"""Remove Duplicates from sorted list II
leetcode

Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        dummy.next = head

        cursor = dummy
        while cursor.next:
            start = cursor.next
            while start.next and start.next.val == start.val:
                start = start.next
            if start is not cursor.next:
                cursor.next = start.next
            else:
                cursor = cursor.next
        return dummy.next


def main():
    sol = Solution()
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(3)
    head.next.next.next.next = ListNode(4)
    head.next.next.next.next.next = ListNode(4)
    head.next.next.next.next.next.next = ListNode(5)

    head = sol.deleteDuplicates(head)
    arr = []

    while head:
        arr.append(head.val)
        head = head.next
    assert arr == [1, 2, 5]


if __name__ == '__main__':
    main()
