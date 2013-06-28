/*MS_Copy_Linked_List_With_Random_Pointer
Microsolf

Given a linkedlist which has next() and random().
next() points to next node and random() points to a random node in this
linkedlist.

Copy this linkedlist in O(n)
*/


class MS_Copy_Linked_List_With_Random_Pointer {
    public static void main(String[] args) {
    
    }

    public static ListNode copyLinkedList(ListNode head) {
        // TODO: code incomplete
        if (head == null) {
            return null;
        }
        ListNode ret = new ListNode(head.val);
        ret.random = head;
        ListNode copyCursor = ret;
        ListNode cursor = head;
        while (cursor.next != null) {
            ListNode newNode = new ListNode(cursor.next.val);
            newNode.random = cursor.next;
            copyCursor.next = newNode;
            
            copyCursor = copyCursor.next;
            cursor = cursor.next;
        }
        cursor = head;
        copyCursor = ret;
        while (cursor != null) {
            ListNode nextNode = cursor.next;
            cursor.next = copyCursor;
            
            cursor = nextNode;
            copyCursor = copyCursor.next;
        }
        copyCursor = ret;
        while (copyCursor != null) {
            ListNode tmpRandom = copyCursor.random.random.next;
            copyCursor.random = copyCursor.random.random.next;
            copyCursor = copyCursor.next;
        }
        // Restore next pointer of original linkedlist.
        cursor = head;
        while (cursor != null) {
            cursor.next = cursor.next.next
        }
    }

	// More elegant solution.
    public static ListNode copy(ListNode head) {
        // Time complexity: O(n) + O(n) + O(n).
        if (head == null) {
            return null;
        }
        ListNode cursor = head;
        while (cursor != null) {
            // a->b->c became a->A->b->B->c->C
            ListNode dup = cursor;
            cursor.next = dup;
            cursor = dup.next;
        }
        cursor = head;
        while (cursor != null) {
            // Pointer dup's random to next random instead original.
            cursor.next.random = cursor.random.next;
            cursor = cursor.next.next;
        }
        ListNode ret = head.next;
        cursor = head;
        while (cursor != null) {
            // Breaking the link between dup and orinal so 
            // The input linedlist remains the same.
            ListNode copy = cursor.next;
            cursor.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            cursor = cursor.next;
        }
        return ret;
    }
}


class ListNode {
    ListNode random;
    ListNode next;
    int val;
    ListNode(int x) {
        this.random = null;
        this.next = null;
        this.val = x;
    }
}
