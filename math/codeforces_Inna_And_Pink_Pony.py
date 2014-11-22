"""codeforces_Inna_And_Pink_Pony.py

http://codeforces.com/contest/374/problem/A
"""

def reachable(args):
    (x, y, i, j, a, b) = args
    div_x, mod_x = divmod(abs(x - i), a)
    if mod_x != 0:
        return None

    div_y, mod_y = divmod(abs(y - j), b)
    if mod_y != 0:
        return None

    if abs(div_x - div_y) % 2 != 0:
        return None
    else:
        return max(div_x, div_y)


def main():
    (n, m, i, j, a, b) = map(int, raw_input().split())
    corners = ((1, 1, i, j, a, b),
               (1, m, i, j, a, b),
               (n, 1, i, j, a, b),
               (n, m, i, j, a, b),)

    res = map(reachable, corners)
    if any(res):
        print min(filter(lambda x : x is not None, res))
    else:
        print 'Poor Inna and pony!'


if __name__ == '__main__':
    main()
