/*ounting_Boolean_Parenthesizations

You are given a boolean expression consisting of a string of the symbols 'true',
'false', 'and', 'or', and 'xor'. Count the number of ways to parenthesize the
expression such that it will evaluate to true. For example, there is only 1 way
to parenthesize 'true and false xor true' such that it evaluates to true.
*/

class Boolean_Expression_Parenthesization {
    public static void main(String[] args) {
        //parenthesize("true and false xor true");
        parenthesize("true and false xor true or false");
    }
    public static int parenthesize(String A) {
        String[] arr = A.split(" ");
        int n = arr.length / 2 + 1;
        Element[][] s = new Element[n][n];
        // Init.
        for (int i = 0; i < n; ++i) {
            s[i][i] = (arr[2 * i].equals("true")) ? new Element(1, 0) : new Element(0, 1); // Based case: s[i][i].
            for (int j = i + 1; j < n; ++j) {
                s[i][j] = new Element(0, 0);
            }
        }
        // Down-to-top
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = i; k < j; ++k) {
                    /* s(i, k) op s(k, j)
                     * "and"
                     * # of True = (i, k).True * (k, j).True
                     * # of False = (i,j).True * (k, j).False + (i, j).False * (k, j).Ture + (i, j).False * (k, j).False;
                     * "or"
                     * # of True = Total(i, j) * Total(k, j) - # of False
                     * # of False = s(i, j).False * s(j, k).False
                     * "xor"
                     * # of True = s(i, j).False * s(j, k).True + s(i, j).True * s(j, k).False
                     * # of False = s(i, j).True * s(j, k).True + s(i, j).False * s(j, k).False
                     */
                    if (arr[2 * k + 1].equals("and")) {
                        s[i][j].True += s[i][k].True * s[k + 1][j].True;
                        s[i][j].False += s[i][k].True * s[k + 1][j].False + s[i][k].False * s[k + 1][j].True + s[i][k].False * s[k + 1][j].False;
                    } else if (arr[2 * k + 1].equals("or")) {
                        s[i][j].True += s[i][k].True * s[k + 1][j].False + s[i][k].False * s[k + 1][j].True + s[i][k].True * s[k + 1][j].True;
                        s[i][j].False += s[i][k].False * s[k + 1][j].False;
                    } else {  // arr[2 * k + 1].equals("xor")
                        s[i][j].True += s[i][k].True * s[k + 1][j].False + s[i][k].False * s[k + 1][j].True;
                        s[i][j].False += s[i][k].False * s[k + 1][j].False + s[i][k].True * s[k + 1][j].True;
                    }
                }
            }
        }
        printElement(s);
        return s[0][n - 1].True;
    }
    public static void printElement(Element[][] A) {
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[i].length; ++j) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}


class Element {
    public int False;
    public int True;
    Element(int True, int False) {
        this.False = False;
        this.True = True;
    }
    @Override
    public String toString() {
        return this.True + " / " + this.False;
    } 
}
