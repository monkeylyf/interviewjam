/*Design an algorithm and write code to remove the duplicate characters in a string
without using any additional buffer NOTE: One or two additional variables are fine
An extra copy of the array is not
FOLLOW UP Write the test cases for this method*/




class test_3 {
	public static void main(String[] args) {
		
		String input = "abcdefgghijk";
		removeDuplicate(input.toCharArray());
		removeDuplicates(input.toCharArray());
	}

	public static void removeDuplicate(char[] str) {
		// If it's null, do nothing.
		if (str == null) return;
		// If it's one char array, do nothing.
		int len = str.length;
		System.out.println("The length of this char is " + len);
		if (len == 1) return;
		
		int pointer = 1; // Points to the last processed char.

		for (int i = 1;i < len; ++i) {
			for (int j = 0; j < i; ++j) {
				if (str[i] == str[j]) {
					System.out.println("Duplicate found " + str[i]);

				}
				System.out.println(str[j]);
			}
			System.out.println("Done with one loop");
		}	
	}

	public static void removeDupilicatesEasy(char[] str) {
		// If it's null, do nothing.
		if (str == null) return;
		// If it's one char array, do nothing.
		int len = str.length;
		System.out.println("The length of this char is " + len);
		if (len == 1) return;

		char[] output;

	
	
	}

	public static void removeDuplicates(char[] str) {
		// This is the example answer.

		// If it's null, do nothing.
		if (str == null) return;
		// If it's one char array, do nothing.
		int len = str.length;
		System.out.println("The length of this char is " + len);
		if (len == 1) return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j]) break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		System.out.println(str);
	}
}
