/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode length of last string
 */

#include <stdio.h>
#include <string>

using std::string;


class Solution {
 public:
  int lengthOfLastWord(string s) {
    int length = 0;
    int end = s.length() - 1;
    while (end >= 0 && s[end] == ' ') {
      --end;
    }

    for (int i = 0; i <= end; ++i) {
      char c = s[i];
      ++length;
      if (c == ' ') {
        length = 0;
      }
    }
    return length;
  }
};


int main() {
  Solution sol;

  //int res = sol.lengthOfLastWord("Hello world");
  int res = sol.lengthOfLastWord("a  ab ");
  printf("Result: %d\n", res);
}
