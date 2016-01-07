/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode multiply strings
 */

#include <stdio.h>
#include <string>

using std::string;


class Solution {
 public:
  string multiply(string num1, string num2) {
    if (num1 == "0" || num2 == "0") {
      return "0";
    }

    if (num1 == "1") {
      return num2;
    }

    if (num2 == "1") {
      return num1;
    }

    string product = "0";

    for (int i = num1.length() - 1; i >= 0; --i) {
      string partial_product = multiplyByOneDigit(num2, num1[i]);
      int num_of_zero = num1.length() - 1 - i;
      string padded_partial_product = padTrailingZeros(partial_product, num_of_zero);
      product = addTwoString(product, padded_partial_product);
    }
    return product;
  }

 private:
  string padTrailingZeros(string num, int num_of_zero) {
    for (int i = 0; i < num_of_zero; ++i) {
      num += "0";
    }
    return num;
  }

  string multiplyByOneDigit(string num, char digit) {
    if (digit == '0') {
      return "0";
    }
    if (digit == '1') {
      return num;
    }

    int digit_val = digit - '0';
    int carry = 0;
    string product = "";
    for (int i = num.length() - 1; i >= 0; --i) {
      int val = (num[i] - '0') * digit_val + carry;
      carry = val / 10;
      int mod = val % 10;
      product = std::to_string(mod) + product;
    }

    if (carry > 0) {
      product = std::to_string(carry) + product;
    }

    return product;
  }

  string addTwoString(string num1, string num2) {
    if (num1 == "0") {
      return num2;
    }

    if (num2 == "0") {
      return num1;
    }

    string sum = "";
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    bool carry = false;

    while (i >= 0 && j >= 0) {
      int val = (num1[i] - '0')  + (num2[j] - '0') + (carry ? 1 : 0);
      carry = val >= 10;
      sum = std::to_string(val % 10) + sum;
      --i;
      --j;
    }

    while (i >= 0) {
      int val = (num1[i] - '0') + (carry ? 1 : 0);
      carry = val >= 10;
      sum = std::to_string(val % 10) + sum;
      --i;
    }

    while (j >= 0) {
      int val = (num2[j] - '0') + (carry ? 1 : 0);
      carry = val >= 10;
      sum = std::to_string(val % 10) + sum;
      --j;
    }

    if (carry) {
      sum = "1" + sum;
    }

    return sum;
  }
};


int main() {
  Solution sol;
  string res = sol.multiply("123", "123");
  printf("Result: %s\n", res.c_str());
}
