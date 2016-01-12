/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode simplify path
 */

#include <stdio.h>
#include <string>
#include <vector>

using std::string;
using std::vector;


class Solution {
 public:
  string simplifyPath(string path) {
    vector<string> stack;

    string acc = "";
    for (char c : path) {
      if (c == '/') {
        if (acc == ".") {
          // Do nothing.
        } else if (acc == "..") {
          if (!stack.empty()) {
            stack.pop_back();
          }
        } else if (acc.length() > 0) {
          stack.push_back(acc);
        }
        acc = "";
      } else {
        acc += c;
      }
    }

    // Last batch.
    if (acc.length() > 0 && acc != ".") {
      if (acc == "..") {
        if (!stack.empty()) {
          stack.pop_back();
        }
      } else {
        stack.push_back(acc);
      }
    }

    if (stack.empty()) {
      return "/";
    } else {
      string res = "";
      for (string dir : stack) {
        res += "/" + dir;
      }

      return res;
    }
  }
};


int main() {
  Solution sol;
  //string res = sol.simplifyPath("/a/./b/../../c/");
  string res = sol.simplifyPath("/home/");
  printf("result: %s\n", res.c_str());
}
