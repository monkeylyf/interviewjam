/**
 * leetcode_Single_Number_II.
 *
 * leetcode
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it
 * without using extra memory?
 */


public class leetcode_Single_Number_II {

  public static void main(String[] args) {
    // Test case 1.
    System.out.println(singleNumber(new int[] {1, 1, 1, 2}));
    // Test case 2.
    System.out.println(singleNumber(new int[] {-2,-2,1,1,-3,1,-3,-3,-4,-2}));
  }

  /**
   * Count the 1/0 at each digit of the binary representation of the given numbers.
   *
   * Since it is either 1 or 0, then the sum ==  3 * a * 1 + 3 * b * 0 + 0/1
   * where a + b = = len(all_num) - 1. Then the element appears once has sum % n
   * at this position. * Be aware of the two's * component, which is how negative
   * integer is represented in binary form.
   */
  public static int singleNumber(int[] A) {
    char[] bits = new char[32];
    for (int i = 0; i < 32; ++i) {
      int sum = 0;
      for (int j = 0; j < A.length; ++j) {
        sum += (A[j] >> i) % 2;
      }
      bits[31 - i] = (sum % 3 == 0) ? '0' : '1';
    }
    print(bits);
    if (bits[0] == '1') {
      // Reverse and add one due to two's complement.
      for (i = 0; i < 32; ++i) {
        bits[i] = (bits[i] == '1') ? '0' : '1';
      }
      return -Integer.parseInt(new String(bits), 2) - 1;
    } else {
      return Integer.parseInt(new String(bits), 2);
    }
  }

  // Helper function.
  public static void print(char[] arr) {
    for (char c : arr) System.out.print(c + " ");
    System.out.println();
  }
}


/* Python Version
def singleNumber(self, A):
    bits = ['0'] * 32

    for digit in xrange(32):
        count = 0
        for num in A:
            count += (num >> digit) % 2
        bits[31 - digit] = '0' if count % 3 == 0 else '1'
    if bits[0] == '1':
        for idx, val in enumerate(bits):
            bits[idx] = '0' if val == '1' else '1'
        return -int(''.join(bits), 2) - 1
    else:
        return int(''.join(bits), 2)

*/
