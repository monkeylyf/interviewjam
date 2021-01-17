# https://leetcode.com/problems/swapping-nodes-in-a-linked-list/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def swapNodes(self, head: ListNode, k: int) -> ListNode:
        # Get first kth parent.
        dummy_head = ListNode(0)
        dummy_head.next = head
        first_parent = dummy_head
        i = 1
        while i < k:
            first_parent = first_parent.next
            i += 1
        # Get last kth parent.
        second_parent = dummy_head
        tail = dummy_head
        for _ in range(k):
            tail = tail.next
        while tail.next is not None:
            second_parent = second_parent.next
            tail = tail.next

        # Probably overkill since node is mutable but if not, swapping node
        # reference instead value.
        tmp = first_parent.next.val
        first_parent.next.val = second_parent.next.val
        second_parent.next.val = tmp

        dummy_head.next = None  # Disconnect dummy head.

        return head


def main():
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    sol = Solution()
    print(sol.swapNodes(head, 2))


if __name__ == '__main__':
    main()
