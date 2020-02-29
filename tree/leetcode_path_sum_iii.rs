/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 *
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */

use std::rc::Rc;
use std::cell::Ref;
use std::cell::RefCell;
use std::collections::HashMap;

fn main() {
    let mut root = TreeNode::new(10);
    let mut left = TreeNode::new(5);
    let mut right = TreeNode::new(-3);

    let mut left_left = TreeNode::new(3);
    let mut left_right = TreeNode::new(2);

    left_left.left = Some(Rc::new(RefCell::new(TreeNode::new(3))));
    left_left.right = Some(Rc::new(RefCell::new(TreeNode::new(-2))));
    left_right.right = Some(Rc::new(RefCell::new(TreeNode::new(1))));
    left.right = Some(Rc::new(RefCell::new(left_right)));
    right.right = Some(Rc::new(RefCell::new(TreeNode::new(11))));
    left.left = Some(Rc::new(RefCell::new(left_left)));
    root.left = Some(Rc::new(RefCell::new(left)));
    root.right = Some(Rc::new(RefCell::new(right)));

    assert_eq!(3, Solution::path_sum(Some(Rc::new(RefCell::new(root))), 8));
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
    pub fn path_sum(root: Option<Rc<RefCell<TreeNode>>>, sum: i32) -> i32 {
        Self::recursive(&root, sum).0
    }

    fn recursive(optional_node: &Option<Rc<RefCell<TreeNode>>>, sum: i32) -> (i32, HashMap<i32, i32>) {
        let mut counter: HashMap<i32, i32> = HashMap::new();
        if let Some(node) = optional_node {
            let n: Ref<TreeNode> = node.borrow();
            let val: i32 = n.val;
            let mut paths: i32 = if val == sum { 1 } else { 0 };
            let (left_paths, left_counter) = Self::recursive(&n.left, sum);
            paths += left_paths;
            // Accumulate path from current node to left subtree.
            if let Some(l) = left_counter.get(&(sum - val)) {
                paths += l;
            }
            let (right_paths, right_counter) = Self::recursive(&n.right, sum);
            paths += right_paths;
            // Accumulate path from current node to right subtree.
            if let Some(r) = right_counter.get(&(sum - val)) {
                paths += r;
            }
            // NOTE: Not required. Though if the path can go any dirrection,
            // then accumulate path from left to current node, then to right subtree.
            // for (left_sum, left_frequence) in left_counter.iter() {
            //     let expected_right_sum: i32 = sum - left_sum;
            //     if let Some(right_frequence) = right_counter.get(&expected_right_sum) {
            //         paths += right_frequence * left_frequence;
            //     }
            // }
            // Merge left counter and right counter.
            for (left_sum, left_frequence) in left_counter.iter() {
                *counter.entry(left_sum + val).or_insert(0) += left_frequence;
            }
            for (right_sum, right_frequence) in right_counter.iter() {
                *counter.entry(right_sum + val).or_insert(0) += right_frequence;
            }
            *counter.entry(val).or_insert(0) += 1;
            return (paths, counter);
        } else {
            return (0, counter);
        }
    }
}
