/* Stack_with_Op_on_Middle
geeksforgeeks

How to implement a stack which will support following operations in O(1)
time complexity?
1) push() which adds an element to the top of stack.
2) pop() which removes an element from top of stack.
3) findMiddle() which will return middle element of the stack.
4) deleteMiddle() which will delete the middle element. Push and pop are
standard stack operations.
*/
class Stack_with_Op_on_Middle {

	public static void main(String[] args) {
		// test case.
		Stack s = new Stack();
		for (int i = 0; i < 10; ++i) {
			s.push(i);
			s.printChain();
			System.out.println("mid " + s.peekMid());
		}
		
		System.out.println("-----");
		for (int i = 0; i < 10; ++i) {
			System.out.println("pop " + s.pop());
			s.printChain();
		}
	}

	static class Stack {
		DLLNode head;
		DLLNode mid;
		int size;

		Stack() {
			this.head = null;
			this.mid = null;
			this.size = 0;
		}

		public void push(int data) {
			// Create a new node and attach it to head.
			DLLNode node = new DLLNode(data);
			node.next = this.head;
			// increase size by one.
			++this.size;
			// Update pointers.
			if (this.size == 1) {
				this.mid = node;
			} else {
				this.head.prev = node;
				if (this.size % 2 == 1) {
					this.mid = this.mid.prev;
				}
			}
			this.head = node;
		}

		public int pop() {
			if (this.size == 0) {
				System.out.println("Stack is empty");
				return Integer.MIN_VALUE;
			} else {
				int ret = this.head.val;
				--this.size;
				// Update pointers.
				DLLNode new_head = this.head;
				this.head = new_head.next;

				if (this.head != null) {
					this.head.prev = null;
				} else {
					this.mid = null;
				}

				if (this.size % 2 == 0 && this.mid != null) {
					this.mid = this.mid.next;
				}

				return ret;
			}
		}

		public int peekMid() {
			if (this.size == 0) {
				System.out.println("Stack is empty");
				return Integer.MIN_VALUE;
			} else {
				return this.mid.val;
			}
		}
		
		public void printChain() {
			if (this.head == null) {
				System.out.println("Stack is empty");
			} else {
				DLLNode cursor = this.head;
				while (cursor != null) {
					System.out.print(cursor.val + " ");
					cursor = cursor.next;
				}
				System.out.println();
			}
		}
	}
	
	static class DLLNode {
		DLLNode prev;
		DLLNode next;
		int val;

		DLLNode(int val) {
			this.prev = null;
			this.next = null;
			this.val = val;

		}
	}
}
