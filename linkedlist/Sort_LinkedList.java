/*Sort_LinekList

*/


class Sort_LinkedList {
    public static void main(String[] args) {
    
    }
    // merge sort
    public static ListNode mergeSort(ListNode head) {
        if (head == null) {
            return head;
        }
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            ++count;
        }
        return mergeSortLinkedList(head, count);
    }
    public static ListNode mergeSortLinkedList(ListNode head, int count) {
        if (count <= 1) {
            return head;
        }
        int middle = count / 2;
        int ruler = 1;
        ListNode prev = head;
        ListNode cursor = head.next;
        while (ruler++ != middle) {
            prev = prev.next;
            cursor = cursor.next;
        }
        prev.next = null;
        ListNode left = mergeSortLinkedList(head, middle);
        ListNode right = mergeSortLinkedList(cursor, count - middle);
        return mergeLinkedList(left, right);
    }
    public static ListNode mergeLinkedList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        while (left != null || right != null) {
            if (left != null && right != null) {
                if (left.val <= right.val) {
                    cursor.next = new ListNode(left.val);
                    left = left.next;
                    cursor = cursor.next;
                } else {
                    cursor.next = new ListNode(right.val);
                    right = right.next;
                    cursor = cursor.next;
                }
            } else if (left != null) {
                while (left != null) {
                    cursor.next = new ListNode(left.val);
                    left = left.next;
                    cursor = cursor.next;
                }
            } else if (right != null) {
                while (right != null) {
                    cursor.next = new ListNode(right.val);
                    right = right.next;
                    cursor = cursor.next;
                }
            }
        }
        return dummy.next;
    }
    // quick sort.
    public static void quickSort(ListNode head) {
        if (head == null) {
            return;
        }
        int count = 0;
        ListNode node = head;
        while (node != null) {
            ++count;
            node = node.next;
        }
        quickSort()
        int pivot = head.val;
        ListNode prev = head;
        ListNode start = prev.next;
        ListNode end = start;

        while (end != null) {
            if (end.val < pivot) {
                swapNodeVal(start, end);
                prev = prev.next;
                start = start.next;

            }
        }
    }
    public static void swapNodeVal(ListNode a, ListNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}


class ListNode {
    public ListNode next;
    public int val;
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}
