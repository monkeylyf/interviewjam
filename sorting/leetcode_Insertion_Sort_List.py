#leetcode_Insertion_Sort_List



class Solution:

    def insertionSortList(self, head):
        """Insertion sort.
        
        Time complexity: O(n^2)
        Space complexity: O(1) 
        """
        # Create a dummy node as head
        dummy = ListNode(-1)
        dummy.next = head
       
        # Cursor to iterate through all nodes
        cursor = head

        while cursor.next:
            # All visited nodes can be considered as a sorted one.
            # if value of cursor is no larger than the next value, no need to insert.
            if cursor.next.val >= cursor.val:
                cursor = cursor.next
                continue

            # Find the right position to insert.
            iterator = dummy

            while iterator.next is not cursor.next:
                if iterator.next.val > cursor.next.val:
                    # Swaping nodes. Be careful with the pointers.
                    swap = cursor.next
                    cursor.next = swap.next
                    swap.next = iterator.next
                    iterator.next = swap
                    break
                iterator = iterator.next
   
        return dummy.next

    def run(self):
        # Test case 1
        head = ListNode(3)
        head.next = ListNode(1)
        head.next.next = ListNode(4)
        head.next.next.next = ListNode(-1)

        res = self.insertionSortList(head)

        print '\nFinal res:',
        self.printList(res)

    def printList(self, head):
        while head:
            print head,
            head = head.next
        print 'None'


class ListNode:
    
    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
        return '{0} ->'.format(self.val)


def main():
    Solution().run()


if __name__ == '__main__':
    main()
