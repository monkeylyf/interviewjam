/**
 * leetcode_Repeated_DNA_Sequences.
 *
 * leetcode.
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 *
 * For example,
 *
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;


public class leetcode_Repeated_DNA_Sequences {

  public static void main(String[] args) {
    leetcode_Repeated_DNA_Sequences solution = new leetcode_Repeated_DNA_Sequences();
    solution.test();
  }

  public void test() {
    System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
  }

  /**
   * No brainer is scan with sliding window with Map/Set.
   *
   * The problem is using substring as key will consume too much memory and
   * have EML. The trick is to convert the substring to an integer,
   * 4 bytes * 10 - 4 bytes = 36 bytes will be saved.
   */
  public List<String> findRepeatedDnaSequences(String s) {
    Set<Integer> set = new HashSet<>();
    Set<String> ret = new HashSet<>();

    for (int i = 0; i <= s.length() - 10; ++i) {
      String seq = s.substring(i, i + 10);
      int key = getKey(seq);

      if (set.contains(key)) {
        ret.add(seq);
      } else {
        set.add(key);
      }
    }

    return new ArrayList<String>(ret);
  }

  /**
   * Convert a length 10 String into binary(deci).
   *
   * String only contains A/T/G/C.
   * Use tw bits to represent them. so a 10 char long string will be converted
   * into a 20 bits.
   */
  private int getKey(String s) {
    int mask = 0;
    for (int i = 0; i < s.length(); ++i) {
      mask = mask << 2;
      switch(s.charAt(i)) {
        case 'A':
          mask = mask | 0;
          break;
        case 'T':
          mask = mask | 1;
          break;
        case 'G':
          mask = mask | 2;
          break;
        case 'C':
          mask = mask | 3;
          break;
      }
    }

    return mask;
  }
}
