/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode group anagrams
 */

#include <stdio.h>
#include <unordered_map>
#include <string>
#include <vector>

using std::string;
using std::unordered_map;
using std::vector;


class Solution {
 public:
  vector<vector<string>> groupAnagrams(vector<string>& strs) {
    unordered_map<string, vector<string>> mapping;

    for (string str: strs) {
      vector<char> char_vector (str.begin(), str.end());
      sort(char_vector.begin(), char_vector.end());

      string sorted_str (char_vector.begin(), char_vector.end());

      auto it = mapping.find(sorted_str);
      if (it == mapping.end()) {
        mapping[sorted_str] = vector<string> {str};
      } else {
        it->second.push_back(str);
      }
      //char str_arr[] = str.c_str();
    }

    vector<vector<string>> groups;

    for (auto it = mapping.begin(); it != mapping.end(); ++it) {
      sort(it->second.begin(), it->second.end());
      groups.push_back(it->second);
    }

    return groups;
  }
};


int main() {
  Solution sol;

  vector<string> strs {"eat", "tea", "tan", "ate", "nat", "bat"};
  vector<vector<string>> groups = sol.groupAnagrams(strs);
  for (const vector<string> group : groups) {
    for (string str : group) {
      printf("%s ", str.c_str());
    }
    printf("\n");
  }
}
