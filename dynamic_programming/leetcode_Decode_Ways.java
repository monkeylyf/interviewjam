/**
 * Decode_Ways
 * leetcode
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given an encoded message containing digits, determine the total number of ways
 * to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 */


class leetcode_Decode_Ways {

  public static void main(String[] args) {
    System.out.println(numDecodings("17"));
  }

  public static int numDecodings(String s) {
    if (s.length() == 0) {
      return 0;
    }
    int c1;
    if (s.charAt(0) == '0') {
      return 0;
    } else {
      c1 = 1;
    }
    int c0 = 1;
    for (int i = 1; i < s.length(); ++i) {
      int decodeTwo = Integer.parseInt(s.substring(i - 1, i + 1));
      int decodeOne = Integer.parseInt(s.substring(i, i + 1));
      boolean two = ((decodeTwo >= 10) && (decodeTwo <= 26));
      boolean one = decodeOne != 0;
      if (two && one) {
        // For cur char, both previous two digits and previous one digit
        // can be decoded.
        c1 += c0; // new c1 = c1 + c0
        c0 = c1 - c0; //new c0 = old c1 = new c1 - c0
      } else if (two && !one) {
        // Can only decode previous two digits.
        int swap = c1; // new c1 = old c0
        c1 = c0; // new c0 = old c1
        c0 = swap;
      } else if (!two && one) {
        // Can only decode previous one digit.
        c0 = c1;
      } else {
        return 0;
      }
    }
    return c1;
  }
}

/* Python Version
Could use constant space instead of O(n) like Java code above.

def numDecodings(self, s):
    if not s:
        return 0

    if s[0] == '0':
        return 0

    c0 = c1 = 1
    for i in xrange(1, len(s)):
        one = int(s[i])
        two = int(s[i - 1 : i + 1])

        useOne = one != 0
        useTwo = two >= 10 and two <= 26

        if useOne and useTwo:
            c1 += c0
            c0 = c1 - c0
        elif useOne and not useTwo:
            c0 = c1
        elif not useOne and useTwo:
            swap = c1
            c1 = c0
            c0 = c1
        else:
            return 0
    return c1
*/

/* Python Version
O(n) space. Not really elagent since you have to take care dp[1], which is quite messy.

def numDecodings(self, s):
    if not s:
        return 0

    if s[0] == '0':
        return 0


    dp = [ 0 for _ in xrange(len(s)) ]
    dp[0] = 1
    if len(s) == 1:
        return dp[0]
    if s[1] == '0':
        dp[1] = 1 if s[0] in ('1', '2') else 0
    else:
        dp[1] = 2 if int(s[:2]) <= 26 else 1
    for i in xrange(2, len(s)):
        one = int(s[i])
        two = int(s[i - 1 : i + 1])
        useOne = one != 0
        useTwo = two >= 10 and two <= 26

        if useOne and useTwo:
            dp[i] = dp[i - 1] + dp[i - 2]
        elif useOne and not useTwo:
            dp[i] = dp[i - 1]
        elif not useOne and useTwo:
            dp[i] = dp[i - 2]
        else:
            return 0

    return dp[-1]
*/
