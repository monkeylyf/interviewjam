/*Add_Two_Numbers
careercup

You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
the list. Write a function that adds the two numbers and returns the sum as a linked
list.
EXAMPLE
Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
Output: 8 -> 0 -> 8

Mark as duplicates:
please check: leetcode_Add_Two_Numbers.java
*/

class cap_Add_Two_Numbers {
	public static void main(String[] args) {
		Node n1 = new Node(5);
		n1.addToTail(1);
		n1.addToTail(7);
		Node n2 = new Node(2);
		n2.addToTail(9);
		n2.addToTail(5);
        Node retval = addTwo(n1, n2);
        while (retval != null) {
            System.out.println(retval.data);
            retval = retval.next;
        }
	}
	public static Node addTwo(Node a, Node b) {
        Node head = new Node(0);
        Node cur = head;
        int carry = 0;
        while (true) {
            if (a != null && b != null) {
                cur.next = new Node((a.data + b.data + carry) % 10);
                carry = (a.data + b.data + carry) / 10;
                cur = cur.next;
                a = a.next;
                b = b.next;
            } else if (a == null && b == null) {
                if (carry == 1) cur.next = new Node(1);
                break;
            } else {
                if (a == null) {
                    cur.next = new Node((b.data + carry) % 10);
                    carry = (b.data + carry) / 10;
                    cur = cur.next;
                    b = b.next;
                } else {
                    cur.next = new Node((a.data + carry) % 10);
                    carry = (a.data + carry) / 10;
                    cur = cur.next;
                    a = a.next;
                }
            }
        }
        return head.next;
	}
}


class Node {
	Node next;
	int data;
	public Node(int d) {
        data = d;
        next = null;
    }
	public void addToTail(int d) {
		Node node = this;
		while (node.next != null) {node = node.next;}
		node.next = new Node(d);
	}
}
