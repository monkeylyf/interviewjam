/**
 * leetcode_Factorial_Trailing_Zeros.
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */


public class leetcode_Factorial_Trailing_Zeros {

  public static void main(String[] args) {
    leetcode_Factorial_Trailing_Zeros solution = new leetcode_Factorial_Trailing_Zeros();
    solution.test();
  }

  public void test() {
    for (int i = 0; i <= 100; ++i) {
      System.out.println(i + " " + trailingZeroes(i));
    }
  }

  /**
   * 10 = 2 * 5 and for consecutive numbers, the number of factor 2 is more
   * than the number of factor 5.
   *
   * Hence the number of trailing zeros is equal to the number of factor 5.
   * Now the question is how many factor 5 in n!.
   *
   * Time complexity O(log5(n))
   */
  public int trailingZeroes(int n) {
    int countOfFactorFive = 0;

    while (n > 0) {
      countOfFactorFive += n / 5;
      n /= 5;
    }

    return countOfFactorFive;
  }
}
