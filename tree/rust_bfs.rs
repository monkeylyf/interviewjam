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
    pub fn bfs(root: Option<Rc<RefCell<TreeNode>>>) {
        if let Some(r) = root {
            let mut level: Vec<Rc<RefCell<TreeNode>>> = vec![Rc::clone(&r)];
            while let Some(node) = level.pop() {
                let n: Ref<TreeNode> = node.borrow();
                if let Some(left) = &n.left {
                    level.push(Rc::clone(&left));
                }
                if let Some(right) = &n.right {
                    level.push(Rc::clone(&right));
                }
            }
        }
    }
}

