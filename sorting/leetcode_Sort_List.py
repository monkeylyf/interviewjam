#leetcode_Sort_List
#
#


class Solution:
    
    def sortList(self, head):
        """Using merge sort."""
        # Closed functions.
        def sort(head, length):
            if length <= 1:
                return head

            ruler = 1
            cursor = head

            while ruler < length / 2:
                cursor = cursor.next
                ruler += 1

            next_head = cursor.next
            cursor.next = None

            head = sort(head, ruler)
            next_head = sort(next_head, length - ruler)

            return merge(head, next_head)

        def merge(a, b):
            dummy = ListNode(-1)
            cur = dummy
            
            while a and b:
                if a.val <= b.val:
                    cur.next = a
                    a = a.next
                else:
                    cur.next = b
                    b = b.next

                cur = cur.next
           
            tail = a if a else b
            cur.next = tail

            return dummy.next                
        
        # Content of function sortList. 
        length = 0
        cursor = head

        while cursor:
            length += 1
            cursor = cursor.next

        return sort(head, length)
        
    def run(self):
        # Test case 1
        head = ListNode(3)
        head.next = ListNode(1)
        head.next.next = ListNode(4)
        head.next.next.next = ListNode(-1)

        res = self.sortList(head)

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
