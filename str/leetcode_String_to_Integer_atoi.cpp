/*
 * Copyright 2015
 *
 * leetcode String to Integer atoi
 */

#include <stdio.h>
#include <string>
#include <locale>
#include <limits>

using std::locale;
using std::string;
using std::numeric_limits;


class Solution {
 public:
  int myAtoi(string str) {
    locale loc;
    bool is_neg = false;
    bool overflow = false;
    bool non_digit = false;
    string::size_type i = 0;
    int ret = 0;

    // Handle whitespaces prefixed.
    while (i < str.length() && isspace(str[i], loc)) {
      ++i;
    }

    // Hanlde case only whitespaces: "   ".
    if (i >= str.length()) {
      return ret;
    }

    // Check neg/pos.
    if (str[i] == '+' || str[i] == '-') {
      is_neg = str[i] == '-';
      ++i;
    }

    // Hanlde case whitespaces + sign: "   +"
    if (i >= str.length()) {
      return ret;
    }

    // Constants for overflow case.
    const int divident = 10;
    const int max_int_wo_last_digit = numeric_limits<int>::max() / divident;
    const int max_int_last_digit = (is_neg) ? numeric_limits<int>::max() % divident + 1 : numeric_limits<int>::max() % divident;

    while (!overflow && i < str.length() && isdigit(str[i], loc)) {
      int digit = str[i] - '0';
      overflow = ret > max_int_wo_last_digit ||
        (ret == max_int_wo_last_digit && digit > max_int_last_digit);
      ret = ret * divident + digit;
      i++;
    }

    if (overflow) {
      return (is_neg) ? numeric_limits<int>::min() : numeric_limits<int>::max();
    } else {
      return (is_neg) ? -ret : ret;
    }
  }
};


int main() {
  Solution sol;
  int res = sol.myAtoi(" -1010023630o4");
  printf("result: %d\n", res);
}
