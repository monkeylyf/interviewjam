/*Write code to remove duplicates from an unsorted linked list
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?*/

class test_9 {
	public static void main(String[] args) {
		Node n = new Node(1);
		n.addToTail(2);
		n.addToTail(3);
		n.addToTail(3);
		n.addToTail(4);
		n.addToTail(2);
		n.addToTail(2);
		n.printNodes();
		n.removeDup();
	}
}

class Node {
	Node next = null;
	int data;
	public Node(int d) {data = d;}

	public void addToTail(int d) {
		Node n = this;
		while (n.next != null) n = n.next;
		n.next = new Node(d);
	}

	public void printNodes() {
		Node n = this;
		System.out.print("Start printing all Node: " + this.data + " ");
		while (n.next != null) {
			n = n.next;
			System.out.print(n.data + " ");
		}
		System.out.println("");
	}

	public void removeDup() {
		if (this.next == null) return;
		Node processed = this, cur = this.next, iter;
		while (cur != null) {
			iter = this;
			while (iter != processed.next) {
				if (iter.data == cur.data) break;
				iter = iter.next;
			}
			if (iter == processed.next) {
				iter.data = cur.data;
				processed = processed.next;
			}
			cur = cur.next;
		}
		processed.next = null;
		printNodes();
	}
}
