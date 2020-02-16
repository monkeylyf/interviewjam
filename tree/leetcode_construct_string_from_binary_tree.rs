/**
 * You need to construct a string consists of parenthesis and integers from a
 * binary tree with the preorder traversing way.
 *
 * The null node needs to be represented by empty parenthesis pair "()". And you
 * need to omit all the empty parenthesis pairs that don't affect the one-to-one
 * mapping relationship between the string and the original binary tree.
 *
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * Output: "1(2(4))(3)"
 *
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * Output: "1(2()(4))(3)"
 *
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one
 * mapping relationship between the input and the output.
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
    assert_eq!("1(2()(4))(3)", Solution::tree2str(Some(Rc::new(RefCell::new(root)))));
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
    pub fn tree2str(t: Option<Rc<RefCell<TreeNode>>>) -> String {
        let mut acc: String = "".to_string();
        if let Some(root) = t {
            Solution::recurive(&root, &mut acc);
        }
        return acc;
    }

    fn recurive(node: &Rc<RefCell<TreeNode>>, acc: &mut String) {
        let n: &Ref<TreeNode> = &node.borrow();
        acc.push_str(&n.val.to_string());
        if let (Some(left), Some(right)) = (&n.left, &n.right) {
            acc.push_str("(");
            Solution::recurive(left, acc);
            acc.push_str(")");
            acc.push_str("(");
            Solution::recurive(right, acc);
            acc.push_str(")");
        } else if let Some(left) = &n.left {
            acc.push_str("(");
            Solution::recurive(left, acc);
            acc.push_str(")");
        } else if let Some(right) = &n.right {
        // TODO: find out why borrow check fails for the following two lines.
        //} else if n.right.is_some() {
        //    let right = &n.right.unwrap();
            acc.push_str("()(");
            Solution::recurive(right, acc);
            acc.push_str(")");
        } else {
            // Do nothing.
        }
    }
}
