/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode symmetric tree
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
  bool isSymmetric(TreeNode* root) {
    if (root == NULL) {
      return true;
    } else {
      return isTwoTreeSymmetric(root->left, root->right);
    }
  }

  bool isTwoTreeSymmetric(TreeNode* left, TreeNode* right) {
    if (left == NULL && right == NULL) {
      return true;
    } else if (left != NULL && right == NULL) {
      return false;
    } else if (left == NULL && right != NULL) {
      return false;
    } else if (left->val != right->val) {
      return false;
    } else {
      return isTwoTreeSymmetric(left->left, right->right) &&
             isTwoTreeSymmetric(left->right, right->left);
    }
  }
};


int main() {
  Solution sol;
  // No testing.
}
