/*Given an integer, print the next smallest and next largest number that have the same
number of 1 bits in their binary representation*/

class test_30 {
	public static void main(String[] args) {
		int input = 121;
		nextLargest(input);
		nextSmallest(input);
	
	}
	public static void nextLargest(int input) {
		String str = Integer.toBinaryString(input);
		char[] arr = str.toCharArray();
		int one = 0;
		int one_count = 0;
		int i = 0;
		for (i = arr.length - 1; i >= 0; --i) {
			if (arr[i] == '1') {one = i; one_count += 1;}
			if (arr[i] == '0' && one > 0) {
				arr[i] = '1';
				arr[one] = '0';
				break;
			}
		}
		for (int j = arr.length - 1; i < j; --j) {
			if (one_count > 1) {
				arr[j] = '1';
				--one_count;
			} else {arr[j] = '0';}
		}
		System.out.println(str);
		System.out.println(new String(arr));
	}
	public static void nextSmallest(int input) {
		String str = Integer.toBinaryString(input);
		char[] arr = str.toCharArray();
		int zero = 0;
		int zero_count = 0;
		int i = 0;
		for (i = arr.length - 1; i >= 0; --i) {
			if (arr[i] == '0') {zero = i; zero_count += 1;}
			if (arr[i] == '1' && zero > 0) {
				arr[i] = '0';
				arr[zero] = '1';
				break;
			}
		}
		for (int j = arr.length - 1; i < j; --j) {
			if (zero_count > 1) {
				arr[j] = '0';
				--zero_count;
			} else{arr[j] = '1';}
		}
		System.out.println(str);
		System.out.println(new String(arr));
	}
}
