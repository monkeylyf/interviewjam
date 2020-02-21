/**
 * Given a binary tree, return the sum of values of its deepest leaves.
 *
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 *
 * Constraints:
 *
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 */

use std::rc::Rc;
use std::cell::Ref;
use std::cell::RefCell;

fn main() {
    let mut root = TreeNode::new(1);
    let mut left = TreeNode::new(2);
    left.right = Some(Rc::new(RefCell::new(TreeNode::new(4))));
    root.left = Some(Rc::new(RefCell::new(left)));
    root.right = Some(Rc::new(RefCell::new(TreeNode::new(3))));
    assert_eq!(4, Solution::deepest_leaves_sum(Some(Rc::new(RefCell::new(root)))));
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

struct Solution { }

impl Solution {
    pub fn deepest_leaves_sum(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        if let Some(r) = root {
            let mut level: Vec<Rc<RefCell<TreeNode>>> = vec![Rc::clone(&r)];
            let mut next_level: Vec<Rc<RefCell<TreeNode>>> = vec![];
            let mut is_deepest: bool = false;

            while !is_deepest {
                for node in &level {
                    let n: Ref<TreeNode> = node.borrow();
                    if let Some(left) = &n.left {
                        next_level.push(Rc::clone(&left))
                    }
                    if let Some(right) = &n.right {
                        next_level.push(Rc::clone(&right))
                    }
                }

                if next_level.is_empty() {
                    is_deepest = true;
                } else {
                    level = next_level;
                    next_level = vec![];
                }
            }
            return level.iter().map(|x| x.borrow().val).sum();
        } else {
            return 0;
        }
    }
}

/*
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def deepestLeavesSum(self, root: TreeNode) -> int:
        if not root:
            return 0

        level = [root]
        next_level = []
        is_bfs_finished = False

        while not is_bfs_finished:
            for node in level:
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)

            if not next_level:
                is_bfs_finished = True
            else:
                level = next_level
                next_level = []
        return sum(n.val for n in level)
 */
