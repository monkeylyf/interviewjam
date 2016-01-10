/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode permutation sequence
 */

#include <stdio.h>
#include <string>
#include <vector>

using std::string;
using std::vector;

class Solution {
 public:
  string getPermutation(int n, int k) {
    vector<char> char_v;

    vector<char> nums;
    for (int i = 1; i <= n; ++i) {
      nums.push_back(i + '0');
    }
    nextPermutation(&char_v, &nums, k, factorial(n));
    return string (char_v.begin(), char_v.end());
  }

 private:
  int factorial(int k) {
    int fact = 1;
    while (k > 1) {
      fact *= k;
      --k;
    }
    return fact;
  }

  void nextPermutation(vector<char>* char_v, vector<char>* nums, int k, int fact) {
    if (nums->size() > 0) {
      int n = nums->size();
      int nextPermTotal = fact / n;
      int mod = k % nextPermTotal;
      int bucket = k / nextPermTotal + ((mod > 0) ? 1 : 0);
      char num = (*nums)[bucket - 1];
      char_v->push_back(num);
      nums->erase(nums->begin() + bucket - 1);

      nextPermutation(char_v, nums, (mod == 0) ? nextPermTotal : mod, nextPermTotal);
    }
  }
};


int main() {
  Solution sol;

  for (int i = 1; i <= 24; ++i) {
    string res = sol.getPermutation(4, i);
    printf("%s\n", res.c_str());
  }
}
