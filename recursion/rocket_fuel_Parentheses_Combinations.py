"""rocket_fuel_Parentheses_Combinations
rocket fuel


Given numbers of (), [] and {}, print all valid combinations on the fly.
"""


def parentheseCombo(n1, n2, n3):
    """Functional programming style.

    During recursion, no variables are modified inplace. Makes the code clean and neat.
    The Java code below is implemented in the same idea but the stack operation push/pop
    is messy.
    """
    def dfs(acc, stk, n1, n2, n3, c1, c2, c3, container):
        if not any((n1, n2, n3, c1, c2, c3)):
            container.append(''.join(acc))
        else:
            if n1 > 0:
                dfs(acc[:] + ['('], stk[:] + ['('], n1 - 1, n2, n3, c1, c2, c3, container)
            if n2 > 0:
                dfs(acc[:] + ['['], stk[:] + ['['], n1, n2 - 1, n3, c1, c2, c3, container)
            if n3 > 0:
                dfs(acc[:] + ['{'], stk[:] + ['{'], n1, n2, n3 - 1, c1, c2, c3, container)

            if stk and stk[-1] == '(':
                dfs(acc[:] + [')'], stk[:-1], n1, n2, n3, c1 - 1, c2, c3, container)
            if stk and stk[-1] == '[':
                dfs(acc[:] + [']'], stk[:-1], n1, n2, n3, c1, c2 - 1, c3, container)
            if stk and stk[-1] == '{':
                dfs(acc[:] + ['}'], stk[:-1], n1, n2, n3, c1, c2, c3 - 1, container)

    container = []
    dfs([], [], n1, n2, n3, n1, n2, n3, container)
    return container


def main():
    for item in parentheseCombo(1, 1, 1):
        print item
    for item in parentheseCombo(2, 1, 1):
        print item


if __name__ == '__main__':
    main()

"""
import java.util.ArrayList;
import java.util.Stack;


public class rocket_fuel_Parentheses_Conbinations {

    public static void main(String[] args) {
        rocket_fuel_Parentheses_Conbinations instance = new rocket_fuel_Parentheses_Conbinations();
        instance.solve();
    }
    
    public void solve() {
        // Test case.
        for (String item : parentheseCombo(1, 1, 1)) {
            System.out.println(item);
        }
    }

    public ArrayList<String> parentheseCombo(int n1, int n2, int n3) {
        Stack<String> acc = new Stack<String>();
        ArrayList<String> container = new ArrayList<String>();
        parentheseComboUtil(n1, n2, n3, n1, n2, n3, acc, new Stack<String>(), container);
        return container;
    }
    
    private void parentheseComboUtil(int left1, int right1, int left2, int right2, int left3, int right3, Stack<String> acc, Stack<String> stk, ArrayList<String> container) {
        if (left1 == 0 && right1 == 0 && left2 == 0 && right2 == 0 && left3 == 0 && right3 == 0) {
            StringBuilder sb = new StringBuilder();
            for (String item : acc) {
                sb.append(item);
            }
            container.add(sb.toString());
        } else {
            if (left1 > 0) {
                acc.push("(");
                stk.push("(");
                parentheseComboUtil(left1 - 1, right1, left2, right2, left3, right3, acc, stk, container);
                acc.pop();
                stk.pop();
            }
            if (left2 > 0) {
                acc.push("[");
                stk.push("[");
                parentheseComboUtil(left1, right1, left2 - 1, right2, left3, right3, acc, stk, container);
                acc.pop();
                stk.pop();
            }
            if (left3 > 0) {
                acc.push("{");
                stk.push("{");
                parentheseComboUtil(left1, right1, left2, right2, left3 - 1, right3, acc, stk, container);
                acc.pop();
                stk.pop();
            }
            //
            if (stk.size() > 0 && stk.peek().equals("(")) {
                acc.push(")");
                stk.pop();
                parentheseComboUtil(left1, right1 - 1, left2, right2, left3, right3, acc, stk, container);
                acc.pop();
                stk.push("(");
            }
            if (stk.size() > 0 && stk.peek().equals("[")) {
                acc.push("]");
                stk.pop();
                parentheseComboUtil(left1, right1, left2, right2 - 1, left3, right3, acc, stk, container);
                acc.pop();
                stk.push("[");
            }
            if (stk.size() > 0 && stk.peek().equals("{")) {
                acc.push("}");
                stk.pop();
                parentheseComboUtil(left1, right1, left2, right2, left3, right3 - 1, acc, stk, container);
                acc.pop();
                stk.push("{");
            }
        }
    }
}
"""
