# https://leetcode.com/problems/merge-in-between-linked-lists/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        # Check length of list1 is larger than b.
	# Dummy head is essential when a == 0
        dummy = TreeNode(None)
        dummy.next = list1
       	# Poinpoint prev start and prev end.
        tail = dummy
        head = dummy
        while b >= 0 and a > 0:
            tail = tail.next
            b -= 1
            head = head.next
            a -= 1

        while b >= 0:
            tail = tail.next
            b -= 1

        while a > 0:
            head = head.next
            a -= 1
	# Redirect start.
        head.next = list2
       	# Locate tail node of list2.
        while list2.next is not None:
            list2 = list2.next
	# Redirect end.
        list2.next = tail.next
        tail.next = None
	# Reset dummy head.
        dummy.next = None

        return list1
