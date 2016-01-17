/**
 * Copyright 2016
 * author: madarfacar
 *
 * binary tree zigzag level order traversal
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
  vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
    vector<vector<int>> levels;
    if (root == NULL) {
      return levels;
    }

    vector<TreeNode*> q {root};
    vector<TreeNode*> n;
    vector<int> level;
    bool zigzag = false;

    while (!q.empty()) {
      TreeNode* node = q.back();
      q.pop_back();
      level.push_back(node->val);
      if (!zigzag) {
        if (node->left != NULL) {
          n.push_back(node->left);
        }
        if (node->right != NULL) {
          n.push_back(node->right);
        }
      } else {
        if (node->right != NULL) {
          n.push_back(node->right);
        }
        if (node->left != NULL) {
          n.push_back(node->left);
        }
      }

      if (q.empty()) {
        if (!level.empty()) {
          levels.push_back(level);
          level = vector<int> ();
        }
        q = n;
        n = vector<TreeNode*> ();
        zigzag = !zigzag;
      }
    }
    return levels;
  }
};


int main() {
  Solution sol;

  TreeNode* head = new TreeNode(1);
  head->left = new TreeNode(2);
  head->right = new TreeNode(3);
  head->left->left = new TreeNode(4);
  head->left->right = new TreeNode(5);
  head->right->left = new TreeNode(6);
  head->right->right = new TreeNode(7);

  vector<vector<int>> levels = sol.zigzagLevelOrder(head);

  for (const vector<int> level : levels) {
    for (int val : level) {
      printf("%d ", val);
    }
    printf("\n");
  }
}
