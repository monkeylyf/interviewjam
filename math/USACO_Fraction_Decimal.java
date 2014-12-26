/**
 * USACO_Fraction_Decimal.
 *
 * To find the first digit, we can calculate 30/8 = 3. Then we know the
 * result is 0.3xxxx...
 * 2. To find the second digit, we first minus 3/8 by 0.3, which is 3/8 - 3/10
 * = (3*10 - 3*8) / 8*10 = 6/80. Note that since we only want to calculate the
 * next digit, we can multiply 6/80 by 10, which gives 6/8. Then we treat 6/8
 * as a new fraction, and repeat step 1. The first digit of 6/8 is 7, which means
 * 6/8 = 0.7xxxx, i.e. 3/8 = 0.37xxxx
 * 3. The above steps are repeated until numerator is 0, or a repeating sequence
 * is found.
 * 4. To find repeating sequence, we store each previous fraction. If the new
 * fraction equals one of the previous fractions, it means there is a repeating
 * sequence.
 *
 * Mark as duplicate. Please check math/leetcode_Fraction_to_Recurring_Decimal
 * which contains more edge cases.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class USACO_Fraction_Decimal {

  private static final String COLON = ":";

  public static void main(String[] args) {
    USACO_Fraction_Decimal solution = new USACO_Fraction_Decimal();
    solution.test();
  }

  /**
   * Test cases.
   */
  public void test() {
    System.out.println(solve(4, 7));
    System.out.println(solve(5, 10));
    System.out.println(solve(1, 4));
    System.out.println(solve(3, 11));
  }

  public String solve(int numerator, int denominator) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    List<Integer> seq = new ArrayList<Integer>();

    do {
      //System.out.println("Looping " + seq.size() + " " + numerator + "/" + denominator);
      int num = numerator * 10 / denominator;
      //System.out.println("num " + num);
      map.put(numerator + COLON + denominator, seq.size());
      seq.add(num);
      // numerator / denominator - num / 10
      int newNumerator = (numerator * 10 - denominator * num) * 10;
      int newDenominator = denominator * 10;
      int common = gcd(newNumerator, newDenominator);
      numerator = newNumerator / common;
      denominator = newDenominator / common;
    } while (seq.size() != 76 & !map.containsKey(numerator + COLON + denominator) & numerator != 0);

    StringBuilder sb = new StringBuilder("0.");
    if (map.containsKey(numerator + COLON + denominator)) {
      int start = map.get(numerator + COLON + denominator);
      for (int i = 0; i < start; ++i) {
        sb.append(seq.get(i));
      }
      sb.append("(");
      for (int i = start; i < seq.size(); ++i) {
        sb.append(seq.get(i));
      }
      sb.append(")");
    } else {
      for (int i = 0; i < seq.size(); ++i) {
        sb.append(seq.get(i));
      }
    }

    return sb.toString();
  }

  public int gcd(int a, int b) {
    return (b == 0) ? a : gcd(b, a % b);
  }
}
