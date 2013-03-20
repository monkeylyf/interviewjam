/*Sort_LinekList

*/


class Sort_LinkedList {
    public static void main(String[] args) {
    
    }
    public static void mergeSort(ListNode head) {
    }
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
