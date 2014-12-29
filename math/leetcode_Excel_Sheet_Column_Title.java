/**
 * leetcode_Excel_Sheet_Column_Title.
 */

import java.util.HashMap;
import java.util.Map;


public class leetcode_Excel_Sheet_Column_Title {

  public static void main(String[] args) {
    leetcode_Excel_Sheet_Column_Title solution = new leetcode_Excel_Sheet_Column_Title();

    solution.test();
  }

  public void test() {
    for (int i = 1; i <= 37; ++i) {
      System.out.println(i + " " + convertToTitle(i));
    }
  }

  public String convertToTitle(int n) {
    final int base = 26;
    StringBuilder sb = new StringBuilder();
    n -= 1; // zero-based.

    // Craete mapping.
    Map<Integer, Character> mapping = new HashMap<Integer, Character>();
    for (int i = 0; i < 26; ++i) {
      mapping.put(i, (char) (i + 65));
    }

    do {
      int digit = n % base;
      sb.append(mapping.get(digit));
      n = n / base - 1;
    } while (n >= 0);

    return sb.reverse().toString();
  }
}
