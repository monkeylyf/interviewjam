/**
 * Copyright 2016
 * author: madarfacar
 *
 * binary tree level order traversal
 */

#include <stdio.h>
#include <queue>
#include <vector>

using std::queue;
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
  vector<vector<int>> levelOrder(TreeNode* root) {
    vector<vector<int>> levels;
    if (root == NULL) {
      return levels;
    }

    levels.push_back(vector<int> {root->val});

    queue<TreeNode*> q;
    q.push(root);
    vector<TreeNode*> n;

    while (!q.empty()) {
      TreeNode* node = q.front();
      q.pop();
      if (node->left != NULL) {
        n.push_back(node->left);
      }
      if (node->right != NULL) {
        n.push_back(node->right);
      }

      if (q.empty()) {
        if (!n.empty()) {
          vector<int> level;
          for (TreeNode* it : n) {
            level.push_back(it->val);
            q.push(it);
          }
          levels.push_back(level);
        }
        n = vector<TreeNode*> ();
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
  head->right->right = new TreeNode(5);

  vector<vector<int>> levels = sol.levelOrder(head);

  for (const vector<int> level : levels) {
    for (int val : level) {
      printf("%d ", val);
    }
    printf("\n");
  }
}
