# given n points in euclidean space.
# Find two points with the closest distance.
# http://www.cs.ucsb.edu/~suri/cs235/ClosestPair.pdf

import operator


class Point():

    def __init__(self, x, y):
        """Init"""
        self.x = x
        self.y = y

    def __repr__(self):
        return '<{0}, {1}>'.format(self.x, self.y)


def distance(a, b):
    return abs((a.x - b.x) ** 2 + (a.y - b.y) ** 2) ** 0.5


def closest_points(pts):
    """Time complexity: O(nlogn)"""
    n = len(pts)
    if n <= 1:
        print 'Invalid input'
        raise Exception
    elif n == 2:
        return (pts[0], pts[1])
    elif n == 3:
        # Calc directly
        (a, b, c) = pts
        ret = (a, b) if distance(a, b) < distance(a, c) else (a, c)
        ret = (ret[0], ret[1]) if distance(ret[0], ret[1]) < distance(b, c) else (b, c)
        return ret
    else:
        pts = sorted(pts, key=operator.attrgetter('x'))
        left = pts[ : n / 2]
        right = pts[n / 2 : ]
        
        # Devide and conquer.
        (left_a, left_b) = closest_points(left)
        (right_a, right_b) = closest_points(right)

        # Find the min distance for left part and right part.
        d = min(distance(left_a, left_b), distance(right_a, right_b))
        # Cut the point set into two.
        mid = (pts[n / 2].x + pts[n / 2 + 1].x) / 2

        # Find all points fall in [mid - d, mid + d]
        mid_range = filter(lambda pt : pt.x >= mid - d and pt.x <= mid + d, pts)
        # Sort by y axis.
        mid_range = sorted(mid_range, key=operator.attrgetter('y'))

        ret = None
        localMin = None
        # Brutal force, for each point, find another point and delta y less than d.
        # Calc the distance and update the global var if hits the condition.
        for i in xrange(len(mid_range)):
            a = mid_range[i]
            for j in xrange(i + 1, len(mid_range)):
                b = mid_range[j]
                if (not ret) or (abs(a.y - b.y) <= d and distance(a, b) < localMin):
                        ret = (a, b)
                        localMin = distance(a, b)
        return ret


def main():
    # Test case.
    #pts = [ Point(1, 2), Point(0, 0), Point(3, 6), Point(4, 7), Point(5, 5),
    #        Point(8, 4), Point(2, 9), Point(4, 5), Point(8, 1), Point(4, 3)]
    pts = [ Point(1, 2), Point(0, 0), Point(3, 6), Point(4, 7), Point(5, 5),
            Point(8, 4), Point(2, 9), Point(4, 5), Point(8, 1), Point(4, 3),
            Point(3, 3)]
    print closest_points(pts)


if __name__ == '__main__':
    main()
