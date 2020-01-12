/**
 * Given head which is a reference node to a singly-linked list. The value of
 * each node in the linked list is either 0 or 1. The linked list holds the
 * binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * Example 1:
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 *
 * Example 2:
 * Input: head = [0]
 * Output: 0
 *
 * Example 3:
 * Input: head = [1]
 * Output: 1
 *
 * Example 4:
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 *
 * Example 5:
 * Input: head = [0,0]
 * Output: 0
 *
 * Constraints:
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */

fn main() {
    let mut head: ListNode = ListNode::new(1i32);
    let mut next_head: ListNode = ListNode::new(0i32);
    next_head.next = Option::Some(Box::new(ListNode::new(1i32)));
    head.next = Option::Some(Box::new(next_head));
    assert_eq!(5, Solution::get_decimal_value(Option::Some(Box::new(head))));
}

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

struct Solution {}

impl Solution {
    /* https://stackoverflow.com/questions/54027704/how-to-use-two-pointers-to-iterate-a-linked-list-in-rust */
    pub fn get_decimal_value(head: Option<Box<ListNode>>) -> i32 {
        let mut h: &Option<Box<ListNode>> = &head;
        let mut base: i32 = 1;
        let mut val: i32 = 0;
        while h.is_some() {
            base *= 2;
            h = &(h.as_ref().unwrap().next);
        }
        base /= 2;

        h = &head;
        while h.is_some() {
            val += base * h.as_ref().unwrap().val;
            h = &(h.as_ref().unwrap().next);
            base /= 2;
        }
        return val;
    }
}

/*
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        if not head:
            return 0
        base = 1
        cur = head
        while cur:
            base *= 2
            cur = cur.next
        base //= 2

        val = 0
        while head:
            val += base * head.val
            base //= 2
            head = head.next
        return val
 */
