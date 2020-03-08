/**
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house
 * has one and only one parent house. After a tour, the smart thief realized
 * that "all houses in this place forms a binary tree". It will automatically
 * contact the police if two directly-linked houses were broken into on the same
 * night.
 *
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */


use std::cmp::max;
use std::rc::Rc;
use std::cell::Ref;
use std::cell::RefCell;

fn main() {
}

// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
  pub val: i32,
  pub left: Option<Rc<RefCell<TreeNode>>>,
  pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
  #[inline]
  pub fn new(val: i32) -> Self {
    TreeNode {
      val,
      left: None,
      right: None
    }
  }
}

struct Solution {}

impl Solution {
    pub fn rob(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let (inclusive, exclusive) = Self::recursive(&root);
        return max(inclusive, exclusive);
    }

    fn recursive(root: &Option<Rc<RefCell<TreeNode>>>) -> (i32, i32) {
        if let Some(node) = root {
            let n: Ref<TreeNode> = node.borrow();
            let (left_inclusive, left_exclusive) = Self::recursive(&n.left);
            let (right_inclusive, right_exclusive) = Self::recursive(&n.right);

            return (n.val + left_exclusive + right_exclusive,
                    max(left_exclusive, left_inclusive) + max(right_exclusive, right_inclusive));
        } else {
            return (0, 0);
        }
    }
}
