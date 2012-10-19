/*Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack
exceeds some threshold. Implement a data structure SetOfStacks that mimics this
SetOfStacks should be composed of several stacks, and should create a new stack
once the previous one exceeds capacity. SetOfStacks push() and SetOfStacks pop()
should behave identically to a single stack (that is, pop() should return the
same values as it would if there were just a single stack)
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific
sub-stack.
*/
import java.util.ArrayList;


class test_16 {
	public static void main(String[] args) {
		setOfStack s3 = new setOfStack();
		int loop = 8;
		System.out.println(s3.arraySize());
		System.out.println(s3.stackSize());
		System.out.println(s3.totalSize());
		System.out.println("-------------");

		for (int i = 0; i < loop; ++i) {
			s3.push(i);
			System.out.println(s3.arraySize());
			System.out.println(s3.stackSize());
			System.out.println(s3.totalSize());
			System.out.println("-------------");
		}

		for (int j = 0; j < loop; ++j) {
			s3.pop();
			System.out.println(s3.arraySize());
			System.out.println(s3.stackSize());
			System.out.println(s3.totalSize());
			System.out.println("-------------");
		}

		for (int k = 0; k < loop; ++k) {
		        s3.push(k);
		}

		System.out.println(s3.popAt(0));
		System.out.println(s3.popAt(1));
		System.out.println(s3.popAt(2));
	}
}

class setOfStack{
	int sizeLimit = 3;
	int arraysize = 0;
	int stacksize = 0;
	ArrayList<Stack> s = new ArrayList<Stack>();

	public void push(int d) {
		if (arraysize == 0 ) {
			Stack stack = new Stack();
			stack.push(d);
			s.add(stack);
			++stacksize;
			++arraysize;
		} else {
			if (stacksize < sizeLimit) {
				s.get(arraysize - 1).push(d);
				++stacksize;
			} else {
				Stack stack = new Stack();
				stack.push(d);
				s.add(stack);
				++arraysize;
				stacksize = 1;
				}
			}
	}

	public int pop() {
		if (arraysize == 0) return Integer.MAX_VALUE;
		int data = s.get(arraysize - 1).pop();
		--stacksize;
		if (stacksize == 0) {
			s.remove(arraysize - 1);
			--arraysize;
			if (arraysize == 0) {stacksize = 0;
			} else {stacksize = sizeLimit;}
		}
		return data;
	}

	public int popAt(int index) {return s.get(index).pop();} 

	public Node peek() {return s.get(arraysize - 1).peek();}

	public boolean isEmpty() {return arraysize == 0;}

	public int arraySize() {return arraysize;}

	public int stackSize() {return stacksize;}

	public int totalSize() {
		if (stacksize == 0 && arraysize == 0) return 0;
		return ((arraysize - 1) * sizeLimit +  stacksize);
	}
}

class Stack {
	Node top;

	public void push(int d) {
		Node node = new Node(d);
		node.next = top;
		top = node;
	}

	public int pop() {
		int d = top.data;
		top = top.next;
		return d;
	}

	public Node peek() {return top;}

	public boolean isEmpty() {return top == null;}

	public int size() {
		Node node = top;
		int size = 0;
		while (node != null) {
			node = node.next;
			++size;
		}
		return size;
	}
}

class Node {
	Node next = null;
	int data;
	public Node(int d) {data = d;}
}
