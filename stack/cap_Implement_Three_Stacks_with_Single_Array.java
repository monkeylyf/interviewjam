/*Implement_Three_Stacks_with_Single_Array
careercup

Describe how you could use a single array to implement three stacks
*/


class cap_Implement_Three_Stacks_with_Single_Array {
	public static void main(String[] args) {
		myStack s = new myStack(3);
		s.printAll();
		s.push(55, 0);s.push(1,1);s.push(4,2);
		s.push(54, 0);s.push(2,1);s.push(5,2);
		s.push(53, 0);s.push(3,1);s.push(6,2);
		s.printAll();
		System.out.println(s.peek(0));
		System.out.println(s.pop(0));
		System.out.println(s.peek(1));
		System.out.println(s.pop(1));
		System.out.println(s.peek(2));
		System.out.println(s.pop(2));
		s.printAll();
	}
}

// Divide the array into three
class myStack {
	private int size;
	private int[] buffer;
	private int[] ptr;

	public myStack(int size) {
		this.size = size;
		this.buffer = new int[size * 3];
		this.ptr = new int[] {-1, size - 1, size *2 - 1};
	}

	public void push(int d, int num) {
		if (this.ptr[num] - num * this.size == this.size - 1) {
			System.out.println("Stack " + num + " is full");
		} else {
			this.buffer[++this.ptr[num]] = d;
			System.out.println("ptr " + this.ptr[num]);
		}
	}

	public int pop(int num) {
		if (this.ptr[num] - num * this.size == -1) {
			System.out.println("Stack " + num + " is empty");
			return Integer.MAX_VALUE;
		} else {
			// Unnecessary to reset. Only for debug.
			int ret= this.buffer[this.ptr[num]];
			this.buffer[this.ptr[num]--] = 0;
			return ret;
		}
	}

	public int peek(int num) {
		if (this.ptr[num] - num * this.size == -1) {
			System.out.println("Stack " + num + " is empty");
			return Integer.MAX_VALUE;
		} else {
			return buffer[this.ptr[num]];
		}
	}	

	public boolean isEmpty(int num) {
		return this.ptr[num] - num * this.size == -1;
	}

	public void printAll() {
		for (int i : this.buffer) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
