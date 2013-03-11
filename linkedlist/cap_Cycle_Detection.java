/*Cycle_Detection
careercup

Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
Definition:
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node,
so as to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C -> D -> E -> C [the same C as earlier]
Output: C
*/

class cap_Cycle_Detection {
    public static void main(String[] args) {
        ListNode a = new ListNode("A");
        ListNode b = new ListNode("B");
        ListNode c = new ListNode("C");
        ListNode d = new ListNode("D");
        ListNode e = new ListNode("E");
        ListNode f = new ListNode("F");
        ListNode g = new ListNode("G");
        ListNode h = new ListNode("H");
        ListNode i = new ListNode("I");
        ListNode j = new ListNode("J");
        ListNode k = new ListNode("K");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;
        j.next = k;
        k.next = d; // Beginning node!
        System.out.println("Beginning node is " + my(a).data);

    }
    public static ListNode my(ListNode entry) {
        // Tortoise and hare
        ListNode a1 = entry, a2 = entry;
        while (true) {
            a1 = a1.next;
            a2 = a2.next.next;
            if (a1 == a2) {
                break;
            }
        }
        while (true) {
            a1 = a1.next;
            entry = entry.next;
            if (entry == a1) {
                break;
            }
        }
        return entry;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

