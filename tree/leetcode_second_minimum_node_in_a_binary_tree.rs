/**
 * Given a non-empty special binary tree consisting of nodes with the
 * non-negative value, where each node in this tree has exactly two or zero
 * sub-node. If the node has two sub-nodes, then this node's value is the
 * smaller value among its two sub-nodes. More formally, the property
 * root.val = min(root.left.val, root.right.val) always holds.
 *
 * Given such a binary tree, you need to output the second minimum value in the
 * set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 * Input:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *
 * Example 2:
 * Input:
 *     2
 *    / \
 *   2   2
 *
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 */

use std::rc::Rc;
use std::cell::Ref;
use std::cell::RefCell;

fn main() {
    let mut root = TreeNode::new(2);
    root.left = Some(Rc::new(RefCell::new(TreeNode::new(2))));

    let mut right = TreeNode::new(5);
    right.left = Some(Rc::new(RefCell::new(TreeNode::new(5))));
    right.right = Some(Rc::new(RefCell::new(TreeNode::new(7))));
    root.right = Some(Rc::new(RefCell::new(right)));

    assert_eq!(5, Solution::find_second_minimum_value(Some(Rc::new(RefCell::new(root)))));
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
    pub fn find_second_minimum_value(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        if let Some(r) = root {
            let mut min: Option<i32> = None;
            let mut second_min: Option<i32> = None;
            let mut level: Vec<Rc<RefCell<TreeNode>>> = vec![Rc::clone(&r)];
            while let Some(node) = level.pop() {
                let n: Ref<TreeNode> = node.borrow();
                let value: i32 = n.val;
                if min.is_none() {
                    min = Some(value);
                } else if value < min.unwrap() {
                    second_min = min;
                    min = Some(value);
                } else if value != min.unwrap() &&
                    (second_min.is_none() || value < second_min.unwrap()) {
                    second_min = Some(value);
                } else {
                    // Do nothing.
                }
                if let Some(left) = &n.left {
                    level.push(Rc::clone(&left));
                }
                if let Some(right) = &n.right {
                    level.push(Rc::clone(&right));
                }
            }
            return second_min.unwrap_or(-1);
        } else {
            return -1;
        }
    }
}
