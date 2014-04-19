/*Valid_Number

Validate if a given string is numeric.
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should
gather all requirements up front before implementing one.
*/

import java.util.Collections;
import java.util.HashSet;

public class leetcode_Valid_Number {

  /*
   * Yuk...
   *
   * 1. You are welcome to use regex to cheat.
   * 2. Using state machine. Draw DFA diagram first.
   */

  public static void  main(String[] args) {
	// Test case 1.
	System.out.println(isNumber("0") == true);
	// Test case 2.
	System.out.println(isNumber(" 0.1 ") == true);
	// Test case 3.
	System.out.println(isNumber("1 a") == false);
	// Test case 4.
	System.out.println(isNumber("2e10") == true);
	// Test case 5.
	System.out.println(isNumber(" ") == false);
	// Test case 6.
	System.out.println(isNumber(null) == false);
	// Test case 7.
	System.out.println(isNumber("459277e38+") == false);
	// Test case 8.
	System.out.println(isNumber(" 005047e+6") == true);

  }

  public static boolean isNumber(String s) {
	if (s == null) {
	  return false;
	}
	s = s.trim(); // Eliminating tailing/trailing space.
	if (s.length() == 0) {
	  return false; // Double check after trim.
	}

	char cur;
	boolean eExist = false;
	boolean	dotExist = false;
	boolean	firstPart = false;
	boolean	secondPart = false;

	// Check the tailing sign.
	int i = (s.charAt(i) == '+' || s.charAt(i) == '-') ? 1 : 0;

	// While loop to iterate each char.
	while (i < s.length()) {
	  cur = s.charAt(i);
	  if (cur == '+' || cur == '-') { // more sign must be right after 'e'/'E'
		// '+'/'-' can exist only after 'e'/'E'
		if (!eExist || (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
		  return false;
		}
	  } else if (cur == '.') {
		if (eExist || dotExist) {
		  return false; // Duplicate dots.
		} else {
		  dotExist = true; // Set dot flag.
		}
	  } else if (cur == 'e' || cur == 'E') {
		if (eExist || !firstPart) {
		  return false; // Duplicate e detected or trailing e without number part.
		} else {
		  eExist = true;
		}
	  } else if (Character.isDigit(cur)) {
		if (!eExist) {
		  firstPart = true; // Digit detected. flag first or second part.
		} else {
		  secondPart = true;	
		}
	  } else { // Whitespace or other char, illegal.
		return false;	
	  }
	  ++i;	
	}
	// Must have firstPart, and if not e, return true, if e, must have secondPart.
	return (firstPart) && (!eExist || secondPart);
  }
}

/* Python Version

def isNumber(self, s):
    s = s.strip();
    if not s:
        return False
    
    sign = ('+', '-')
    e = ('e', 'E')
    i = 1 if s[0] in sign else 0
    
    has_dot = has_e = first_part = second_part = False
    
    while i < len(s):
        c = s[i]
        if c in sign:
            if not (has_e and s[i - 1] in e):
                return False
        elif c == '.':
            if has_e or has_dot:
                return False
            else:
                has_dot = True
        elif c in e:
            if has_e or not first_part:
                return False
            else:
                has_e = True
        elif c.isdigit():
            if not has_e:
                first_part = True
            else:
                second_part = True
        else:
            return False
        
        i += 1
    
    return first_part and (not has_e or second_part)
*/
