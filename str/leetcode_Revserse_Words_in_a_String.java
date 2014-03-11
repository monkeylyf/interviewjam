/**leetcode_Revserse_Words_in_a_String.
 * Given an input string, reverse the string word by word.

 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */



public class leetcode_Revserse_Words_in_a_String {
  
  public static void main(String[] args) {	
	String s = "the sky is blue";
	System.out.println(reverseWords(s));
	System.out.println(reverseWords(" 1"));
	System.out.println(reverseWords("   a   b "));
  }  

  public static String reverseWords(String s) {
	// Split by whitespaces.
	String[] segs = s.trim().split("\\s+");

	// Reverse string array.
	int head = 0;
	int tail = segs.length - 1;
	while (head < tail) {
	  String tmp = segs[head];
	  segs[head] = segs[tail];
	  segs[tail] = tmp;
	  ++head;
	  --tail;
	}
	// Reconstruct String with one whitespace as delimeter.
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < segs.length - 1; ++i) {
	  sb.append(segs[i]);
	  sb.append(" ");
	}
	sb.append(segs[segs.length - 1]);
	return sb.toString();
  }
}
