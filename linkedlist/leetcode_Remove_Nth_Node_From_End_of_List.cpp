/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode remove nth node from end of list
 */

#include <stdio.h>


struct ListNode {
  int val;
  ListNode *next;
  explicit ListNode(int x) : val(x), next(NULL) {}
};


void printLinkedList(ListNode* head) {
  while (head != NULL) {
    printf("%d -> ", head->val);
    head = head->next;
  }
  printf("NULL\n\n");
}


class Solution {
 public:
  ListNode* removeNthFromEnd(ListNode* head, int n) {
    if (head == NULL) {
      return head;
    }

    ListNode* end = head;
    bool largerThanLength = false;

    // Move pointer to the position that the distance between head and this ptr
    // is given length. Move with best effort to handle the case that n might
    // be larger than the lenght of this linkedlist.
    while (!largerThanLength && n > 1) {
      end = end->next;
      largerThanLength = end == NULL;
      --n;
    }

    if (largerThanLength) {
      // If n is larger than length, do nothing.
      return head;
    }

    // Create dummy node to attach to the beginning.
    ListNode* dummy = new ListNode(0);
    ListNode* start = dummy;
    dummy->next = head;

    // Move end to the last ListNode.
    while (end->next != NULL) {
      end = end->next;
      start = start->next;
    }

    // Unlink start->next;
    start->next = start->next->next;
    // Well since the destructor of ListNode is undefined, it does nothing.
    delete start;

    return dummy->next;
  }
};


int main() {
  Solution sol;

  ListNode* head = new ListNode(1);
  ListNode* next = new ListNode(2);
  ListNode* nnext = new ListNode(3);
  head->next = next;
  next->next = nnext;

  printf("Before:\n");
  printLinkedList(head);

  ListNode*res = sol.removeNthFromEnd(head, 4);
  printf("After:\n");
  printLinkedList(res);
}
