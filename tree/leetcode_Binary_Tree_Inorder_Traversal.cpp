/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode binary tree inorder traversal
 */

#include <stdio.h>
#include <vector>

using std::vector;


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
  vector<int> inorderTraversal(TreeNode* root) {
    vector<int> order;
    inorder(root, &order);
    return order;
  }

  void inorder(TreeNode* root, vector<int>* order) {
    if (root == NULL) {
      return;
    } else {
      inorder(root->left, order);
      order->push_back(root->val);
      inorder(root->right, order);
    }
  }
};


int main() {
  Solution sol;
  // Don't bother to test this because if it fails for real, I'd quit my job.
}
