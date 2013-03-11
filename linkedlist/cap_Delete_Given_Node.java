/*Delete_Given_Node
careercup

Implement an algorithm to delete a node in the middle of a single linked list, given
only access to that node.
EXAMPLE
Input: the node ‘c’ from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a->b->d->e
*/

class cap_Delete_Given_Node {
	public static void main(String[] args) {
	}
	public static void deleteNode(Node n) {
        // This solution has one flaw: if n is the last node of this ll?
        // Without given previous, it can not be done? preivous.next = null
        // Tell your interviewer you thought!
        if (n == null || n.next == null) {
            return;
        }
        n.val = n.next.val;
        n.next = n.next.next;
        return;
	}
}


class ListNode {
    ListNode next;
    int val;
    ListNode(int x) {
        this.next = null;
        this.val = x;
    }
}
