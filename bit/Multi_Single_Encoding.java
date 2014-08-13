/**
 * Multi_Single_Encoding.
 *
 * Encoding is defined as follow:
 * 1. Single encoding:
 * One byte to represent a string, this byte must be in range [-128, 0)
 *
 * 2. Multiple encoding:
 * Two bytes to represent a string, the first byte must be in range [0, 127]
 * and the second byte must be in range [-128, 127]
 *
 * It is guaranteed that the byte array is valid for this encoding rule.
 *
 * Question:
 * It the last string multiple encoding or single encoding?
 */

import java.util.Arrays;

public class Multi_Single_Encoding {

  public static void main(String[] args) {
    test();
  }

  private static void test() {
    byte[] str = new byte[10];
  }

  /**
   * return true is b is within range [-128, -1] else false
   */
  private static boolean isNeg(byte b) {
    return b >= -128 && b < 0;
  }

  /**
   * return true is b is within range [0, 127] else false
   */
  private static boolean isPos(byte b) {
    return b >= 0 && b < 128;
  }

  public static boolean isLastMultipleEncoding(byte[] str) {
    int n = str.length;
    if (n == 0 || (n == 1 && isPos(str[0]))) {
      throw new IllegalArgumentException();
    }

    if (n == 1) {
      // Must be single encoding.
      return false;
    }

    if (isNeg(str[n - 2]) && isPos(str[n - 1])) {
      throw new IllegalArgumentException("Invalid encoded byte array.");
    }

    if (isPos(str[n - 2]) && isPos(str[n - 1])) {
      return false;
    }

    int i = 1;
    while (i < n) {
      if (isNeg(str[n - i - 1])) {
        break;
      }
      ++i;
    }

    return i % 2 == 0;
  }
}
