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


class Amazon_Evaluating_Math_Expression {
        String exp = "3+4*3/(1-5)+2";
        System.out.println(calculate(exp) == 2);
    }
    
    public static double calculate(String exp) {
        return EvalRPN(toRPN(exp));
    }

    public static String toRPN(String exp) {
        LinkedList<Character> q = new LinkedList<Character>();
        Stack<Character> s = new Stack<Character>();
        for (char cur : exp.toCharArray()) {
            if (cur >= '0' && cur <= '9') {
                q.addLast(cur); // number, added to ll.
            } else {
                // '(', ')', '+', '-', '*', '/'.
                if (cur == '(') {
                    s.push(cur); 
                } else if (cur == ')') {
                    while (s.peek() != '(') {
                        q.addLast(s.pop()); // pop out all non-'(' to ll (reversely because of it's stack.)
                    }
                    s.pop(); // pop '('
                } else if (cur == '+' || cur == '-') {
                    while (!s.isEmpty() && (s.peek() == '*' || s.peek() == '/')) {
                        q.addLast(s.pop());
                    }
                    s.push(cur);
                } else { // '*', '/'
                    s.push(cur);
                }
            }
        }
        while (!s.isEmpty()) {
            q.addLast(s.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.pollFirst());
        }
        return sb.toString();
    }
    
    public static double EvalRPN(String str) {
        Stack<Double> s = new Stack<Double>();
        double a = 0, b = 0;
        for (char cur : str.toCharArray()) {
            if (cur >= '0' && cur <= '9') {
                s.push((double)(cur - '0'));
            } else {
                a = s.pop();
                b = s.pop();
                switch(cur) {
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
