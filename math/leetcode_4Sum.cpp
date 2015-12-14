/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode foursome
 *
 */

#include <stdio.h>
#include <algorithm>
#include <set>
#include <unordered_map>
#include <vector>

using std::set;
using std::vector;
using std::unordered_map;


class MyPair {
 private:
  int first, second, first_idx, second_idx;

 public:
  MyPair(int f, int s, int f_idx, int s_idx) {
    first = f;
    second = s;
    first_idx = f_idx;
    second_idx = s_idx;
  }

  int sum() const { return first + second; }
  int getFirst() const { return first; }
  int getSecond() const { return second; }
  int getFirstIdx() const { return first_idx; }
  int getSecondIdx() const { return second_idx; }

  friend bool operator< (const MyPair& pair1, const MyPair& pair2);
};


bool operator< (const MyPair &pair1, const MyPair &pair2) {
  return pair1.sum() < pair2.sum();
}


void printMyPair(const vector<MyPair>& pairs) {
  for (const MyPair& pair : pairs) {
    printf("i: %d j: %d sum: %d\n", pair.getFirstIdx(), pair.getSecondIdx(), pair.sum());
  }
}


void printVector(const vector<int>& v) {
  for (int val : v) {
    printf("%d ", val);
  }
  printf("\n");
}


class Solution {
 public:
  /*
   * Breaking the problem down to 2Sum and each element is a pair.
   *
   * Time complexity: O(n^2) + O(2n^2lgn) + O(n^2)
   * Space complexity: O(n^2)
   *
   * This one did not pass due to TLE. I can understand this one has worse space
   * complexity but better time complexity...It appears that I am wrong, as
   * always but I don't know why.
   */
  vector<vector<int>> fourSumFailed(vector<int>& nums, int target) {
    vector<vector<int>> res;

    if (nums.size() < 4) {
      return res;
    }

    sort(nums.begin(), nums.end());

    vector<MyPair> pairs;
    for (int i = 0; i < nums.size() - 1; ++i) {
      for (int j = i + 1; j < nums.size(); ++j) {
        pairs.push_back(MyPair(nums.at(i), nums.at(j), i, j));
      }
    }

    // printf("Before sorining:\n");
    // printMyPair(pairs);

    sort(pairs.begin(), pairs.end());
    // printf("After sorining:\n");
    printMyPair(pairs);

    unordered_map<int, vector<MyPair>> mapping;
    for (MyPair pair : pairs) {
      int sum = pair.sum();
      auto iter = mapping.find(sum);
      if (iter != mapping.end()) {
        iter->second.push_back(pair);
      } else {
        vector<MyPair> v {pair};
        mapping[sum] = v;
      }
    }

    vector<int> pairSums;
    for (auto iter = mapping.begin(); iter != mapping.end(); ++iter) {
      pairSums.push_back(iter->first);
    }

    sort(pairSums.begin(), pairSums.end());

    for (int val : pairSums) {
      if (mapping.find(target - val) != mapping.end()) {
        if (val * 2 == target) {
          vector<MyPair> v = mapping[val];
          for (int i = 0; i < v.size() - 1; ++i) {
            for (int j = i + 1; j < v.size(); ++j) {
              MyPair p1 = v.at(i);
              MyPair p2 = v.at(j);
              if (!isIntersected(p1, p2)) {
                res.push_back(createCombination(p1, p2));
              }
            }
          }
        } else {
          vector<MyPair> v1 = mapping[val];
          vector<MyPair> v2 = mapping[target - val];
          for (MyPair p1 : v1) {
            for (MyPair p2 : v2) {
              if (!isIntersected(p1, p2)) {
                res.push_back(createCombination(p1, p2));
              }
            }
          }
        }
        mapping.erase(val);  // Avoid a/b and b/a.
      }
    }

    return res;
  }

  vector<int> createCombination(const MyPair& p1, const MyPair& p2) {
    vector<int> combination;
    if (p1.getFirst() <= p2.getSecond()) {
      combination = {p1.getFirst(), p1.getSecond(), p2.getFirst(), p2.getSecond()};
    } else {
      combination = {p2.getFirst(), p2.getSecond(), p1.getFirst(), p1.getSecond()};
    }

    return combination;
  }

  bool isIntersected(const MyPair& p1, const MyPair& p2) {
    return (p1.getFirstIdx() <= p2.getSecondIdx() && p2.getSecondIdx() <= p1.getSecondIdx()) ||
           (p1.getFirstIdx() <= p2.getFirstIdx() && p2.getFirstIdx() <= p1.getSecondIdx());
  }

  /*
   * Breaking the problem down to 2sum. Using set to dedup.
   *
   * Time complexity: O(nlgn) + O(n^3)
   * Space complexity: O(n)
   *
   */
  vector<vector<int> > fourSum(vector<int> &nums, int target) {
    sort(nums.begin(), nums.end());
    set<vector<int>> res;
    int n = nums.size();
    for (int i = 0; i < n - 3; ++i) {
      for (int j = i + 1; j < n - 2; ++j) {
        int head = j + 1;
        int tail = n - 1;

        while (head < tail) {
          int sum = nums[i] + nums[j] + nums[head] + nums[tail];
          if (sum == target) {
            vector<int> tmp {nums[i], nums[j], nums[head], nums[tail]};
            res.insert(tmp);
            ++head;
            --tail;
          } else if (sum < target) {
            ++head;
          } else {
            --tail;
          }
        }
      }
    }
    vector<vector<int>> ret(res.begin(), res.end());
    return ret;
  }
};


int main() {
  Solution sol;

  vector<int> nums;
  // vector<int> nums {1, 0, -1, 0, -2, 2};
  // vector<int> nums {-6, -8, -4, 1, 9, 7, 1, -10, 5, -9, -1, 3, 0, 7, 3};
  int target = -25;

  vector<vector<int>> res = sol.fourSum(nums, target);

  printf("Result:\n");
  for (auto v : res) {
    printVector(v);
  }
}
