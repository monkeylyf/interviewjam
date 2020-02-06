/**
 * Given a non-empty, singly linked list with head node head, return a middle
 * node of linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is
 * [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and
 * ans.next.next.next = NULL.
 *
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second
 * one.
 *
 * Note:
 * The number of nodes in the given list will be between 1 and 100.
 */

fn main() {
}

struct Solution {}

// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
  }
}

impl Solution {
    pub fn middle_node(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut one: &Option<Box<ListNode>> = &head;
        let mut two: &Option<Box<ListNode>> = &head;
        while two.is_some() && two.as_ref().unwrap().next.is_some() {
            one = &one.as_ref().unwrap().next;
            two = &two.as_ref().unwrap().next.as_ref().unwrap().next;
        }
        return one.clone();
    }
}
