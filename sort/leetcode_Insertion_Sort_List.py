"""Insertion Sort List
leetcode

Sort a linked list using insertion sort.
"""


class ListNode:

    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
        return '{0} ->'.format(self.val)


class Solution(object):

    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return head
        # Dummy is necessary when swapping because it's possible the head needs
        # to be swapped thus need previous node of head, which is dummy.
        dummy = ListNode(-1)
        dummy.next = head
        prev = head
        cursor = head.next
        while cursor is not None:
            if prev.val > cursor.val:
                inserted = dummy
                while inserted.next is not cursor:
                    if inserted.next.val > cursor.val:
                        # Find the right node to swap to cursor
                        prev.next = cursor.next
                        cursor.next = inserted.next
                        inserted.next = cursor
                        break
                    inserted = inserted.next
                cursor = prev.next
            else:
                cursor = cursor.next
                prev = prev.next
        return dummy.next


def printList(head):
    while head:
        print head,
        head = head.next
    print 'None'


def main():
    sol = Solution()

    # Test case 1
    head = ListNode(3)
    head.next = ListNode(1)
    head.next.next = ListNode(4)
    head.next.next.next = ListNode(-1)

    res = sol.insertionSortList(head)

    printList(res)


if __name__ == '__main__':
    main()
