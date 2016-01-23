"""Palindrome linked list.
leetcode


Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def isPalindrome(self, head):
        """O(n) space solution.

        Regarding the followup, it's absolutely fucking insane to reverse
        the second part of the linked list because it changes the input.
        Why the fuck would you do that? Or you are simply using the wrong
        data structure, or even you are asking the wrong fucking interview
        questions?
        This is a paradigm of bad interview questions(for the follow-up part)

        :type head: ListNode
        :rtype: bool
        """
        shit = []
        while head is not None:
            shit.append(head.val)
            head = head.next

        head = 0
        tail = len(shit) - 1
        while head < tail:
            if shit[head] != shit[tail]:
                return False
            head += 1
            tail -= 1
        return True


def main():
    sol = Solution()


if __name__ == '__main__':
    main()
