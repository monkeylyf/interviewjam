/*Describe how you could use a single array to implement three stacks*/


class test_14 {
	public static void main(String[] args) {
		System.out.println("----------------");
		myStack s = new myStack();
		s.printAll();
		s.push(55, 0);s.push(1,1);s.push(2,2);
		s.printAll();
		System.out.println(s.pop(0));s.pop(1);s.pop(2);
		s.printAll();
	}
}

// Divide the array into three
class myStack {
	int size = 3;
	int[] buffer = new int[size * 3];
	int[] ptr = {0, size, size *2};

	public void push(int d, int num) {
		if (ptr[num] % size >= size - 1) {
			System.out.println("Stack " + num + " is full"); return;
		}
		buffer[ptr[num]++] = d;
	}

	public int pop(int num) {
		if (ptr[num] % size == 0) {
			System.out.println("Stack " + num + " is empty"); return Integer.MAX_VALUE;
		}
		return buffer[--ptr[num]];
	}

	public int peek(int num) {return buffer[ptr[num] - 1];}

	public boolean isEmpty(int num) {return ptr[num] % size == 0;}

	public void printAll() {
		for (int i : buffer) System.out.print(i + " ");
		System.out.println("");
	}
}

class myStack2 {
	int size = 3;
	int[] buffer = new int[size * 3];
	int[] ptr = {-1, -1. -1};
	int cur = 0;

	public void push(int d, int num) {
		if (cur >= szie * 3 - 1) {System.out.println("Stack is full."); return;}
		Node n = new Node(d);

	}
}


class Node {
	int prev;
	int data;
	public Node(int d) {data = d;}
}
