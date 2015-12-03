/*
 * Copyright 2015
 * Author: ouroboros
 *
 * leetcode longest substring w/o repeatin'chars
 */

#include <algorithm>
#include <string>

using std::string;
using std::max;


class Solution {
 public:
  int lengthOfLongestSubstring(string s) {
    bool seen[256] = { false };
    int start = 0;
    int end = 0;
    int ret = 0;
    while (end < s.length()) {
      if (seen[s[end]]) {
        ret = max(ret, end - start);
        while (s[start] != s[end]) {
          seen[s[start]] = false;
          ++start;
        }
        ++start;
      } else {
        seen[s[end]] = true;
      }

      ++end;
    }
    return max(ret, end - start);
  }
};



int main() {
  Solution sol;
  int len = sol.lengthOfLongestSubstring("abcabcbb");
  if (len != 3) {
    throw 1;
  }
  return 0;
}
