/**
 * Big_Factorial.
 *
 * Implement n!.
 * n might be really large.
 *
 */

public class Big_Factorial {

  final int length = 2000;
  final int bucketRange = 100;

  public static void main(String[] args) {
    new Big_Factorial().test();
  }

  public void test() {
    System.out.println(factorial(10).equals("362880"));
    System.out.println(factorial(5).equals("120"));
    System.out.println(factorial(0).equals("1"));
  }

  /**
   * Use int array as buckets to store k digits of the results to avoid int overflow.
   */
  public String factorial(int n) {
    int[] res = new int[length];
    res[0] = 1;

    // Edge case.
    if (n == 0) {
      return "1";
    }

    for (int i = 1; i <= n; ++i) {
      int carry = 0;
      for (int j = 0; j < length; ++j) {
        int product = res[j] * i + carry;

        res[j] = product % bucketRange;
        carry = product / bucketRange;
      }
    }

    return arrToString(res);
  }

  /**
   * Convert an int array to String in reverse order.
   */
  private String arrToString(int[] res) {
    StringBuilder sb = new StringBuilder();
    boolean flag = false;
    for (int k = length - 1; k >= 0; --k) {
      flag = flag || res[k] != 0;
      if (flag) {
        sb.append(res[k]);
      }
    }

    return sb.toString();
  }
}
