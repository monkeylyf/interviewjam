/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode merge k sorted lists
 */

#include <stdio.h>
#include <vector>

using std::vector;


struct ListNode {
  int val;
  ListNode *next;
  explicit ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
 public:
  /*
   * A naive merge strategy is merge #1 and #2 first then first the result of
   * it with #3, then merge the result of previous one with #4 and go on.
   *
   * Assuming each list has the same length k.
   * The number of nodes need to be traversed is 2k + 3k + ... + nk =
   * (n + 2)*(n - 1) / 2 * k =>
   * Time complexity O(kn^2)
   *
   * Approach two:
   * Merge #1 and #2, #3 and #4, #5 and #6... After done with one iteration, merge
   * merge result of #1 and #2 with the one of #3 and #4...
   * The number of nodes need to be traversed is kn + kn ... + kn repeating lgn time
   * because it's bacisally divide and conquer so every iteration number of lists will
   * be reduce to half =>
   * Time complexity O(knlgn)
   *
   * Obviously the second approach prevails in terms of time complexity.
   */
  ListNode* mergeKLists(vector<ListNode*>& lists) {
    if (lists.size() == 0) {
      return NULL;
    }

    ListNode* merged = NULL;

    while (lists.size() > 1) {
        vector<ListNode*> to_be_merged {};

        int i = 0;
        while (i + 1 < lists.size()) {
          ListNode* merged = mergeTwoSortedLists(lists.at(i), lists.at(i + 1));
          to_be_merged.push_back(merged);
          i += 2;
        }

        // Check odd.
        if (i == lists.size() - 1) {
          to_be_merged.push_back(lists.at(i));
        }

        lists = to_be_merged;
    }

    return lists.at(0);
  }

 private:
  ListNode* mergeTwoSortedLists(ListNode* l1, ListNode* l2) {
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

  ListNode* head = new ListNode(0);
  vector<ListNode*> lists {head};
  sol.mergeKLists(lists);
}
