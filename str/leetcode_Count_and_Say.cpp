/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode count and say
 */


#include <stdio.h>
#include <string>

using std::string;
using std::to_string;

class Solution {
 public:
  string countAndSay(int n) {
    string number = "1";

    while (n > 1) {
      string next_number = "";
      char prev = '\0';
      int count = 0;
      for (char c : number) {
        if (prev == '\0') {
          prev = c;
          count = 1;
        } else if (prev == c) {
          ++count;
        } else {
          next_number += to_string(count) + prev;
          count = 1;
          prev = c;
        }
      }

      next_number += to_string(count) + prev;
      number = next_number;
      --n;
    }
    return number;
  }
};


int main() {
  Solution sol;

  for (int i = 1; i < 10; ++i) {
    string res = sol.countAndSay(i);
    printf("#%d: %s\n", i, res.c_str());
  }
}
