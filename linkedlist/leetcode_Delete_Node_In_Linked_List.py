"""Delete node in linked list
leetcode

Write a function to delete a node (except the tail) in a singly linked list,
given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node
with value 3, the linked list should become 1 -> 2 -> 4 after calling your
function.
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        # Well, cannot delete a tail node without providing the precedent node
        if node.next is not None:
            node.val = node.next.val
            node.next = node.next.next


def main():
    sol = Solution()
    head = ListNode(0)
    head.next = ListNode(1)

    sol.deleteNode(head)
    print head.val


if __name__ == '__main__':
    main()
