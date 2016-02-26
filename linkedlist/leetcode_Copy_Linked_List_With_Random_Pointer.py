"""Copy linked list with random pointer
leetcode

A linked list is given such that each node contains an additional random pointer
which could point to any node in the list or null.

Return a deep copy of the list.
"""


# Definition for singly-linked list with a random pointer.
class RandomListNode(object):
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None


class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if not head:
            return head
        cursor = head
        # Create a copy after each node in given list.
        while cursor is not None:
            nex = cursor.next
            node = RandomListNode(cursor.label)
            cursor.next = node
            node.next = nex
            cursor = nex

        # Copy the pointers.
        cursor = head
        while cursor is not None:
            if cursor.random:
                cursor.next.random = cursor.random.next
            cursor = cursor.next.next

        cursor = head
        copy_head = head.next
        copy_cursor = copy_head

        # Seperate original list and copied ones.
        while copy_cursor is not None:
            cursor.next = copy_cursor.next
            if cursor.next:
                copy_cursor.next = cursor.next.next

            cursor = cursor.next
            copy_cursor = copy_cursor.next
        return copy_head


def main():
    sol = Solution()


if __name__ == '__main__':
    main()
