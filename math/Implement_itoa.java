/*itoa
geekforgeeks

Implement itoa in java
*/

public class Implement_itoa {
	
	public static void main(String[] args) {
		// Test case for reverse.
		char[] arr = "String".toCharArray();
		reverse(arr);
		print(arr);
		// Test case for itoa.		
		System.out.println(itoa(1567, 10));
		System.out.println(itoa(-1567, 10));
		System.out.println(itoa(1567, 2)); // 11000011111
		System.out.println(itoa(1567, 8)); // 3037
		System.out.println(itoa(1567, 16)); // 61f
	}	

	public static String itoa(int num, int base) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		boolean isNegative = false;

		if (num == 0) {
			return "0"; // Edge case.
		}

		if (num < 0 && base == 10) {
			isNegative = true;
			num = -num;
		}

		int remain;
		while (num != 0) {
			remain = num % base;
			int ascii = (remain > 9) ? (remain - 10) + 'a' : remain + '0';
			num = num / base;
			sb.append((char) ascii);
		}
		char[] ret = sb.toString().toCharArray();
		reverse(ret);
		
		return (isNegative) ? "-" + new String(ret) : new String(ret);
	}

	public static void reverse(char[] arr) {
		int head = 0, tail = arr.length - 1;
		char swap;
		while (head < tail) {
			swap = arr[head];
			arr[head] = arr[tail];
			arr[tail] = swap;
			++head;
			--tail;
		}
	}

	// Helper function.
	public static void print(char[] arr) {
		for (char str : arr) System.out.print(str + " ");	
		System.out.println();
	}
}
