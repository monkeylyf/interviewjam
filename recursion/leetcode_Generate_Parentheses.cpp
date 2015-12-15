/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode generate parentheses
 */

#include "gmock/gmock-matchers.h"
#include <gtest/gtest.h>

#include <stdio.h>
#include <string>
#include <vector>

using std::string;
using std::vector;


class Solution {
 private:
  void generateParenthesisUtil(int left, int right, vector<char>* acc,
      vector<string>* res) {
    if (left == 0 && right == 0) {
      string s(acc->begin(), acc->end());
      res->push_back(s);
      return;
    }

    if (left > 0) {
      acc->push_back('(');
      generateParenthesisUtil(left - 1, right, acc, res);
      acc->pop_back();
    }

    if (right > left) {
      acc->push_back(')');
      generateParenthesisUtil(left, right - 1, acc, res);
      acc->pop_back();
    }
  }

 public:
  vector<string> generateParenthesis(int n) {
    vector<string> res;
    vector<char>* acc = new vector<char>;
    generateParenthesisUtil(n, n, acc, &res);
    delete acc;

    return res;
  }
};


TEST(TestSuite, TestEqual) {
  Solution sol;
  vector<string> res = sol.generateParenthesis(3);

  vector<string> expected {
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()",
  };

  EXPECT_THAT(res, ::testing::ContainerEq(expected));
}
