"""Intersection of two linked list
leetcode

Write a program to find the node at which the intersection of two singly linked
lists begins.


For example, the following two linked lists:

A:          a1 -> a2
                   ->
                     c1 -> c2 -> c3
                   ->
B:     b1 -> b2 -> b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function
returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        len_a = self.length(headA)
        len_b = self.length(headB)

        while len_a > len_b:
            headA = headA.next
            len_a -= 1
        while len_b > len_a:
            headB = headB.next
            len_b -= 1

        while headA is not headB:
            headA = headA.next
            headB = headB.next
        return headA

    def length(self, node):
        count = 0
        while node is not None:
            count += 1
            node = node.next
        return count


def main():
    sol = Solution()

    a = ListNode(1)
    a.next = ListNode(2)
    b = ListNode(1)
    intersection = ListNode(3)
    b.next = intersection
    a.next.next = intersection

    intersection.next = ListNode(4)
    intersection.next.next = ListNode(5)

    assert sol.getIntersectionNode(a, b) is intersection


if __name__ == '__main__':
    main()
