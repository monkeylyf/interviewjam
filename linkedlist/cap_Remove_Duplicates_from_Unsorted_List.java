/*Remove_Duplicates_from_Unsorted_List
careercup

Write code to remove duplicates from an unsorted linked list
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/

import java.util.*;


public class cap_Remove_Duplicates_from_Unsorted_List {
    public static void main(String[] args) {
        // Test cases.
        ListNode test1 =createLinkedList(new int[] {});
        removeDup(test1);
        ListNode test2 =createLinkedList(new int[] {0});
        removeDup(test2);
        ListNode test3 =createLinkedList(new int[] {1, 2});
        removeDup(test3);
        ListNode test4 =createLinkedList(new int[] {1, 1});
        removeDup(test4);
        ListNode test5 =createLinkedList(new int[] {1, 2, 3, 4, 5});
        removeDup(test5);
        ListNode test6 =createLinkedList(new int[] {3, 2, 3, 2, 1, 2, 3, 0});
        removeDup(test6);
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
    public static void removeDup(ListNode head) {
        // Idea is same as Remove_Duplicates_from_Unsorted_Array
        System.out.println("Before ");
        print(head);
        if (head == null) {
            return;
        }
        ListNode processed = head, cursor = head.next;
        while (cursor != null) {
            ListNode i = head;
            while (i != processed.next) {
                if (i.val == cursor.val) {
                    break;
                }
                i = i.next;
            }
            if (i == processed.next) {
                processed.next.val = cursor.val;
                processed = processed.next;
            }
            cursor = cursor.next;
        }
        processed.next = null;
        System.out.println("After ");
        print(head);
    }
    public static void print(ListNode head) {
        // Helper function.
        ListNode cursor = head;
        while (cursor != null) {
            System.out.print(cursor.val + " -> ");
            cursor = cursor.next;
        }
        System.out.println("null");
    }
    public static void removeWithBuffer(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode cursor = head;
        ListNode previous = null;
        while (cursor != null) {
            if (set.contains(cursor)) {
                previous.next = cursor.next;
            } else {
                set.add(cursor);
                previous = cursor;
            }
            cursor = cursor.next;
        }
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
