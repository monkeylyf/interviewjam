/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode minimum window substring
 */


#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <vector>

using std::string;
using std::vector;


class Solution {
 public:
  string minWindow(string s, string t) {
    if (s == t) {
      return s;
    }
    if (s.length() < t.length() || t.length() == 0) {
      return "";
    }

    vector<int> window_freq (256, 0);
    vector<int> word_freq (256, 0);
    for (char c : t) {
      ++word_freq[c];
    }

    string window = "";
    int matched_count = 0;
    int window_size = s.length() + 1;
    int win_start = 0;
    int win_end = 0;

    while (win_start < s.length() && win_end <= s.length()) {
      if (matched_count == t.length()) {
        int cur_window_size = win_end - win_start;
        // Update global min.
        if (cur_window_size < window_size) {
          window_size = cur_window_size;
          window = s.substr(win_start, cur_window_size);
        }

        //
        int idx = s[win_start];
        --window_freq[idx];
        if (window_freq[idx] < word_freq[idx]) {
          --matched_count;
        }
        ++win_start;

        while (win_start < s.length() && word_freq[s[win_start]] == 0) {
          // Move win_start to the second matched char in current window.
          ++win_start;
        }
      } else if (win_end < s.length()) {
        int idx = s[win_end];
        ++window_freq[idx];
        if (window_freq[idx] <= word_freq[idx]) {
          ++matched_count;
        }
        ++win_end;
      } else {
        break;
      }
    }

    return window;
  }
};


int main() {
  Solution sol;
  //string window = sol.minWindow("ADOBECODEBANC", "ABC");
  //string window = sol.minWindow("AB", "A");
  string window = sol.minWindow("AB", "B");
  printf("Windows: %s\n", window.c_str());
}
