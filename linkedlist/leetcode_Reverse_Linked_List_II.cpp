/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode reverse linked list II
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
  ListNode* reverseBetween(ListNode* head, int m, int n) {
    if (head == NULL) {
      return head;
    }

    ListNode dummy = ListNode(-1);
    dummy.next = head;

    ListNode* seg_prev = &dummy;
    ListNode* seg_end = &dummy;

    // Move seg_end til the distance between seg_pre and seg_end is n - m.
    int length = n - m + 1;
    while (length > 0) {
      seg_end = seg_end->next;
      --length;
    }

    // Move seg_prev/seg_end to the right place.
    while (m > 1) {
      seg_end = seg_end->next;
      seg_prev = seg_prev->next;
      --m;
    }

    // Save pointer before unlinking.
    ListNode* seg_head = seg_prev->next;
    ListNode* seg_next = seg_end->next;

    // Unlink the part that needs to be reversed.
    seg_prev->next = NULL;
    seg_end->next = NULL;

    ListNode* new_head = reverseList(seg_head);

    // Link.
    seg_prev->next = new_head;
    seg_head->next = seg_next;

    return dummy.next;
  }

 private:
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

  printf("Before:\n");
  head->printAll();
  Solution sol;
  head = sol.reverseBetween(head, 2, 4);
  printf("After:\n");
  head->printAll();
}

