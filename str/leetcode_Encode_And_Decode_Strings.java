/**
 * Encode and decode strings.
 *
 * leetcode
 *
 * Design an algorithm to encode a list of strings to a string. The encoded
 * string is then sent over the network and is decoded back to the original list
 * of strings.
 *
 * Machine 1 (sender) has the function:
 *
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * So Machine 1 does:
 *
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 *
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class leetcode_Encode_And_Decode_Strings {

  private static char DELEM = '#';
  private static char LENGHT_DELEM = '.';

  public static void main(String[] args) {
    leetcode_Encode_And_Decode_Strings sol = new leetcode_Encode_And_Decode_Strings();
    sol.test();
  }

  public void test() {
    String encoded = encode(Arrays.asList("ab", "bc"));
    //List<String> strs = new ArrayList<>();
    //String encoded = encode(strs);
    System.out.println(encoded);
    List<String> decoded = decode(encoded);
    for (String str: decoded) {
      System.out.println(str);
    }
  }

  /**
   * Encodes a list of strings to a single string.
   *
   * <str1_length>.<str2_length>...#<str1><str2>...
   */
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strs.size(); ++i) {
      if (i != 0) {
        sb.append(LENGHT_DELEM);
      }
      sb.append(Integer.toString(strs.get(i).length()));
    }
    sb.append(DELEM);
    for (String str: strs) {
      sb.append(str);
    }
    return sb.toString();
  }

  /**
   * Decodes a single string to a list of strings.
   *
   * 1. Split length part and strs part
   * 2. Parse length part to get each length
   * 3. Extract each string from str part given length
   */
  public List<String> decode(String s) {
    List<String> decoded = new ArrayList<>();
    int idx = s.indexOf(DELEM);
    String lengths = s.substring(0, idx);
    String concatenated = s.substring(idx + 1, s.length());

    if (lengths.length() > 0) {
      int start = 0;
      for (String length : lengths.split("\\" + LENGHT_DELEM)) {
        int len = Integer.parseInt(length);
        //System.out.println(len);
        decoded.add(concatenated.substring(start, start + len));
        start = start + len;
      }
    }

    return decoded;
  }
}
