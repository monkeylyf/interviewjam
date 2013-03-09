/*ounting_Boolean_Parenthesizations

You are given a boolean expression consisting of a string of the symbols 'true',
'false', 'and', 'or', and 'xor'. Count the number of ways to parenthesize the
expression such that it will evaluate to true. For example, there is only 1 way
to parenthesize 'true and false xor true' such that it evaluates to true.
*/


class Counting_Boolean_Parenthesizations{
mport java.util.*;


public class Boolean_Expression_Parenthesization {
    public static void main(String[] args) {
        parenthesize("true and false xor true");
    }
    public static int parenthesize(String A) {
        String[] arr = A.split(" ");
        for (String i : arr) System.out.print(i + " ");
        System.out.println();
        // 2 x N matrix. status[0][i] means number of true expression. status[1][i] means false 
        int[][] status = new int[2][arr.length / 2 + 1];
        // Take care of the first boolean in arr.
        if (arr[0].equals("true")) {
            status[0][0] = 1;
        } else {
            status[1][0] = 1;
        }
        // Take care the expression of first three string.
        if (eval(arr[0], arr[1], arr[2])) {
            status[0][1] = 1;
        } else {
            status[1][1] = 1;
        }
        for (int i = 4; i < arr.length; i += 2) {
            // (( 0 to i - 2) arr[i - 1] arr[i])
            if (eval("true", arr[i - 1], arr[i])) {
                status[0][i / 2] += status[0][(i - 2) / 2];
            } else {
                status[1][i / 2] += status[0][(i - 2) / 2];
            }
            if (eval("false", arr[i - 1], arr[i])) {
                status[0][i / 2] += status[1][(i - 2) / 2];
            } else {
                status[1][i / 2] += status[1][(i - 2) / 2];
            }
            // (0 to i - 4) arr[i - 3] (arr[i - 2] arr[i - 1] arr[i])
            String expression = (eval(arr[i - 2], arr[i - 1], arr[i])) ? "true" : "false";
            if (eval("true", arr[i - 3], expression)) {
                status[0][i / 2] += status[0][(i - 3) / 2];
            } else {
                status[1][i / 2] += status[0][(i - 3) / 2];
            }
            if (eval("false", arr[i - 3], expression)) {
                status[0][i / 2] += status[1][(i - 3) / 2];
            } else {
                status[1][i / 2] += status[1][(i - 3) / 2];
            }
        }
        print(status);
        return status[0][arr.length / 2 - 1];
    }
    public static void print(int[][] A) {
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[i].length; ++j) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean eval(String A, String operator, String B) {
        boolean a = (A.equals("true")) ? true : false;
        boolean b = (B.equals("true")) ? true : false;
        if (operator.equals("and")) {
            return a && b;
        } else if (operator.equals("or")) {
            return a || b;
        } else {
            return a ^ b;
        }
    }
}
