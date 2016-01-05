/*
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode next permutation
 */


#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  void nextPermutation(vector<int>& nums) {
    int len = nums.size();

    int i = len - 1;
    while (i > 0 && nums.at(i - 1) >= nums.at(i)) {
      --i;
    }

    int j = len - 1;
    if (i > 0) {
      while (j > i && nums.at(i - 1) >= nums.at(j)) {
        --j;
      }
      swap(&nums, i - 1, j);
    }

    int head = i;
    int tail = len - 1;
    while (head < tail) {
      swap(&nums, head, tail);
      ++head;
      --tail;
    }
  }

  void swap(vector<int>* nums, int i, int j) {
    int tmp = nums->at(i);
    (*nums)[i] = nums->at(j);
    (*nums)[j] = tmp;
  }
};


void printVector(const vector<int>& nums) {
  for (int val : nums) {
    printf("%d ", val);
  }
  printf("\n");
}


int main() {
  Solution sol;

  vector<int> nums {1, 2, 3, 4};
  int i = 40;
  printVector(nums);
  while (i >= 0) {
    --i;
    sol.nextPermutation(nums);
    printVector(nums);
  }
}
