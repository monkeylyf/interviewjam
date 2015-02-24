/**
 * google_String_Order.
 * google
 *
 * Given string o and a stirng s.
 * String o contains all distinct characters, representing an order.
 * For example,
 * "adb", 'a' must be one the left side of both 'd' and 'b' and 'd' must
 * be on the left side of 'b'.
 *
 * String s contains some random characters. the question is: does string s
 * follow the order of s.
 *
 * For example:
 * "ab" -> true
 * "ba" -> false
 * "axd" -> true
 *
 */

import java.util.HashMap;
import java.util.Map;


public class google_String_Order {

  public static void main(String[] args) {
    google_String_Order solution = new google_String_Order();
    solution.test();
  }

  public void test() {
    System.out.println(stringOrder("adb", "ab"));
    System.out.println(stringOrder("adb", "ba"));
    System.out.println(stringOrder("adb", "axd"));
  }

  public boolean stringOrder(String o, String str) {
    Map<Character, Integer> order = new HashMap<>();
    for (int i = 0; i < o.length(); ++i) {
      order.put(o.charAt(i), i);
    }

    int prevIdx = -1;
    int i = 0;
    for (; i < o.length(); ++i) {
      // Find the first char that appears in o.
      char cur = o.charAt(i);
      if (!order.containsKey(cur)) {
        continue;
      }

      prevIdx = order.get(cur);
      break;
    }

    if (prevIdx == -1) {
      // None of the char in str appears in o. No overlapping.
      return true;
    }

    for (; i < str.length(); ++i) {
      char cur = str.charAt(i);
      if (!order.containsKey(cur)) {
        continue;
      }

      int curIdx = order.get(cur);
      if (prevIdx > curIdx) {
        return false;
      }

      prevIdx = curIdx;
    }

    return true;
  }
}
