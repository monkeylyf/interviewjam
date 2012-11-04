/*Write a method which finds the maximum of two numbers. You should not use
if-else or any other comparison operator*/

class test_126 {
	public static void main(String[] args) {
		System.out.println(max(5, 10));
		System.out.println(max(5, -1));
	}

	public static int max(int a, int b) {
		int k = (a - b) >> 31;
		return a - (k & 0x1) * (a - b);
	}
}
