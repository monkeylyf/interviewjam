/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode Longest Common Prefix
 */

#include <algorithm>
#include <stdio.h>
#include <string>
#include <vector>


using std::string;
using std::vector;


class Solution {
 public:
  string longestCommonPrefix(vector<string>& strs) {
    if (strs.size() == 0) {
      return "";
    }

    string first = strs.at(0);
    int min_size = first.size();
    for (const string str : strs) {
      int size = str.size(); // Cannot call min because of type mismatch.
      min_size = std::min(min_size, size);
    }

    int prefix_length = 0;
    bool samePrefix = true;
    for (; prefix_length < min_size && samePrefix; ++prefix_length) {
      char c = first[prefix_length];
      for (int i = 0; i < strs.size() && samePrefix; ++i) {
        samePrefix = strs.at(i)[prefix_length] == c;
      }
    }

    if (!samePrefix) {
      --prefix_length;
    }

    return first.substr(0, prefix_length);
  }
};


int main() {
  Solution sol;

  vector<string> strs { "hello", "helloworld" };
  const string res = sol.longestCommonPrefix(strs);
  printf("result: %s\n", res.c_str());
}
