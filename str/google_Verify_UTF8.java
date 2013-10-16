/*Verify_UTF8
google

Write a function to verify if a string is a valid UTF-8.
*/


public class google_Verify_UTF8 {


	/**
	 * Check if the given unsigned char * is a valid utf-8 sequence.
	
	 * Return value :
	 * If the string is valid utf-8, 0 is returned.
	 * Else the position, starting from 1, is returned.
	
	 * Valid utf-8 sequences look like this :
	 * 0xxxxxxx
	 * 110xxxxx 10xxxxxx
	 * 1110xxxx 10xxxxxx 10xxxxxx
	 * 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
	 * 111110xx 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx
	 * 1111110x 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx
	*/
	
	public static void main(String[] args) {
		String str = "我";
		System.out.println(validUTF8(str));
		System.out.println(validUTF8("傻逼"));
		
	}

	public static int validUTF8(String str) {
		if (str == null || str.length() == 0) {
			return 0;	
		}

		char[] arr = str.toCharArray();
		int bytesSequence = 0, i = 0;
	
		if (arr[i] <= 0x7F) { // From U+0000 to U+007F. 00000000 to 01111111.
			bytesSequence = 0;
		} else if (arr[i] >= 0xC0 && arr[i] <= 0xDF) { // From U+0080 to U+07FF.
			bytesSequence = 1;	
		} else if (arr[i] >= 0xE0 && arr[i] <= 0xEF) { // From U+0800 to U+FFFF
			bytesSequence = 2;	
		} else if (arr[i] >= 0xF0 && arr[i] <= 0xF4) { // Cause of RFC 3629
			bytesSequence = 3;	
		} else {
			return i + 1;	
		}
		++i;

		// Rest of the char is in the same range.
		while (i < arr.length && bytesSequence > 0 && arr[i] >= 0x80 && arr[i] <= 0xBF) {
			++i;
			bytesSequence -= 1;
		}

		if (bytesSequence != 0) {
			return i + 1;	
		} else {
			return 0;
		}
	}
}
