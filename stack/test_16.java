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
		my s3 = new my();
		int loop = 8;
		System.out.println("array size is: " + s3.arraySize());
		System.out.println("stack size is: " + s3.stackSize());
		System.out.println("total # of elements is:" + s3.totalSize());
		System.out.println("-------------");

		for (int i = 0; i < loop; ++i) {
			s3.push(i);
			System.out.println("array size is: " + s3.arraySize());
			System.out.println("stack size is: " + s3.stackSize());
			System.out.println("total # of elements is:" + s3.totalSize());
			System.out.println("-------------");
		}

		for (int j = 0; j < loop; ++j) {
			s3.pop();
			System.out.println("array size is: " + s3.arraySize());
			System.out.println("stack size is: " + s3.stackSize());
			System.out.println("total # of elements is:" + s3.totalSize());
			System.out.println("-------------");
		}

		for (int k = 0; k < loop; ++k) {
		        s3.push(k);
		}

		System.out.println(s3.popAt(0));
		System.out.println(s3.popAt(1));
	}
}

class my {
	ArrayList<Stack> s = new ArrayList<Stack>();
	int lenlimit = 4;
	int arrlen = -1;
	int stacklen = lenlimit;

	public void push(int d) {
		if (stacklen >= lenlimit) {
			Stack newstack = new Stack();
			newstack.push(d);
			s.add(newstack);
			++arrlen;
			stacklen = 1;
		} else {
			s.get(arrlen).push(d);
			++stacklen;
		}
	}

	public int pop() {
		if (arrlen == -1) return Integer.MAX_VALUE;
		if (stacklen == 1) {
			--arrlen;
			stacklen = lenlimit;
			return s.get(arrlen + 1).pop();
		} else {
			--stacklen;
			return s.get(arrlen).pop();
		}
	}

	public int arraySize() {return arrlen + 1;}

	public int stackSize() {
		if (arraySize() == 0) return 0;
		return stacklen;
	}

	public int totalSize() {
		if (arraySize() == 0) return 0;
		return (arraySize() - 1) * lenlimit + stacklen;
	}

	public int popAt(int index) {
		if (arraySize() == 0) return Integer.MAX_VALUE;
		return s.get(index).pop();
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
                if (top != null) {
                        int d = top.data;
                        top = top.next;
                        return d;
                }
                return Integer.MAX_VALUE;
        }
}


class Node {
        Node next = null;
        int data;
        public Node(int d) {data = d;}
}
