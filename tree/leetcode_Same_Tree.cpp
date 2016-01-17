/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode same tree
 */

#include <stdio.h>

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
  bool isSameTree(TreeNode* p, TreeNode* q) {
    if (p == NULL && q == NULL) {
      return true;
    } else if (p == NULL && q != NULL) {
      return false;
    } else if (p != NULL && q == NULL) {
      return false;
    } else if (p->val != q->val) {
      return false;
    } else {
      return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }
  }
};


int main() {
  Solution sol;
  // No testing.
}
