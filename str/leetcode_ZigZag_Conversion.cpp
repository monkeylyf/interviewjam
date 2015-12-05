/*
 * Copyright 2015
 *
 * leetcode zigzag conversion
 */

#include <stdio.h>
#include <string>
#include <vector>

using std::string;
using std::vector;


typedef vector<char> char_v;

class Solution {
 public:
  string convert(string s, int numRows) {
    if (numRows == 1 || s.length() <= numRows) {
      return s;
    }
    vector<char_v> zigzag(numRows);

    int i = 0;
    const int interval = numRows * 2 - 2;
    for (char c : s) {
      int mod = i % interval;
      int idx = (mod < numRows) ? mod : numRows - (mod % numRows) - 2;
      zigzag.at(idx).push_back(c);
      ++i;
    }

    char str[s.length()];

    i = 0;
    for (char_v v : zigzag) {
      for (char c : v) {
        str[i] = c;
        ++i;
      }
    }

    return string(str);
  }
};


int main() {
  Solution sol;
  string res = sol.convert("PAYPALISHIRING", 3);
  //string res = sol.convert("A", 2);
  printf("%s\n", res.c_str());
}
