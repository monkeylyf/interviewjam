/*Add
careercup

Write a function that adds two numbers You should not use + or any arithmetic
operators
*/

class cap_Add {
	public static void main(String[] args) {
		System.out.println(add(123, 789));
	}
	public static int add(int a, int b) {
		// The tricky part to how to approve that b will be 0 eventually?
		if (b == 0) {
            return a;
        }
		return add(a ^ b, (a & b) << 1);
	}
}
