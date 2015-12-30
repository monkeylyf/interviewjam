/*
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode implement strStr
 */

#include <stdio.h>
#include <string>

using std::string;


class Solution {
 public:
  int strStr(string haystack, string needle) {
    if (needle.empty()) {
      return 0;
    }

    if (haystack.empty()) {
      return -1;
    }

    if (haystack.length() < needle.length()) {
      return -1;
    }

    int haystackIdx = 0;
    int needleIdx = 0;
    bool found = false;

    while (!found && haystackIdx < haystack.length() && needleIdx < needle.length()) {
      if (haystack.at(haystackIdx) == needle.at(needleIdx)) {
        ++haystackIdx;
        ++needleIdx;
        found = needleIdx == needle.length();
      } else {
        haystackIdx = haystackIdx - needleIdx  + 1;  // Move to next starting point.
        needleIdx = 0;  // Reset needleIdx and restart over.
      }
    }

    return found ? haystackIdx - needleIdx : -1;
  }
};


int main() {
  Solution sol;
  int res = sol.strStr("abc", "bc");

  printf("result: %d\n", res);
}
