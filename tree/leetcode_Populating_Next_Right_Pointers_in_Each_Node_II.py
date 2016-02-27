"""Populating next right pointers in each node II
leetcode

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution
still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
"""


from collections import deque


# Definition for binary tree with next pointer.
class TreeLinkNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


class Solution(object):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        if not root:
            return
        queue = deque([root])
        count = 1

        while queue:
            node = queue.popleft()
            count -= 1
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
            if count == 0:
                i = 0
                while i < len(queue) - 1:
                    queue[i].next = queue[i + 1]
                    i += 1
                count = len(queue)


def main():
    sol = Solution()
    root = TreeLinkNode(1)
    sol.connect(root)


if __name__ == '__main__':
    main()
