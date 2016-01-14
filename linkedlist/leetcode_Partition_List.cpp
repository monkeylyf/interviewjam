/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode partition list
 */

#include <stdio.h>

/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}

    void printAll() {
      printf("%d -> ", val);
      ListNode* cursor = next;
      while (cursor != NULL) {
        printf("%d -> ", cursor->val);
        cursor = cursor->next;
      }
      printf("NULL\n");
    }
};


class Solution {
 public:
  ListNode* partition(ListNode* head, int x) {
    if (head == NULL) {
      return head;
    }

    ListNode larger = ListNode(-1);
    ListNode smaller = ListNode(-1);
    smaller.next = head;

    ListNode* larger_cursor = &larger;
    ListNode* smaller_cursor = &smaller;

    while (smaller_cursor->next != NULL) {
      if (smaller_cursor->next->val >= x) {
        // Move to larger.
        larger_cursor->next = smaller_cursor->next;
        larger_cursor = larger_cursor->next;
        // Remove from smaller.
        smaller_cursor->next = smaller_cursor->next->next;
        larger_cursor->next = NULL;  // Do this after remove it from smaller.
      } else {
        smaller_cursor = smaller_cursor->next;
      }
    }
    smaller_cursor->next = larger.next;

    return smaller.next;
  }
};


int main() {
  ListNode* head = new ListNode(1);
  ListNode* n = new ListNode(4);
  ListNode* nn = new ListNode(3);
  ListNode* nnn = new ListNode(2);
  ListNode* nnnn = new ListNode(5);
  ListNode* nnnnn = new ListNode(2);

  head->next = n;
  head->next->next = nn;
  head->next->next->next = nnn;
  head->next->next->next->next = nnnn;
  head->next->next->next->next->next = nnnnn;
  printf("Before:\n");
  head->printAll();

  Solution sol;
  head = sol.partition(head, 3);

  printf("After:\n");
  head->printAll();
}
