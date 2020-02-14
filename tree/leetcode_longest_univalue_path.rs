/**
 * Given a binary tree, find the length of the longest path where each node in
 * the path has the same value. This path may or may not pass through the root.
 *
 * The length of path between two nodes is represented by the number of edges
 * between them.
 *
 * Example 1:
 *
 * Input:
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output: 2
 *
 * Example 2:
 * Input:
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output: 2
 *
 * Note: The given binary tree has not more than 10000 nodes. The height of the
 * tree is not more than 1000.
 */

use std::cell::RefCell;
use std::cmp::max;
use std::rc::Rc;

fn main() {
    let root = Some(Rc::new(RefCell::new(TreeNode::new(1))));
    assert_eq!(0, Solution::longest_univalue_path(root));
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

struct Solution {
}

impl Solution {
    pub fn longest_univalue_path(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        if let Some(r) = root {
            let status: (i32, i32) = Solution::longest(&r);
            return status.0 - 1;
        } else {
            return 0;
        }
    }

    fn longest(node: &Rc<RefCell<TreeNode>>) -> (i32, i32) {
        let n = &node.borrow();
        let mut both_side: i32 = 0;
        let mut one_side_max: i32 = 0;
        let mut local_max: i32 = 0;
        if let Some(left) = &n.left {
            let left_status = Solution::longest(left);
            let l = &left.borrow();
            if l.val == n.val {
                one_side_max = max(one_side_max, left_status.1);
                both_side += left_status.1;
            }
            local_max = max(local_max, left_status.0);
        }

        if let Some(right) = &n.right {
            let right_status = Solution::longest(right);
            let r = &right.borrow();
            if r.val == n.val {
                one_side_max = max(one_side_max, right_status.1);
                both_side += right_status.1;
            }
            local_max = max(local_max, right_status.0);
        }
        return (max(local_max, both_side + 1), one_side_max + 1);
    }
}
