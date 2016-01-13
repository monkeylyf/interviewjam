/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode remove duplicates from sorted list
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
  ListNode* deleteDuplicates(ListNode* head) {
    if (head == NULL) {
      return NULL;
    }
    ListNode* cursor = head->next;
    ListNode* dedup_cursor = head;

    while (cursor != NULL) {
      if (cursor->val != dedup_cursor->val)  {
        dedup_cursor->next->val = cursor->val;
        dedup_cursor = dedup_cursor->next;
      }
      cursor = cursor->next;
    }
    // Unlink.
    dedup_cursor->next = NULL;
    return head;
  }
};


int main() {
  Solution sol;

  ListNode* head = new ListNode(1);
  ListNode* n = new ListNode(2);
  ListNode* nn = new ListNode(2);
  ListNode* nnn = new ListNode(3);
  ListNode* nnnn = new ListNode(3);
  ListNode* nnnnn = new ListNode(4);

  head->next = n;
  head->next->next = nn;
  head->next->next->next = nnn;
  head->next->next->next->next = nnnn;
  head->next->next->next->next->next = nnnnn;

  printf("Before:\n");
  head->printAll();

  sol.deleteDuplicates(head);

  printf("After:\n");
  head->printAll();
}
