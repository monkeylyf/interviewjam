/*Substring_With_Two_Distinct_Chars
google

Given a string, find the longest substring with only two distinct characters.

For exmaple,
Given string "abbaacccaaabba", return "aacccaaa"


You need to ask the interviewee about some edge cases you can think of like
"", which is an empty string input and "a" which contains only one distinct
char.
*/



import java.util.*;


public class Substring_With_Two_Distinct_Chars {

  /**
   * @param args
   */
  public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println(solve("abbaacccaaabba").equals("aacccaaa"));
	System.out.println(solve("").equals(""));
	System.out.println(solve("a").equals(""));
	System.out.println(solve("abbaabbaa").equals("abbaabbaa"));
  }

  public static String solve(String str) {
	String ret = "";
	int head = 0, tail = 0, start = 0;
	HashSet<Character> set = new HashSet<Character>();
	while (tail < str.length()) {
	  if (set.contains(str.charAt(tail))) {
		++tail;
	  } else if (set.size() < 2) {
		set.add(str.charAt(tail));
		head = tail;
		++tail;
	  } else {
		// update ret.
		ret = (tail - start > ret.length()) ? str.substring(start, tail) : ret;
		// Retrospect to longest subarray with one distinct char backwards.
		tail = head;
		// Reset start for substring starting point mark.
		start = head;
		// Clear set.
		set.clear();
	  }
	}
	if (set.size() != 2) { // For edge case like "a"
	  return "";
	} else {
	  return (tail - start > ret.length()) ? str.substring(start, tail) : ret;
	}
  }
}

/* Python Version
class Solution(object):

    def solve(self, s):
        head = tail = start = 0
        used = set()
        ret = ''
        while tail < len(s):
            if s[tail] in used:
                tail += 1
            elif len(used) < 2:
                used.add(s[tail])
                head = tail
                tail += 1
            else:
                ret = s[start : tail] if tail - start > len(ret) else ret

                start = head
                tail = head

                used.clear()

        # Wrap up what is left in used.
        if len(used) < 2:
            # The whole string contains only one char
            return ''
        else:
            return s[start : tail] if tail - start > len(ret) else ret

    def run(self):
        print self.solve('abcbcbcbcbcddd')
        print self.solve('abbbcccbbbcccd')


def main():
    Solution().run()


if __name__ == '__main__':
    main()
*/
