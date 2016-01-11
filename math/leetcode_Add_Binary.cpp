/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode add binary
 */

#include <stdio.h>
#include <string>

using std::string;


class Solution {
 public:
  string addBinary(string a, string b) {
    bool carry = false;
    int i = a.length() - 1;
    int j = b.length() - 1;
    string sum = "";

    char digit;
    while (i >= 0 && j >= 0) {
      if (a[i] == '1' && b[j] == '1') {
        digit = carry ? '1' : '0';
        carry = true;
      } else if (a[i] == '0' && b[j] == '0') {
        digit = carry ? '1' : '0';
        carry = false;
      } else {
        digit = carry ? '0' : '1';
      }
      sum = digit + sum;
      --i;
      --j;
    }

    // At most one of the following while block will be executed.
    while (i >= 0) {
      if (a[i] == '1') {
        digit = carry ? '0' : '1';
      } else {
        digit = carry ? '1' : '0';
        carry = false;
      }
      sum = digit + sum;
      --i;
    }

    while (j >= 0) {
      if (b[j] == '1') {
        digit = carry ? '0' : '1';
      } else {
        digit = carry ? '1' : '0';
        carry = false;
      }
      sum = digit + sum;
      --j;
    }

    if (carry) {
      sum = '1' + sum;
    }


    return sum;
  }
};


int main() {
  Solution sol;
  string res = sol.addBinary("110", "11");

  printf("result: %s\n", res.c_str());
}
