# Service Lane
# https://www.hackerrank.com/contests/101nov13/challenges/service-lane
#
import math


class SegTree(object):
    
    """Implementation of Segment Tree."""
    
    def __init__(self, lane):
        self.lane = lane
        self.length = len(lane)
        self.tree = None
        self.build_tree()
       
    def build_tree(self):
        """Build Segment Tree."""
        # Calc height and size of the tree.
        height = int(math.ceil(math.log(self.length, 2)))
        size = 2 * int(pow(2, height)) - 1
        self.tree = [ 0 ] * size
        self.build_tree_util(0, self.length - 1, 0)
    
    def build_tree_util(self, start, end, index):
        if start == end:
            # Reach the leaf.
            self.tree[index] = self.lane[start]
            return self.lane[start]
        else:
            mid = start + (end - start) / 2
            # min op is the key. If you want a max segtree then do max.
            self.tree[index] = min(self.build_tree_util(start, mid, index * 2 + 1),
                                   self.build_tree_util(mid + 1, end, index * 2 + 2))
            return self.tree[index]
        
    def query(self, start, end):
        """Given start/end index, query the min value in this range."""
        if (start < 0 or end >= self.length or start > end):
            raise ValueError
        return self.query_util(0, self.length - 1, start, end, 0)
    
    def query_util(self, start, end , qStart, qEnd, index):
        if qStart <= start and qEnd >= end:
            return self.tree[index]
        elif end < qStart or start > qEnd:
            return 10000000007 # The range falls out, return a very large number for min op.
        else:
            mid = start + (end - start) / 2
            # Left/right child relation in tree array is 2 * idx + 1 and 2 * idx + 2.
            return min(self.query_util(start, mid, qStart, qEnd, 2 * index + 1),
                       self.query_util(mid + 1, end, qStart, qEnd, 2 * index + 2))


def main():
    (N, T) = map(int, raw_input().split())
    lane = map(int, raw_input().split())
    segtree = SegTree(lane)
    for _ in xrange(T):
        (start, end) = map(int, raw_input().split())
        print segtree.query(start, end)


if __name__ == '__main__':
    main()
