"""Verify preorder serialization of a binary tree
leetcode

One way to serialize a binary tree is to use pre-oder traversal. When we
encounter a non-null node, we record the node's value. If it is a null node, we
record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string
"9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct
preorder traversal serialization of a binary tree. Find an algorithm without
reconstructing the tree.

Each comma separated value in the string must be either an integer or a
character '#' representing null pointer.

You may assume that the input format is always valid, for example it could
never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
"""


class Solution(object):

    NONE = '#'

    def isValidSerializationRec(self, preorder):
        """

        :type preorder: str
        :rtype: bool
        """
        def is_valid(idx, preorder):
            """"""
            if preorder[idx] == Solution.NONE:
                return idx + 1
            else:
                after_left = is_valid(idx + 1, preorder)
                return is_valid(after_left, preorder)

        nodes = preorder.split(',')
        try:
            # nodes should be all used to reconstruct
            return is_valid(0, nodes) == len(nodes)
        except IndexError:
            # Running out of node to recontruct. Invalid of course.
            return False

    def isValidSerialization(self, preorder):
        """For a valid bianry tree, when you introduce a node, another two
        empty node is introduced, as empty left/right child, as well. That
        means, for any valid binary tree, # of node + 1 must equal to # of
        emtpy node.

        :type preorder: str
        :rtype: bool
        """
        open_slots = 1
        for node in preorder.split(','):
            if not open_slots:
                # No open slots in middle of loop, meaning the current tree
                # is valid but there is more to fill.
                return False
            elif node == Solution.NONE:
                open_slots -= 1
            else:
                open_slots += 1
        return open_slots == 0  # All slots are filled.


def main():
    sol = Solution()
    assert sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")
    assert not sol.isValidSerialization("1,#")
    assert not sol.isValidSerialization("9,#,#,1")


if __name__ == '__main__':
    main()
