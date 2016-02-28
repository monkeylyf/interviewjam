/**
 * Evaluate_Reverse_Polish_Notation.
 *
 * leetcode
 *
 *
 */

import java.util.Stack;


public class leetcode_Evaluate_Reverse_Polish_Notation {

  public static void main(String[] args) {
	// Test case
	String[] tokens = new String[] {"4","-2","/","2","-3","-","-"};
	System.out.println(evalRPN(tokens));
	System.out.println(evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
  }

  public static int evalRPN(String[] tokens) {
	Stack<Integer> s = new Stack<Integer>();
	int a, b;
	for (String cur : tokens) {
	  System.out.println(s);
	  try {
		s.push(Integer.parseInt(cur)); // If is an integer.
	  } catch (NumberFormatException e) {
		a = s.pop();
		b = s.pop();
		char op = cur.charAt(0);
		switch (op) { // Current OJ does not support String switch.
		  case '+':
			s.push(b + a); break;
		  case '-':
			s.push(b - a); break;
		  case '*':
			s.push(b * a); break;
		  case '/':
			s.push(b / a); break;
		}
	  }
	}
	return s.pop();
  }
}

/* Python Version

def evalRPN(self, tokens):
    s = []

    for token in tokens:
        if token in ('-', '+', '*', '/'):
            b = s.pop()
            a = s.pop()
            if token == '-':
                s.append(a - b)
            elif token == '+':
                s.append(a + b)
            elif token == '*':
                s.append(a * b)
            else:
				# This is fucked up in Python 2.x
				# -7 / 6 gives -2. Should be -1.
				# Converting to float to fix it.
                s.append(int(float(a) / float(b)))
        else:
            s.append(int(token))

    return int(s[0])
*/
