/*Implement_Max
careercup

Write a method which finds the maximum of two numbers. You should not use
if-else or any other comparison operator
*/

public class cap_Implement_Max {

	public static void main(String[] args) {
		System.out.println(max(5, 10));
		System.out.println(max(5, -1));
	}

	public static int max(int a, int b) {
        // bit operation. 
		int k = (a - b) >> 31; // k equals 0 or -1
		System.out.println(Integer.toBinaryString(a - b));
		System.out.println(k + " " + Integer.toBinaryString(k));
		return a - (k & 0x1) * (a - b);
	}
}
