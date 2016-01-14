/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode rotate list
 */

#include <stdio.h>

/**
 * Definition for singly-linked list.
 */
struct ListNode {
  int val;
  ListNode* next;
  ListNode(int x) : val(x), next(NULL) {}

  void printAll() {
    printf("%d -> ", val);
    ListNode* cur = next;
    while (cur) {
      printf("%d -> ", cur->val);
      cur = cur->next;
    }
    printf("NULL\n");
  }
};


class Solution {
 public:
  ListNode* rotateRight(ListNode* head, int k) {
    if (head == NULL) {
      return head;
    }
    int length = get_length(head);
    k = k % length;
    if (k == 0) {
      return head;
    }

    ListNode* start = head;
    ListNode* end = head;
    while (k > 0) {
      end = end->next;
      --k;
    }

    while (end->next != NULL) {
      start = start->next;
      end = end->next;
    }

    ListNode* rotated_head = start->next;
    start->next = NULL;
    end->next = head;

    return rotated_head;
  }

  int get_length(ListNode* head) {
    int length = 0;
    while (head != NULL) {
      head = head->next;
      ++length;
    }
    return length;
  }
};


int main() {
  ListNode head (1);
  ListNode a (2);
  head.next = &a;
  ListNode b (3);
  a.next = &b;
  ListNode c (4);
  b.next = &c;
  ListNode d (5);
  c.next = &d;
  Solution sol;

  ListNode* rotated_head = sol.rotateRight(&head, 2);
  rotated_head->printAll();
}
