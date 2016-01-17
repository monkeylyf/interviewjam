/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode maximum depth of binary tree
 */

#include <stdio.h>
#include <algorithm>

/**
 * Definition for a binary tree node.
 */
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
 public:
  int maxDepth(TreeNode* root) {
    if (root == NULL) {
      return 0;
    } else {
      int left_depth = maxDepth(root->left);
      int right_depth = maxDepth(root->right);
      return std::max(left_depth, right_depth) + 1;
    }
  }
};


int main() {
  Solution sol;

  TreeNode* root = new TreeNode(1);
  root->left = new TreeNode(1);

  printf("Depth: %d\n", sol.maxDepth(root));
}
