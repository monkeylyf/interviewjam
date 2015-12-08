/*
 * Copyright 2015
 *
 * leetcode Letter Combination of A Phone Number
 */


#include <string>
#include <vector>

using std::string;
using std::vector;


void printVector(const vector<string> &v) {
  for (string str : v) {
    printf("%s, ", str.c_str());
  }
  printf("\n");
}


void printCharVector(const vector<char> &v) {
  for (char c : v) {
    printf("%c ", c);
  }
  printf("\n");
}

class Solution {
 private:
  const vector<string> mapping = {
    "", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

 public:
  vector<string> letterCombinations(string digits) {
    vector<string>* collection = new vector<string>();

    if (digits.length() == 0) {
      return collection;
    }

    vector<string> candicates;
    vector<char>* acc = new vector<char>();

    for (char digit : digits) {
      int index = digit - '0';
      candicates.push_back(Solution::mapping[index]);
    }

    dfs(0, acc, candicates, collection);

    delete acc;

    return *collection;
  }

  void dfs(int i, vector<char>* acc, const vector<string>& candicates,
      vector<string>* collection) {
    if (i == candicates.size()) {
      string combination(acc->begin(), acc->end());
      collection->push_back(combination);
      return;
    }

    for (char c : candicates.at(i)) {
      acc->push_back(c);
      dfs(i + 1, acc, candicates, collection);
      acc->pop_back();
    }
  }
};


int main() {
  Solution sol;
  vector<string> res = sol.letterCombinations("23");

  printVector(res);
}
