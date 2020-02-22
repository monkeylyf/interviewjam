/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
 */

use std::rc::Rc;
use std::cell::Ref;
use std::cell::RefCell;
use std::collections::HashMap;

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
    pub fn find_mode(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut count: HashMap<i32, i32> = HashMap::new();
        Solution::recursive(&root, &mut count);
        if let Some(max) = count.iter().map(|x| x.1).max() {
            count.iter().filter(|x| x.1 == max).map(|x| *x.0).collect()
        } else {
            vec![]
        }
    }

    fn recursive(option_node: &Option<Rc<RefCell<TreeNode>>>, count: &mut HashMap<i32, i32>) {
        if let Some(node) = option_node {
            let n: Ref<TreeNode> = node.borrow();
            *count.entry(n.val).or_insert(0) += 1;
            Solution::recursive(&n.left, count);
            Solution::recursive(&n.right, count);
        }
    }
}
