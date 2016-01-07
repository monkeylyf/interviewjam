/**
 * Multiply_Strings
 *
 * Given two numbers represented as strings, return multiplication of the numbers
 * as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 */

public class leetcode_Multiply_Strings {

  public static void main(String[] args) {
    System.out.println(multiply("123456789", "987654321"));
  }

  public static String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    String res = "0";
    String tail = "";
    for (int i = num1.length() - 1; i >= 0; --i) {
      String one = num1.charAt(i) + "";
      String eachDigit = oneDigitMultiply(one, num2) + tail;
      tail += "0";
      res = add(eachDigit, res);
    }
    return res;
  }

  public static String add(String num1, String num2) {
    String res = "";
    String addOn = "";
    int carry = 0;
    for (int i = 0; i < Math.abs(num1.length() - num2.length()); ++i) {
      addOn += "0";
    }
    if (num1.length() > num2.length()) {
      num2 = addOn + num2;
    } else {
      num1 = addOn + num1;
    }
    for (int i = num1.length() - 1; i >= 0; --i) {
      int sum = Integer.parseInt(num1.charAt(i) + "") + Integer.parseInt(num2.charAt(i) + "") + carry;
      int newdigit = sum % 10;
      carry = sum / 10;
      res = Integer.toString(newdigit) + res;
    }
    if (carry == 1) {
      res = "1" + res;
    }
    return res;
  }

  public static String oneDigitMultiply(String one, String num) {
    if (one.equals("0")) {
      return "0";
    }
    String res = "";
    int onedigit = Integer.parseInt(one);
    int carry = 0;
    for (int i = num.length() - 1; i >= 0; --i) {
      int product = Integer.parseInt(num.charAt(i) + "") * onedigit + carry;
      carry = product / 10;
      String newDigit = Integer.toString(product % 10);
      res = newDigit + res;
    }
    if (carry > 0) {
      res = Integer.toString(carry) + res;
    }
    return res;
  }
}

/* Python Verson (TLE with one test case.)
Of course you can cheat with Python.
lambda x, y : str(long(x) * long(y))
However, I don't cheat.

class Solution:
    # @param num1, a string
    # @param num2, a string
    # @return a string
    def multiply(self, num1, num2):
        if num1 == '0' or num2 == '0':
            return '0'

        if len(num1) > len(num2):
            swap = num1
            num1 = num2
            num2 = swap

        ret = '0'
        tail = ''

        cache = {}


        for i in reversed(xrange(len(num2))):
            digit = num2[i]
            try:
                res = cache[digit]
            except KeyError:
                res = self.multiplyByOne(num1, digit)
                cache[digit] = res
            ret = self.add(ret, res + tail)
            tail += '0'
        return ret

    def add(self, num1, num2):
        n = len(num1)
        m = len(num2)
        num1 = num1.zfill(max(m, n))
        num2 = num2.zfill(max(m, n))
        carry = 0
        ret = []
        for i in reversed(xrange(len(num1))):
            s = int(num1[i]) + int(num2[i]) + carry
            ret.append(str(s % 10))
            carry = s / 10

        if carry != 0:
            ret.append(str(carry))

        return ''.join(reversed(ret))

    def multiplyByOne(self, num, digit):
        if digit == '0':
            return '0'
        if digit == '1':
            return num

        carry = 0

        ret = []
        digit = int(digit)
        for i in reversed(xrange(len(num))):
            x = digit * int(num[i]) + carry
            ret.append(str(x % 10))
            carry = x / 10

        if carry != 0:
            ret.append(str(carry))

        return ''.join(reversed(ret))
*/
