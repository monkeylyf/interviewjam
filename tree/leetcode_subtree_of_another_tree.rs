/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */

use std::rc::Rc;
use std::cell::Ref;
use std::cell::RefCell;

fn main() {
    let mut node1 = TreeNode::new(4);
    node1.left = Some(Rc::new(RefCell::new(TreeNode::new(1))));
    node1.right = Some(Rc::new(RefCell::new(TreeNode::new(2))));
    let root1 = Some(Rc::new(RefCell::new(node1)));

    let mut node2 = TreeNode::new(4);
    node2.left = Some(Rc::new(RefCell::new(TreeNode::new(1))));
    node2.right = Some(Rc::new(RefCell::new(TreeNode::new(2))));
    let root2 = Some(Rc::new(RefCell::new(node2)));

    assert!(Solution::is_same_tree(&root1, &root2));
    assert!(Solution::is_subtree(root1, root2));
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
    pub fn is_subtree(s: Option<Rc<RefCell<TreeNode>>>, t: Option<Rc<RefCell<TreeNode>>>) -> bool {
        Solution::recursive(&s, &t)
    }

    fn recursive(s: &Option<Rc<RefCell<TreeNode>>>, t: &Option<Rc<RefCell<TreeNode>>>) -> bool {
        if let (Some(ss), Some(tt)) = (s, t) {
            let sss: Ref<TreeNode> = ss.borrow();
            let ttt: Ref<TreeNode> = tt.borrow();
            if sss.val == ttt.val &&
                Solution::is_same_tree(&sss.left, &ttt.left) &&
                Solution::is_same_tree(&sss.right, &ttt.right) {
                return true
            } else {
                return Solution::recursive(&sss.left, t) || Solution::recursive(&sss.right, t);
            }
        } else {
            return false;
        }
    }

    fn is_same_tree(s: &Option<Rc<RefCell<TreeNode>>>, t: &Option<Rc<RefCell<TreeNode>>>) -> bool {
        if let (Some(ss), Some(tt)) = (s, t) {
            let sss: Ref<TreeNode> = ss.borrow();
            let ttt: Ref<TreeNode> = tt.borrow();
            return sss.val == ttt.val &&
                Solution::is_same_tree(&sss.left, &ttt.left) &&
                Solution::is_same_tree(&sss.right, &ttt.right);
        } else if let (None, None) = (s, t) {
            return true;
        } else {
            return false;
        }
    }
}
