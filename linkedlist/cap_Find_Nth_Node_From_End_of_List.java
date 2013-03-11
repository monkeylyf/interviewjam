/*Find_Nth_Node_From_End_of_List
careercup

Implement an algorithm to find the nth to last element of a singly linked list
*/


class cap_Find_Nth_Node_From_End_of_List {
	public static void main(String[] args) {
	}
	public static void my(ListNode entry, int n) {
		ListNode tail = entry;
		for (int i = 0; i < n; ++i) {
            tail = tail.next;
        }
		while (tail != null) {
            tail = tail.next;
            entry = entry.next;
        }
		System.out.println(entry.data);
	}
    public static ListNode createLinkedList(int[] arr) {
        // Helper function. 
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cursor = head;     
        for (int i = 1; i < arr.length; ++i) {
            cursor.next = new ListNode(arr[i]);
            cursor = cursor.next;
        }
        return head;
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
