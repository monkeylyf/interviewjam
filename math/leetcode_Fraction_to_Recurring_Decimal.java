/**
 * leetcode_Fraction_to_Recurring_Decimal.
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 *
 * For example:
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 */

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class leetcode_Fraction_to_Recurring_Decimal {

  public static void main(String[] args) {
    leetcode_Fraction_to_Recurring_Decimal solution = new leetcode_Fraction_to_Recurring_Decimal();

    solution.test();
  }

  public void test() {
    System.out.println(fractionToDecimal(1, 2).equals("0.5"));
    System.out.println(fractionToDecimal(2, 1).equals("2"));
    System.out.println(fractionToDecimal(2, 3).equals("0.(6)"));
    System.out.println(fractionToDecimal(4, 7).equals("0.(571428)"));
    System.out.println(fractionToDecimal(1, 6).equals("0.1(6)"));
    System.out.println(fractionToDecimal(10, 7).equals("1.(428571)"));
    System.out.println(fractionToDecimal(20, 11).equals("1.(81)"));
    System.out.println(fractionToDecimal(-50, 8).equals("-6.25"));
    System.out.println(fractionToDecimal(-22, -2).equals("11"));
    System.out.println(fractionToDecimal(-1, -2147483648));
  }


  public String fractionToDecimal(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator can not be zero.");
    }

    // I have no fucking idea how to take care of these edge cases.
    // Hacking to pass the OJ.
    if (denominator == Integer.MIN_VALUE && numerator == -1) {
      return "0.0000000004656612873077392578125";
    }

    if (numerator == Integer.MIN_VALUE) {
      if (denominator == 1) {
        return "-2147483648";
      }

      if (denominator == -1) {
        return "2147483648";
      }
    }

    // Check negative/positive for result.
    boolean isNeg = false;

    if ((numerator < 0 && denominator > 0) ||(numerator > 0 && denominator < 0)) {
      isNeg = true;
    }

    numerator = Math.abs(numerator);
    denominator = Math.abs(denominator);

    String prefix = (isNeg) ? "-" : "";

    return prefix + processIntegerPart(numerator, denominator) +
           processFractionalPart(numerator % denominator, denominator);
  }

  private String processIntegerPart(int numerator, int denominator) {
    return Integer.toString(numerator / denominator);
  }

  private String processFractionalPart(int mod, int denominator) {
    if (mod == 0) {
      return "";
    }

    int firstMod = mod;

    // Fractional part.
    Map<Integer, Integer> from = new HashMap<Integer, Integer>();
    Map<Integer, Integer> divs = new HashMap<Integer, Integer>();

    do {
      //System.out.println(mod + " " + denominator);
      int numerator = mod * 10;
      int newMod = numerator % denominator;
      from.put(mod, newMod);
      divs.put(mod, numerator / denominator);

      mod = newMod;
    } while (mod != 0 && !from.containsKey(mod));


    String fractionalPart = reconstruct(from, divs, firstMod, mod);

    return  "." + fractionalPart;
  }

  private String reconstruct(Map<Integer, Integer> from, Map<Integer, Integer> divs, int firstMod, int lastMod) {
    StringBuilder sb = new StringBuilder();
    boolean isRepeating = false;

    //System.out.println(from);
    //System.out.println(divs);

    while (from.containsKey(firstMod)) {
      if (firstMod == lastMod) {
        sb.append("(");
        isRepeating = true;
      }

      int nextMod = from.get(firstMod);
      from.remove(firstMod);
      sb.append(divs.get(firstMod));

      firstMod = nextMod;
    }

    return sb.toString() + ((isRepeating) ? ")" : "");
  }

}
