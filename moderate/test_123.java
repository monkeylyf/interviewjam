/*Write a function to swap a number in place without temporary variables*/

class test_123 {
	public static void main(String[] args) {
		swap(3, 1);
		swapInt(3, 1);
	}

	public static int[] swap(int a, int b) {
		a = a - b;
		b = b + a;
		a = b - a;
		return new int[] {a, b};
	}

	public static int[] swapInt(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		return new int[] {a, b};
	}
}
