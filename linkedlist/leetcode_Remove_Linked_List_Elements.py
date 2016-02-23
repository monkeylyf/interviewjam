"""Remove linked list elements
leetcode

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
"""

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        dummy.next = head
        cursor = dummy
        while cursor.next is not None:
            if cursor.next.val == val:
                cursor.next = cursor.next.next
            else:
                cursor = cursor.next
        return dummy.next


def main():
    sol = Solution()
    # No testing


if __name__ == '__main__':
    main()
