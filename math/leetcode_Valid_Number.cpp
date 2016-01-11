/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode valid number
 */

#include <stdio.h>
#include <locale>
#include <string>
#include <vector>

using std::isdigit;
using std::string;
using std::vector;


class Solution {
 public:
  bool isNumber(string s) {
    int start = 0;
    int end = s.length() - 1;

    while (start < s.length() && s[start] == ' ') {
      ++start;
    }

    while (end > start && s[end] == ' ') {
      --end;
    }

    if (start > end) {
      return false;
    }

    if (s[start] == '+' || s[start] == '-') {
      ++start;  // Still valid but don't care whether it's neg/pos
    }


    bool has_e = false;
    bool has_dot = false;
    bool left_part_of_dot = false;
    bool right_part_of_dot = false;
    while (start <= end) {
      char c = s[start];
      if (c == '+' || c == '-') {
        // Any '+'/'-' must exist right after 'e'/'E'
        if (!has_e || (s[start - 1] != 'e' && s[start - 1] != 'E')) {
          return false;
        }
      } else if (c == '.') {
        if (has_e || has_dot) {
          // Dup dot.
          return false;
        } else {
          has_dot = true;
        }
      } else if (c == 'e' || c == 'E') {
        if (has_e || !left_part_of_dot) {
          // Dup e or e has no left part.
          return false;
        } else {
          has_e = true;
        }
      } else if (isdigit(c)) {
        if (!has_e) {
          left_part_of_dot = true;
        } else {
          right_part_of_dot = true;
        }
      } else {
        return false;
      }
      ++start;
    }

    return left_part_of_dot && (!has_e || right_part_of_dot);
  }
};


int main() {
  Solution sol;
  bool res = sol.isNumber("3");
  printf("Result: %c\n", res ? 't' : 'f');
}
