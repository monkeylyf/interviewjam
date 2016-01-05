/*
 * Copyright 2015
 * author: madarfacar
 *
 * leetcode substring with concatenation of all words.
 */

#include <stdio.h>
#include <queue>
#include <string>
#include <unordered_map>
#include <vector>

using std::queue;
using std::string;
using std::unordered_map;
using std::vector;


class Solution {
 public:
  vector<int> findSubstring(string s, vector<string>& words) {
    if (words.size() == 0) {
      throw 1;
    }
    vector<int> indexes;

    int step = words[0].length();
    int window_length = step * words.size();
    if (window_length > s.length()) {
      return indexes;
    }

    // Init first window counter.
    unordered_map<string, int> counter;
    for (string word : words) {
      ++counter[word];
    }

    for (int i = 0; i <= s.length() - window_length; ++i) {
      string substring = s.substr(i, window_length);
      unordered_map<string, int> mapping;
      bool is_same_map = true;
      int j = 0;
      // Instead of counting the whole substring, count one by one
      // for optimization.
      while (is_same_map && j <= substring.length() - step) {
        string word = substring.substr(j, step);
        auto it = counter.find(word);
        if (it == counter.end()) {
          is_same_map = false;
        } else {
          ++mapping[word];

          if (mapping[word] > counter[word]) {
            is_same_map = false;
          }
        }
        j += step;
      }
      if (is_same_map) {
        indexes.push_back(i);
      }

    }
    return indexes;
  }

  void printMap(unordered_map<string, int>* map_ptr) {
    if (map_ptr->empty()) {
      printf("Empty map\n");
    } else {
      for (auto it = map_ptr->begin(); it != map_ptr->end(); ++it) {
        printf("key; <%s> value: <%d>\n", it->first.c_str(), it->second);
      }
    }
    printf("\n");
  }
};


int main() {
  Solution sol;

  vector<string> words {"word","good","best","good"};
  vector<int> res = sol.findSubstring("wordgoodgoodgoodbestword", words);

  printf("Result:\n");
  for (int val : res) {
    printf("%d ", val);
  }
  printf("\n");
}
