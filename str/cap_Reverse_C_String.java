/*Reverse_C_String
careercup

Write code to reverse a C-Style String.C-String means that “abcd” is represented as five characters, including the null character
*/


class cap_Reverse_C_String {
	public static void main(String[] args) {
		reverseString("silenthill2\0");
		reverseStr("silenthill2\0");
	}
	// string object in java in immutable. Convert to chararray.
	public static void reverseString(String str) { 
		char[] arr = str.toCharArray();
		int head = 0;
		int tail = arr.length - 2;
		while (head < tail) {
			char temp = arr[head];
			arr[head] = arr[tail];
			arr[tail] = temp;
			++head;
			--tail;
		}
		for (char i : arr) System.out.println(i);
	}
	// Use int[] to cheat
	public static void reverseStr(String str) {
		int[] arr = new int[str.length()];
		int idx = str.length() - 1;
		for (int i : str.toCharArray()) {arr[idx--] = i;}
		str = str.substring(str.length(), str.length());

		for (int j : arr) {str = str.concat(String.valueOf((char)j));}
		for (char k : str.toCharArray()) {System.out.println(k);}
	}
}
