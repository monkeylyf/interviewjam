/*Evaluating_Math_Expression
Amazon

Given a math expression in form of string, return it's 
mathematical result.

For example:
Input:
"8 * (4 - 2)"
Output:
16
*/


import java.util.*;


public class Amazon_Evaluating_Math_Expression {
	
	public static void main(String[] args) {
		// Test case.
        String exp = "3+4*3/(1-5)+2";
        System.out.println(calculate(exp) == 2);
    }
   
	/* 1. Convert the human-readable expression to RPN
	 * 2. Caculate RPN
	 */
    public static double calculate(String exp) {
        return EvalRPN(toRPN(exp));
    }

	// Reverse Polish Notation
	// http://en.wikipedia.org/wiki/Reverse_Polish_notation.
    public static LinkedList<Character> toRPN(String exp) {
        LinkedList<Character> q = new LinkedList<Character>();
        Stack<Character> s = new Stack<Character>();
        for (char cur : exp.toCharArray()) {
            if (cur >= '0' && cur <= '9') {
				// Number from '0' to '9'.
                q.addLast(cur); // number, added to ll.
            } else if (cur == '(') {
                // '('.
                s.push(cur); 
            } else if (cur == ')') {
				// ')'.
                while (s.peek() != '(') {
                    q.addLast(s.pop()); // pop out all non-'(' to ll (reversely because of it's stack.)
                }
                s.pop(); // pop '('. So '(' & 'C' won't appear in RPN.
            } else if (cur == '+' || cur == '-') {
				// '+' && '-'
                while (!s.isEmpty() && (s.peek() == '*' || s.peek() == '/')) {
                    q.addLast(s.pop());
                }
                s.push(cur);
            } else if (cur == '*' || cur == '/') {
				// '*', '/'
                s.push(cur);
            } else {
				System.out.println(String.format("Invalid char: %s", cur));
				continue;
			}
        }
        while (!s.isEmpty()) {
            q.addLast(s.pop());
        }
		System.out.println(q);
        return q;
    }
    
    public static double EvalRPN(LinkedList<Character> rpn) {
        Stack<Double> s = new Stack<Double>();
        double a = 0, b = 0;
        for (char cur : rpn) {
            if (cur >= '0' && cur <= '9') {
                s.push((double)(cur - '0'));
            } else {
                a = s.pop();
                b = s.pop();
                switch (cur) {
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
