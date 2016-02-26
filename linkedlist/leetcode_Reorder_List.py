"""Reorder list
leetcode

Given a singly linked list L: L0 -> L1 -> ... -> Ln-1 -> Ln,
reorder it to: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):

    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return

        one = head
        two = head.next
        while two.next and two.next.next:
            one = one.next
            two = two.next.next
        two = one.next
        one.next = None
        one = head
        two = self.reverse_ll(two)

        while one.next:
            one_nex = one.next
            two_nex = two.next
            one.next = two
            two.next = one_nex
            one = one_nex
            two = two_nex
        one.next = two

    def reverse_ll(self, head):
        prev = None
        while head:
            nex = head.next
            head.next = prev
            prev = head
            head = nex
        return prev


def main():
    sol = Solution()


if __name__ == '__main__':
    main()
