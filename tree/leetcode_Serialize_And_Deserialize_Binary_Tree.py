"""Serialize and deserialize binary tree
leetcode

Serialization is the process of converting a data structure or object into a
sequence of bits so that it can be stored in a file or memory buffer, or
transmitted across a network connection link to be reconstructed later in the
same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no
restriction on how your serialization/deserialization algorithm should work.
You just need to ensure that a binary tree can be serialized to a string and
this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary
tree. You do not necessarily need to follow this format, so please be creative
and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your
serialize and deserialize algorithms should be stateless.
"""


class TreeNode(object):

    """Definition for a binary tree node."""

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __repr__(self):
        """"""
        return str(self.val)


class Codec:

    NULL = 'null'
    DELIM = ','

    def serialize(self, root):
        """Encodes a tree to a single string.

        Level order traversal from left to right. If next leve has at least
        one node, keep going.


        :type root: TreeNode
        :rtype: str
        """
        queue = [root]
        next_level = []
        container = []

        while len(queue) > 0:
            for node in queue:
                if node is None:
                    container.append(Codec.NULL)
                else:
                    next_level.append(node.left)
                    next_level.append(node.right)
                    container.append(str(node.val))
            if all(node is None for node in next_level):
                queue = []
            else:
                queue = next_level
                next_level = []

        return '[{}]'.format(Codec.DELIM.join(container))

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        Level order reconstruction from left to right. Decode
        the string into list of int value/None first.

        :type data: str
        :rtype: TreeNode
        """
        data = data[1:-1] # Strip '[' and ']'
        container = []
        for token in data.split(Codec.DELIM):
            try:
                container.append(int(token))
            except ValueError:
                container.append(None)

        if container[0] is None:
            return None

        root = TreeNode(container[0])

        queue = [root]
        next_level = []

        i = 1
        while len(queue) > 0 and i < len(container):
            j = 0
            while j < len(queue) and i < len(container):
                node = queue[j]
                if container[i] is not None:
                    node.left = TreeNode(container[i])
                    next_level.append(node.left)
                i += 1
                if container[i] is not None:
                    node.right = TreeNode(container[i])
                    next_level.append(node.right)
                i += 1
                j += 1

            if next_level:
                queue = next_level

        return root


def main():
    coder = Codec()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(5)
    #root.right.right.right = TreeNode(6)

    assert coder.serialize(root) == '[1,2,3,null,null,4,5]'
    assert coder.serialize(coder.deserialize(coder.serialize(root))) == '[1,2,3,null,null,4,5]'


if __name__ == '__main__':
    main()
