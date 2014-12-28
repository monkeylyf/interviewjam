/**
 * leetcode_Excel_Sheet_Column_Number.
 *
 * Related to question Excel Sheet Column Title
 *
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 */


public class leetcode_Excel_Sheet_Column_Number {

  public static void main(String[] args) {
    leetcode_Excel_Sheet_Column_Number solution = new leetcode_Excel_Sheet_Column_Number();

    solution.test();
  }

  public void test() {
    System.out.println(titleToNumber("AA"));
  }

  public int titleToNumber(String s) {
    int ret = 0;
    int base = 1;

    for (int i = s.length() - 1; i >= 0; --i) {
      int n = ((int) s.charAt(i) - 64);
      ret += base * n;

      base *= 26;
    }

    return ret;
  }
}
