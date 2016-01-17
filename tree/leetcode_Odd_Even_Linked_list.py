"""Odd even linked list.
leetcode

Given a singly linked list, group all odd nodes together followed by the even
nodes. Please note here we are talking about the node number and not the value
in the nodes.
You should try to do it in place. The program should run in O(1) space
complexity and O(nodes) time complexity.
"""

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return head

        odd_head = ListNode(-1)
        even_head = ListNode(-1)
        dummy_head = ListNode(-1)
        dummy_head.next = head

        odd_cursor = odd_head
        even_cursor = even_head

        is_odd = True

        while dummy_head.next is not None:
            if is_odd:
                odd_cursor.next = dummy_head.next
                odd_cursor = odd_cursor.next
            else:
                even_cursor.next = dummy_head.next
                even_cursor = even_cursor.next

            dummy_head = dummy_head.next

            is_odd = not is_odd

        # Still point to the next odd node if there is, which will cause loop.
        even_cursor.next = None
        odd_cursor.next = even_head.next
        return odd_head.next


def main():
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)

    head = Solution().oddEvenList(head)

    while head is not None:
        print head.val,
        head = head.next
    print


if __name__ == '__main__':
    main()
