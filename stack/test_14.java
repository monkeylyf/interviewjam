/*Describe how you could use a single array to implement three stacks*/


class test_14 {
	public static void main(String[] args) {
		stackOne s1 = new stackOne();
		s1.push(0, 1);
		s1.push(1, 2);
		s1.push(2, 3);
	
		s1.printAll();
		System.out.println("----------------");

		s1.push(2, 4);
		System.out.println(s1.pop(0));
		System.out.println("----------------");
		s1.printAll();
		System.out.println("Peeking: " + s1.peek(2));
	}
}

// Divide the array into three
class stackOne {
	int stackSize = 3;
	Object[] buffer = new Object[stackSize * 3];
	int[] pter = {0, 0, 0};

	public void push(int stackNum, Object data) {
		int index = stackNum * stackSize + pter[stackNum];
		buffer[index] = data;
		++pter[stackNum];
	}

	public Object pop(int stackNum) {
		int index = stackNum * stackSize + pter[stackNum] - 1;
		Object data = buffer[index];
		buffer[index] = null; // Reset.
		--pter[stackNum];
		return data;
	}

	public Object peek(int stackNum) {
		return buffer[stackNum * stackSize + pter[stackNum] - 1];
	}

	public void printAll() {
		for (int i = 0; i < stackSize * 3; ++i) {
			System.out.println(buffer[i]);
		}
	}
}


class StackTwo {
	int stackSize = 3;
	int usedIndex = 0;
	stackNode[] buffer = new stackNode[stackSize * 3];
	int[] pter = {-1, -1, -1};

	public void push(int stackNum, Object data) {
		int lastIndex = pter[stackNum];
		pter[stackNum] = usedIndex;
		buffer[usedIndex] = new stackNode(lastIndex, data);
		++usedIndex;
	}

	public Object pop(int stackNum) {
		int lastIndex = pt[stackNum];
		Object data = buffer[lastIndex].data;	
		pt[stackNum] = buffer[lastIndex].previous;
		buffer[lastIndex] = null;	

		return data;
	}

	public void peek(int stackNum) {
		return buffer[pt[stackNum].data];
	}

	public boolean isEmpty(int stackNum) {
		return buffer[pt[stackNum].previous == -1];
	}

}

class stackNode {
	int previous;
	Object data;

	public stacNode(int p, Object d) {
		previous = p;
		data = d;
	}
}
