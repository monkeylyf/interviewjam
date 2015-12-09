/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode roman to int
 */

#include <stdio.h>
#include <string>
#include <vector>

using std::string;
using std::vector;


class Solution {
 private:
  const vector<string> symbol { "M", "CM", "D", "CD", "C", "XC", "L",
    "XL", "X", "IX", "V", "IV", "I" };
  const vector<int> value { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

 public:
  /*
   * I was over-thinking. I thought IIV represents 3, which is incorrect. It
   * should be III instead. The crux of it is, for numbers like 4, 9, 40..etc
   * It will be case that substraction neeed to be considered and this is a two
   * char combination. A sliding window of length two will handle it elegantly
   * with the last char processed seperately.
   * What if IIV is a legal representation of Roman numerics? A sliding windows
   * of length 3 will do and you need to check
   * if (window[0] == window[1] && window[1] < window[2]) {
   *   res -= window[1];
   * } else if (window[0] >= window[1]) {
   *   res += window[1]
   * } else {
   *   res -+ window[1];
   * }
   *
   */
  int romanToInt(string s) {
    // Pre-precessing for char to value mapping.
    int mapping[26];
    const char symbols[] = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
    const int values[] = { 1000, 500, 100, 50, 10, 5, 1 };
    for (int i = 0; i < sizeof(values) / sizeof(values[0]); ++i) {
      mapping[symbols[i] - 'A'] = values[i];
    }

    int res = 0;
    // Process.
    for (int i = 0; i < s.size() - 1; ++i) {
      int cur = mapping[s[i] - 'A'];
      int next = mapping[s[i + 1] - 'A'];

      if (cur >= next) {
        res += cur;
      } else {
        res -= cur;
      }
    }

    // Process last char.
    res += mapping[s[s.size() - 1] - 'A'];

    return res;
  }
};


int main() {
  Solution sol;
  //const int res = sol.romanToInt("MMMCMXCIX");
  const int res = sol.romanToInt("IV");
  printf("Result: %d\n", res);
}
