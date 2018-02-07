"""Reverse a doubly linked list."""


class DoublyLinkedListNode(object):

    def __init__(self, val=None, prev=None, nex=None):
        self.val = val
        self.prev = prev
        self.next = nex


def print_dll(head, nex=True):
    while head:
        print(head.val, '->', end=' ')
        if nex:
            head = head.next
        else:
            head = head.prev
    print('Nil')


def reverse_dll(head):
    """It is almost identical to reverse a linked list, with one line diff."""
    prev = None
    while head:
        next_node = head.next
        head.next = prev
        head.prev = next_node
        prev = head
        head = next_node
    return prev


def main():
    head = DoublyLinkedListNode(val=2)
    nex = DoublyLinkedListNode(val=4, prev=head)
    head.next = nex
    tail = DoublyLinkedListNode(val=6, prev=nex)
    nex.next = tail

    print_dll(head)

    reversed_head = reverse_dll(head)

    print_dll(reversed_head)





if __name__ == '__main__':
    main()
