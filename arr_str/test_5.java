/*Write a method to replace all spaces in a string with ‘%20’*/
import java.util.*;

class test_5 {
	public static void main(String[] args) {
		String str = "what the fuck ";
		replaceSpace(str);
		String test1 = "whatthefuck";
		replaceSpace(test1);
		char[] cArray = str.toCharArray();
		ReplaceFun(cArray);
	}

	public static String replaceSpace(String a) {
		char[] input = a.toCharArray();
		int i = 0, zero_count = 0, new_length;
		while(i < input.length) {
			if (input[i] == ' ') ++zero_count;
			++i;
		}
		System.out.println(zero_count);
		if (zero_count == 0) {
			System.out.println("Nothing to replace with.");
			return a;
		}

		// Creating new array.
		new_length = input.length + 2 * zero_count;
		// input[new_length] = '\0';
		System.out.println(Arrays.toString(input));
		return a;
	}

	public static void ReplaceFun(char[] str) {
		int spaceCount = 0, length = str.length, newLength, i;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}	
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength -1;
			}
		}
		System.out.println(Arrays.toString(str));
	}
}
