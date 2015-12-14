/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode generate parentheses
 */

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


int main() {
  Solution sol;

  vector<string> res = sol.generateParenthesis(3);
  for (string s : res) {
    printf("%s\n", s.c_str());
  }
}
