# leetcode_Linked_List_Cycle.py


class Solution:
    # @param head, a ListNode
    # @return a boolean
    def hasCycle(self, head):
        if not head or not head.next or not head.next.next:
            return False
            
        fast = head.next.next
        slow = head.next
        
        while fast is not slow:
            if not fast or not fast.next:
                return False
                
            fast = fast.next.next
            slow = slow.next
            
        return True

    def run(self):
        # Test cases here.


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def main():
    Solution().run()


if __name__ == '__main__':
    main()
