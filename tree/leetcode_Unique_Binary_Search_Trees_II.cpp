/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode unique binary search trees II
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
  vector<TreeNode*> generateTrees(int n) {
    if (n == 0) {
      return vector<TreeNode*>();
    } else {
      return generateTreesRecursive(1, n);
    }
  }

  vector<TreeNode*> generateTreesRecursive(int start, int end) {
    vector<TreeNode*> container;
    if (start > end) {
      // NULL node.
      container.push_back(NULL);
    } else if (start == end) {
      // Leaf.
      container.push_back(new TreeNode(start));
    } else {
      for (int i = start; i <= end; ++i) {
        for (TreeNode* left : generateTreesRecursive(start, i - 1)) {
          for (TreeNode* right : generateTreesRecursive(i + 1, end)) {
            TreeNode* node = new TreeNode(i);
            node->left = left;
            node->right = right;
            container.push_back(node);
          }
        }
      }
    }

    return container;
  }
};


int main() {
  Solution sol;

  vector<TreeNode*> container = sol.generateTrees(1);
}
