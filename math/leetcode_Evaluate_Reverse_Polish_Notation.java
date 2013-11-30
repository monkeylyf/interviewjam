/*Evaluate_Reverse_Polish_Notation
leetcode


*/

import java.util.*;


public class leetcode_Evaluate_Reverse_Polish_Notation {
	
	public static void main(String[] args) {
		// Test case
		String[] tokens = new String[] {"4","-2","/","2","-3","-","-"};
		System.out.println(evalRPN(tokens));
	}

    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        int a, b;
        for (String cur : tokens) {
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
