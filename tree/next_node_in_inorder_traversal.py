"""Given a node, find the next node in inorder traversal.

You can, of course, inorder traverse the tree first to save the order and then
search the list to locate the given node and yield the next. It's a O(n)
solution for both time and space complexity.

If parent pointer is given, you can locate the next with O(lgn) time complexity
and not extra space is required.
"""


class TreeNode(object):

    def __init__(self, left=None, right=None, val=None, parent=None):
        self.left = left
        self.right = right
        self.val = val
        self.parent = parent

    def __repr__(self):
        return '%s' % self.val


def inorder(root, order):
    if not root:
        return
    inorder(root.left, order)
    order.append(root)
    inorder(root.right, order)


def next_inorder(node):
    print('current: %s' % node)
    if node.right:
        node = node.right
        while node.left:
            node = node.left
        print('next: %s' % node)
    else:
        parent = node.parent
        while parent and parent.right is node:
            node = parent
            parent = parent.parent
        if parent:
            print('next: %s' % parent)
        else:
            print('None')


def main():
    root = TreeNode(val=1)
    left = TreeNode(val=2, parent=root)
    right = TreeNode(val=3, parent=root)
    root.left = left
    root.right = right

    left_left = TreeNode(val=4, parent=left)
    left_right = TreeNode(val=5, parent=left)
    left.left = left_left
    left.right = left_right

    left_right_left = TreeNode(val=7, parent=left_right)
    left_right.left = left_right_left

    right_right = TreeNode(val=6, parent=right)
    right.right = right_right

    right_right_left = TreeNode(val=8, parent=right_right)
    right_right_right = TreeNode(val=9, parent=right_right)
    right_right.left = right_right_left
    right_right.right = right_right_right

    right_right_left_left = TreeNode(val=10, parent=right_right_left)
    right_right_left.left = right_right_left_left

    order = []
    inorder(root, order)
    print(order)
    for node in order:
        next_inorder(node)


if __name__ == '__main__':
    main()
