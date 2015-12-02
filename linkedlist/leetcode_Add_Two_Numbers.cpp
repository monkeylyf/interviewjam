/**
 * Copyright 2015
 * Author: ouroboros
 *
 * Definition for singly-linked list.
 */

#include <stdio.h>
#include <vector>
#include <cassert>

using std::vector;

#define int_v vector<int>

struct ListNode {
  int val;
  ListNode *next;
  explicit ListNode(int x) : val(x), next(NULL) {}
};


ListNode* createLinkedList(const int_v &v) {
  if (v.size() == 0) {
    return NULL;
  }

  ListNode dummy(0);
  ListNode *ptr = &dummy;
  ListNode *ret = &dummy;

  for (int val : v) {
    ListNode *node = new ListNode(val);
    ptr->next = node;
    ptr = ptr->next;
  }

  return ret->next;
}


void destroyLinkedList(ListNode* head) {
  ListNode *next;
  while (head) {
    next = head->next;
    delete[] head;
    head = next;
  }
}


bool isSameLinkedList(ListNode* h1, ListNode* h2) {
  while (h1 && h2) {
    if (h1->val != h2->val) {
      return false;
    }

    h1 = h1->next;
    h2 = h2->next;
  }

  return !h1 && !h2;
}


void printList(ListNode *head) {
  while (head) {
    printf("%d -> ", head->val);
    head = head->next;
  }
  printf("NULL\n");
}


class Solution {
 public:
    ListNode* addTwoNumbers(ListNode *l1, ListNode *l2) {
      bool carry = false;

      ListNode dummy(0);
      ListNode *ptr = &dummy;
      ListNode *ret = &dummy;
      ListNode *cursor;
      ptr->next = cursor;

      while (l1 && l2) {
        int digit_sum = l1->val + l2->val + (carry ? 1 : 0);
        int val = digit_sum % 10;
        carry = digit_sum >= 10;

        ListNode *sum = new ListNode(val);
        ptr->next = sum;
        ptr = ptr->next;

        l1 = l1->next;
        l2 = l2->next;
      }

      ListNode *tail = (l1) ? l1 : l2;
      while (tail) {
        int digit_sum = tail->val + (carry ? 1 : 0);
        int val = digit_sum % 10;
        carry = digit_sum >= 10;
        ListNode *sum = new ListNode(val);
        ptr->next = sum;
        ptr = ptr->next;

        tail = tail->next;
      }

      if (carry) {
        ListNode *sum = new ListNode(1);
        ptr->next = sum;
        ptr = ptr->next;
      }

      return ret->next;
    }

    ListNode* reverseList(ListNode *head) {
      ListNode *prev = NULL;
      while (head) {
        ListNode *next = head->next;
        head->next = prev;
        prev = head;
        head = next;
      }
      return prev;
    }
};


void test(const int_v &num1, const int_v &num2, const int_v &expected) {
  ListNode *l1 = createLinkedList(num1);
  ListNode *l2 = createLinkedList(num2);
  ListNode *expected_l = createLinkedList(expected);

  Solution sol;
  ListNode *res = sol.addTwoNumbers(l1, l2);

  printList(expected_l);
  printList(res);
  if (!isSameLinkedList(res, expected_l)) {
    throw 1;
  } else {
    printf("Test passed\n");
  }

  destroyLinkedList(l1);
  destroyLinkedList(l2);
  destroyLinkedList(expected_l);
}


int main() {
  // Test case 1.
  int_v v1 {2, 4, 3};
  int_v v2 {5, 6, 4};
  int_v exp1 {7, 0, 8};
  test(v1, v2, exp1);

  // Test case 2.
  int_v v3 {1, 1, 1};
  int_v v4 {9, 9, 9};
  int_v exp2 {0, 1, 1, 1};
  test(v3, v4, exp2);

  // Test case 3.
  int_v v5 {9, 1, 6};
  int_v v6 {0};
  int_v exp3 {9, 1, 6};
  test(v5, v6, exp3);
}
