/*Implement_Infinite_Counter
google

How would you implement an infinite counter?
*/


class google_Implement_Infinite_Counter {
    public static void main(String[] args) {
        SuperCounter counter = new SuperCounter(5);
        for (int i = 0; i < 100; ++i) {
            counter.increase(1);
            printLinkedList(counter.head);
        }
    }
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " --> ");
            head = head.next;
        }
        System.out.println();
    }
}


class ListNode {
    ListNode next;
    int val;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


class SuperCounter {
    public ListNode head;
    private int maxLimit; // maximum limit on each node.
    private ListNode cur;
    SuperCounter(int x) {
        maxLimit = x;
        head = new ListNode(0);
        cur = head;
    }
    public void increase(int val) {
        if (cur.val + val < maxLimit) {
            cur.val += val;
        } else {
            cur.next = new ListNode(cur.val + val - maxLimit);
            cur.val = 0;
            cur = cur.next;
        }
    }
}
