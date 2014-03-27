/*Minimum_Window_Substring

  Given a string S and a string T, find the minimum window in S which will
  contain all the characters in T in complexity O(n).
  For example,
  S = "ADOBECODEBANC"
  T = "ABC"
  Minimum window is "BANC".
Note:
If there is no such window in S that covers all characters in T, return the
emtpy string "".
If there are multiple such windows, you are guaranteed that there will always
be only one unique minimum window in S.
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


class leetcode_Minimum_Window_Substring {

  public static void main(String[] args) {
	System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }

  public static String minWindow(String S, String T) {
	// A window is asked for so gotta create a window to scan the string.
	// The idea behind this is scan the string first to mark the existing
	// char assuming all ASCII. Using two pointers tail and head to create
	// a window.
	String ret = "";
	if (T.length() > S.length() || T.length() == 0) {
	  return ret;
	}
	// Assume all chars are ascii code.
	int[] count = new int[256];
	int[] freq = new int[256];
	int matched = 0;
	int minWin = S.length() + 1; // Bigger than max possible as its init value.

	for (int i = 0; i < T.length(); ++i) {
	  // Index/count pair for ACSII with given string.
	  ++freq[(int) T.charAt(i)];
	}

	int head = 0, tail = 0;

	while (tail <= S.length() && head < S.length()) {
	  int ascii;
	  if (matched == T.length()) { 
		// You have found a window.
		// Update if cur window is smaller than previous one.
		ret = (tail - head < minWin) ? S.substring(head , tail) : ret;
		minWin = Math.min(tail - head, minWin);
		// Now need to increase head.
		ascii = (int)S.charAt(head);
		--count[ascii];
		if (count[ascii] < freq[ascii]) {
		  --matched;
		}
		++head;

		while (head < S.length() && freq[(int) S.charAt(head)] == 0) {
		  // Look for the next char in S that appears in T as well.
		  // Pointer head will move forward (moving the left size of window to right.)
		  ++head;
		}

	  } else if (tail < S.length()){
		ascii = (int) S.charAt(tail);
		++count[ascii];
		if (count[ascii] <= freq[ascii]) {
		  // The char appears in T and the char has not been matched more than necessary.
		  ++matched;
		}
		++tail;
	  } else {
		// tail == S.length() && matched < T.length()
		// tail has scan the whole string.
		break;
	  }
	}   
	return ret; 
  }
}


/* Python Version
class Solution:
    # @return a string
    def minWindow(self, S, T):
        ret = ''
        if len(S) < len(T) or len(T) == 0:
            return ret
        
        localMin = len(S) + 1
        
        # Count char freq in T.
        charCount = [ 0 for _ in xrange(256) ]
        for c in T:
            ascii = ord(c)
            charCount[ascii] += 1
        
        # Two pointers
        head = tail = 0
        matched = 0
        # Char count for current window.
        count = [0 for _ in xrange(256) ]
        
        while head < len(S) and tail <= len(S):
            if matched == len(T):
                # Find a window contains all chars in T.
                ret = S[head : tail] if tail - head < localMin else ret
                localMin = min(localMin, tail - head)
                
                # head move one step forward.
                ascii = ord(S[head])
                
                count[ascii] -= 1
                
                if count[ascii] < charCount[ascii]:
                    # S[head] is marked as nessecary char in current window.
                    matched -= 1
                    
                head += 1
                
                # THen find the next char appear in T.
                # Since we want min window, next char will be the left boundary.
                while head < len(S) and charCount[ord(S[head])] == 0:
                    head += 1
                
            elif tail < len(S):
                ascii = ord(S[tail])
                count[ascii] += 1
                if count[ascii] <= charCount[ascii]:
                    matched += 1
                tail += 1
            else:
                break
        return ret
*/
