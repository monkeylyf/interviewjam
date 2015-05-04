/**
 * Find_Centrally_Symmetric_Numbers.
 *
 * Find all centrally symmetric numbers with N digits or less than N digits.
 * For example, 69 is a centrally symmetric number.
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Find_Centrally_Symmetric_Numbers {

  private final List<String> oneDigit = Arrays.asList("0", "1", "8");
  private final List<String> twoDigits = Arrays.asList("00", "11", "88", "69", "96");

  public static void main(String[] args) {
    Find_Centrally_Symmetric_Numbers solution = new Find_Centrally_Symmetric_Numbers();
    solution.unittest();
  }

  private void unittest() {
    List<String> ret = solve(5);
    System.out.println(ret);
    for (int i = 0; i <= 10000; ++i) {
      String num = Integer.toString(i);
      if (isCentrallySymmetric(num)) {
        System.out.println(num);
      }
    }
  }

  private boolean isCentrallySymmetric(String num) {
    int head = 0;
    int tail = num.length() - 1;

    while (head <= tail) {
      if (head == tail) {
        char c = num.charAt(head);
        if (!isSingleDigitSymmetric(c)) {
          return false;
        }
      } else {
        char prefix = num.charAt(head);
        char suffix = num.charAt(tail);
        if (!isDoubleDigitSymmetric(prefix, suffix)) {
          return false;
        }
      }

      head += 1;
      tail -= 1;
    }

    return true;
  }

  private boolean isSingleDigitSymmetric(char c) {
    return c == '0' || c == '1' || c == '8';
  }

  private boolean isDoubleDigitSymmetric(char a, char b) {
    if (a == b) {
      return isSingleDigitSymmetric(a);
    } else {
      return (a == '6' && b == '9') || (a == '9' && b == '6');
    }
  }

  /**
   * Single digit: 0 1 8
   * Double digits: 69
   *
   * dp[x] = dp[x - 2] + '00'|'11'|'88'|'69' if x % 2 == 0
   *         dp[x - 1] + '0'|'1'|'8'         if x % 2 == 1
   *
   */
  public List<String> solve(int n) {
    List<String> ret = new ArrayList<String>();

    if (n == 0) {
      return ret;
    }

    ret.addAll(this.oneDigit);
    if (n == 1) {
      return ret;
    }

    ret.addAll(this.twoDigits);
    if (n == 2) {
      return ret;
    }

    List<String> state = twoDigits;

    for (int i = 3; i <= n; ++i) {
      if (i % 2 == 0) {
        // i is even.
        List<String> symmetricNumbers = addTwoDigits(state);

        ret.addAll(symmetricNumbers);
        //System.out.println(i);
        //System.out.println(symmetricNumbers);
        state = symmetricNumbers;
      } else {
        // i is odd.
        List<String> symmetricNumbers = addOneDigit(state);

        //System.out.println(i);
        //System.out.println(symmetricNumbers);
        ret.addAll(symmetricNumbers);
      }
    }

    return ret;
  }

  private List<String> addOneDigit(List<String> state) {
    List<String> ret = new ArrayList<String>();
    int length = state.get(0).length();
    for (String one : this.oneDigit) {
      for (String evenLengthString : state) {
        StringBuilder sb = new StringBuilder();
        sb.append(evenLengthString.substring(0, length / 2));
        sb.append(one);
        sb.append(evenLengthString.substring(length / 2, length));

        // if sb.toString() is all '0', ask about this edge case
        // does '000...00' a valid number?
        ret.add(sb.toString());
      }
    }

    return ret;
  }

  private List<String> addTwoDigits(List<String> state) {
    List<String> ret = new ArrayList<String>();

    for (String two : this.twoDigits) {
      String prefix = two.substring(0, 1);
      String suffix = two.substring(1, 2);
      for (String evenLengthString : state) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(evenLengthString);
        sb.append(suffix);

        // if sb.toString() is all '0', ask about this edge case
        // does '000...00' a valid number?
        ret.add(sb.toString());
      }
    }
    return ret;
  }

}
