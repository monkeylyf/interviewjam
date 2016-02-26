"""Linked List Cycle
leetcode

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
"""


class Solution:

    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next:
            return False

        one = head
        two = head.next
        while one is not two:
            if two.next is None or two.next.next is None:
                return False
            one = one.next
            two = two.next.next
        return True


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def main():
    Solution().run()


if __name__ == '__main__':
    main()
