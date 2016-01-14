/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode reverse linked list.
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
  ListNode* reverseList(ListNode* head) {
    ListNode* cursor = NULL;
    while (head != NULL) {
      ListNode* next = head->next;
      head->next = cursor;
      cursor = head;
      head = next;
    }
    return cursor;
  }
};


int main() {
  ListNode* head = new ListNode(1);
  ListNode* n = new ListNode(2);
  ListNode* nn = new ListNode(3);
  ListNode* nnn = new ListNode(4);
  ListNode* nnnn = new ListNode(5);

  head->next = n;
  head->next->next = nn;
  head->next->next->next = nnn;
  head->next->next->next->next = nnnn;

  head->printAll();
  Solution sol;
  head = sol.reverseList(head);
  head->printAll();
}
