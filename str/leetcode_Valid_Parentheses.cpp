/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode valid parentheses
 */

#include <stdio.h>
#include <string>
#include <stack>


using std::string;
using std::stack;


class Solution {
 public:
  bool isValid(string s) {
    stack<char> container;
    for (char c : s) {
      if (isLeftParentheses(c)) {
        container.push(c);
      } else if (isRightParentheses(c)) {
        if (container.empty()) {
          return false;  // "}}"
        }
        if (!isMatch(container.top(), c)) {
          return false;
        }
        container.pop();
      } else {
        throw -1;
      }
    }

    // "{{}".
    return container.empty();
  }

  bool isLeftParentheses(char c) {
    return c == '(' || c == '[' || c == '{';
  }

  bool isRightParentheses(char c) {
    return c == ')' || c == ']' || c == '}';
  }

  bool isMatch(char left, char right) {
    return (left == '(' && right == ')') ||
           (left == '[' && right == ']') ||
           (left == '{' && right == '}');
  }
};


int main() {
  Solution sol;
  bool res = sol.isValid("()");
  printf("Result: %s\n", res ? "True" : "False");
}
