/*Sort_LinekList

Yuk....

1. merge sort
2. quick sort
*/


class Sort_LinkedList {

    public static void main(String[] args) {
		// Merge sort.
		// test case 1.
		ListNode head = null;
		head = addToTail(head, 5);
		head = addToTail(head, 20);
		head = addToTail(head, 4);
		head = addToTail(head, 3);
		head = addToTail(head, 30);
		print(head);
		head = mergeSort(head);
		print(head);

		// test case 2. ll contains only one node.
		head = null;
		head = addToTail(head, 1);
		print(head);
		head = mergeSort(head);
		print(head);

		// test case 3. ll is empty.
		head = null;
		print(head);
		head = mergeSort(head);
		print(head);

		// QuickSort.
		// test case 1.
		head = null;
		head = addToTail(head, 5);
		head = addToTail(head, 20);
		head = addToTail(head, 4);
		head = addToTail(head, 3);
		head = addToTail(head, 30);
		print(head);
		quickSort(head);
		print(head);
		// test case 2.
		head = null;
		head = addToTail(head, 1);
		print(head);
		quickSort(head);
		print(head);
		// test case 3. ll is empty.
		head = null;
		print(head);
		quickSort(head);
		print(head);
    }

    // Merge sort.
    public static ListNode mergeSort(ListNode head) {
        if (head == null) {
            return head;
        }
		// Iterate ll and find the total num of nodes.
        int count = length(head);
        return mergeSortUtil(head, count);
    }

	// Divide linkedlist to two recursively.
    public static ListNode mergeSortUtil(ListNode head, int count) {
        if (count <= 1) {
            return head;
        }
		// Cut ll into two.
        int middle = count / 2, ruler = 1;
        ListNode prev = head;
        ListNode cursor = head.next;
        while (middle != ruler) {
            prev = prev.next;
            cursor = cursor.next;
			++ruler;
        }
        prev.next = null;
		// Recusively merge left and right part of ll.
        ListNode left = mergeSortUtil(head, middle);
        ListNode right = mergeSortUtil(cursor, count - middle);
		// Merge two sorted ll.
        return mergeLinkedList(left, right);
    }

	// Merge two sorted linkedlist.
    public static ListNode mergeLinkedList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
		// Append node in ascending order til one of the pointers becomes null.
        while (left != null && right != null) {
			if (left.val <= right.val) {
				cursor.next = new ListNode(left.val);
				left = left.next;
			} else {
				cursor.next = new ListNode(right.val);
				right = right.next;
			}
			cursor = cursor.next;
		}
		// Append non-null pointer to the end.
		if (left != null) {
			cursor.next = left;	
		}
		if (right != null) {
			cursor.next = right;	
		}
        return dummy.next;
    }

    // quick sort.
    public static void quickSort(ListNode head) {
        if (head == null) {
            return;
        }
		// Get the length of linkedlist.
        int len = length(head);
		if (len == 1) { // linkedlist with length 1 is considered sorted.
			return;
		}
		quickSortUtil(head, len);
    }

	public static void quickSortUtil(ListNode head, int len) {
		if (head == null || len <= 1) {
			return;	
		}
		// Pick head as pivot.
        int pivotVal = head.val, ruler = 1;
		// Swap the last node with pivot.
		ListNode end = head;
		while (ruler != len) {
			end = end.next;	
			++ruler;
		}
		swapNodeVal(head, end);
		// In-space partition.
		int step = 0;
		ListNode store = head, cursor = head;
		while (cursor != end) {
			if (pivotVal > cursor.val) {
				swapNodeVal(store, cursor);
				store = store.next;
				++step;
			}
			cursor = cursor.next;
		}
		swapNodeVal(cursor, store); // Swap pivot in the middle. Partition finished.
		quickSortUtil(head, step);
		quickSortUtil(store.next, len - 1 - step);
	}

    public static void swapNodeVal(ListNode a, ListNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

	// Helper function to get the length of linkedlist.
	public static int length(ListNode head) {
		if (head == null) {
			return 0;	
		} else {
			int count = 0;
			while (head != null) {
				head = head.next;
				++count;
			}
			return count;
		}
	}

	// Helper function to print linkedlist.
	public static void print(ListNode head) {
		if (head == null) {
			System.out.println("null");	
		} else {
			while (head != null) {
				System.out.print(head.val + " -> ");	
				head = head.next;
			}
			System.out.println("null");
		}
	}

	// Helper function to add a new ListNode to the end of of current linked list.
	public static ListNode addToTail(ListNode head, int val) {
		if (head == null) {
			head = new ListNode(val);
		} else {
			ListNode dummy = head;
			while (dummy.next != null) {
				dummy = dummy.next;	
			}
			dummy.next = new ListNode(val);
		}
		return head;
	}
}


class ListNode {
    public ListNode next;
    public int val;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
