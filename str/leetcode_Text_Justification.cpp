/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode test justification
 */

#include <stdio.h>
#include <string>
#include <vector>

using std::string;
using std::vector;


class Solution {
 public:
  vector<string> fullJustify(const vector<string>& words, int maxWidth) {
    int acc = 0;
    int whitespaces = maxWidth;
    vector<string>::const_iterator start = words.begin();
    vector<string>::const_iterator it = words.begin();
    vector<string>  text;
    for (; it < words.end(); ++it) {
      int word_length = it->length();
      if (word_length + acc > maxWidth) {
        text.push_back(justifyRow(vector<string> (start, it), whitespaces));
        start = it;
        acc = word_length + 1;
        whitespaces = maxWidth - word_length;
      } else {
        acc += word_length + 1;
        whitespaces -= word_length;
      }
    }

    if (start != it) {
      string row = "";
      for (; start != it; ++start) {
        if (start + 1 == it) {
          row += *start + padWhitespace(whitespaces);
        } else {
          row += (*start) + " ";
          whitespaces -= 1;
        }
      }
      text.push_back(row);
    }

    return text;
  }

 private:
  string justifyRow(const vector<string> row, int whitespaces) {
    if (row.size() == 0) {
      return "";
    } else if (row.size() == 1) {
      return row[0] + padWhitespace(whitespaces);
    } else {
      int even = whitespaces / (row.size() - 1);
      int mod = whitespaces % (row.size() - 1);

      string row_str = "";
      for (int i = 0; i < row.size(); ++i) {
        int trailing_whitespaces = 0;
        if (i != row.size() - 1) {
          trailing_whitespaces = (i < mod) ? even + 1 : even;
        }
        string padded = padWhitespace(trailing_whitespaces);
        row_str += row[i] + padded;
      }

      return row_str;
    }
  }

  string padWhitespace(int n) {
    if (n == 0) {
      return "";
    }
    vector<char> v (n, ' ');
    return string(v.begin(), v.end());
  }
};


int main() {
  Solution sol;
  //vector<string> words = {
  //  "This", "is", "an", "example", "of", "text", "justification."
  //};
  vector<string> words = {"What","must","be","shall","be."};
  vector<string> text = sol.fullJustify(words, 12);
  for (string row : text) {
    printf("%s$\n", row.c_str());
  }
}
