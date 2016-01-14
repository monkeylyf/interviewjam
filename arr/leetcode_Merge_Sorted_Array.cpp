/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode merge sorted array
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  void merge(vector<int>& nums1, int m, const vector<int>& nums2, int n) {
    // Length to last idx.
    int i = m - 1;
    int j = n - 1;

    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[i + j + 1] = nums1[i];
        --i;
      } else  {
        nums1[i + j + 1] = nums2[j];
        --j;
      }
    }

    while (j >= 0) {
      nums1[j] = nums2[j];
      --j;
    }
  }
};


int main() {
  Solution sol;

  vector<int> nums1 {2, 2, 3, 6, 8, 0, 0, 0, 0, 0, 0, 0};
  vector<int> nums2 {1, 2, 3, 5, 5};

  sol.merge(nums1, 5, nums2, nums2.size());

  for (int val : nums1)  {
    printf("%d ", val);
  }
  printf("\n");
}
