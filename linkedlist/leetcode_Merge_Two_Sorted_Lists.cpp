/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode merge two sorted lists
 */

#include <stdio.h>
#include <memory>

using std::auto_ptr;


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
  printf("NULL\n");
}


class Solution {
 public:
  ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
    if (l1 == NULL) {
      return l2;
    }

    if (l2 == NULL) {
      return l1;
    }

    ListNode dummy(0);
    ListNode* cursor = &dummy;

    while (l1 != NULL && l2 !=NULL) {
      if (l1->val > l2->val) {
        cursor->next = l2;
        l2 = l2->next;
      } else {
        cursor->next = l1;
        l1 = l1->next;
      }
      cursor = cursor->next;
    }

    if (l1 != NULL) {
      cursor->next = l1;
    } else {
      cursor->next = l2;
    }

    return dummy.next;
  }
};



int main() {
  Solution sol;
  ListNode* l1 = new ListNode(1);
  ListNode* next1 = new ListNode(3);
  ListNode* nnext1 = new ListNode(5);
  l1->next = next1;
  next1->next = nnext1;

  ListNode* l2 = new ListNode(2);
  ListNode* next2 = new ListNode(4);
  ListNode* nnext2 = new ListNode(6);
  l2->next = next2;
  next2->next = nnext2;

  printf("Before:\n");
  printLinkedList(l1);
  printLinkedList(l2);

  printf("After:\n");
  ListNode* res = sol.mergeTwoLists(l1, l2);
  printLinkedList(res);
}
