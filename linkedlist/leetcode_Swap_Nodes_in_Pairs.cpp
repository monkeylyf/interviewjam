/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode swap nodes in pairs
 */


#include <stdio.h>


struct ListNode {
  int val;
  ListNode *next;
  explicit ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
 public:
  ListNode* swapPairs(ListNode* head) {
    ListNode dummy(0);
    ListNode* cursor = &dummy;
    cursor->next = head;

    while (cursor->next != NULL && cursor->next->next != NULL) {
      ListNode* cur = cursor->next;
      ListNode* next = cur->next;
      cur->next = next->next;
      next->next = cur;
      cursor->next = next;

      cursor = cur;
    }
    return dummy.next;
  }
};


int main() {
  Solution sol;
}
