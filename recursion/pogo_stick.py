# https://code.google.com/codejam/contest/2437488/dashboard#s=p1

import sys

# Default recursion limit is 1000. Set to 10000
sys.setrecursionlimit(10000)

rl = sys.stdin.readline
T = int(rl())


def is_reachable(x, y, steps):
    euclidea_dis = abs(x) + abs(y)
    abs_dis = (steps + 1) * steps / 2
    # the magic is here
    # euclidea_dis <= abs_dis
    #           and                     <=>  (x, y) is reachable
    # euclidea_dis % 2 == abs_dis % 2
    return (euclidea_dis <= abs_dis) and (euclidea_dis % 2 == abs_dis % 2)


def backward(x, y, steps, path):
    if (x == 0 and y == 0 and steps == 0):
        return

    elif is_reachable(x, y - steps, steps - 1):
        backward(x, y - steps, steps - 1, path)
        path.append('N')

    elif is_reachable(x - steps, y, steps - 1):
        backward(x - steps, y, steps - 1, path)
        path.append('E')

    elif is_reachable(x, y + steps, steps - 1):
        backward(x, y + steps, steps - 1, path)
        path.append('S')

    elif is_reachable(x + steps, y, steps - 1):
        backward(x + steps, y, steps - 1, path)
        path.append('W')


def solve(x, y, t):
    steps = 1
    while(not is_reachable(x, y, steps)):
        steps = steps + 1

    path = list()
    backward(x, y, steps, path)
    print 'Case #{0}: {1}'.format(t, ''.join(path))


for t in xrange(1, T + 1):
    x, y = map(int, rl().split())
    solve(x, y, t)
