/*
 * Copyright 2015
 * Author: man don't give him shiiiiieeeeeet
 *
 * leetcode Integer To Roman
 */

#include <stdio.h>
#include <string>
#include <vector>

using std::vector;
using std::string;


class Solution {
 private:
  const vector<string> symbol { "M", "CM", "D", "CD", "C", "XC", "L",
    "XL", "X", "IX", "V", "IV", "I" };
  const vector<int> value { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

 public:
  string intToRoman(int num) {
    vector<string> v;

    int i = 0;

    while (i < Solution::value.size()) {
      int val = value.at(i);
      if (val > num) {
        i += 1;
      } else {
        v.push_back(symbol.at(i));
        num -= val;
      }
    }

    string res;
    for (const auto &seg : v) {
      res += seg;
    }
    return res;
  }
};


int main() {
  Solution sol;
  string res = sol.intToRoman(3999);
  printf("result: %s\n", res.c_str());
}
