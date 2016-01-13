/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode remove duplicates from sorted list II
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
 /**
  * 1 -> 2 -> 2 -> 3 -> 3 -> 4 -> NULL
  * dummy -> 1 -> 2 -> 2 -> 3 -> 3 -> 4 -> NULL
  *  s/c
  *   s      c
  *         s/c
  *          s    c
  *          s         c
  *
  */
 public:
  ListNode* deleteDuplicates(ListNode* head) {
    if (head == NULL) {
      return head;
    }

    // Create dummy head node.
    ListNode dummy = ListNode(-1);
    dummy.next = head;

    ListNode* start = &dummy;
    ListNode* cursor = &dummy;

    while (cursor->next != NULL) {
      if (cursor->next->val == start->next->val) {
        // Same val, keep moving.
        cursor = cursor->next;
      } else {
        if (start->next == cursor) {
          // Distinct val with one node distance.
          start = start->next;
        } else {
          //  Dedup.
          start->next = cursor->next;
        }
      }
    }
    // Last check. The last range might not get handled because loop ends at
    // cursor->next == NULL.
    if (start->next != cursor) {
      start->next = NULL;
    }

    return dummy.next;
  }
};


int main() {
  Solution sol;

  ListNode* head = new ListNode(1);
  ListNode* n = new ListNode(1);
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

  head = sol.deleteDuplicates(head);

  printf("After:\n");
  if (head != NULL) {
    head->printAll();
  } else {
    printf("head is NULL\n");
  }
}
