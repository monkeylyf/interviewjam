"""Linked List cycle II
leetcode

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next or not head.next.next:
            return None

        # Why not one = head and two = head.next?
        # It won't cover [1, 2] and 2 points to 1 case.
        one = head.next
        two = head.next.next
        while one is not two:
            if two.next is None or two.next.next is None:
                return None
            one = one.next
            two = two.next.next

        while head is not one:
            one = one.next
            head = head.next
        return head


def main():
    sol = Solution()


if __name__ == '__main__':
    main()
