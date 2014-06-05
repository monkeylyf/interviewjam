"""hackerrank_Crush

https://www.hackerrank.com/contests/w4/challenges/crush
"""


from collections import namedtuple

def to_be_solve():
    token = namedtuple('token', ['index', 'type', 'weight'], verbose=False)

    (N, M) = map(int, raw_input().split())

    arr = []

    test = [ None ] * (N + 1)

    for i in xrange(M):
        (a, b, k) = map(int, raw_input().split())
        arr.append(token(a - 1, 'S', k)) # inclusive to exclusive
        arr.append(token(b, 'E', k))

    arr = sorted(arr)

    max_val = 0
    acc = 0
    prev_typ = None
    for token in arr:
        if token.type == 'S':
            acc += int(token.weight)
            max_val = max(max_val, acc)
        elif token.type == 'E':
            acc -= int(token.weight)

    print max_val


def solve():
    """Instead of use arr to store the actual value at each index, store the diff, i.e., Ai - Ai-1
    at index i.
    
    Array of length N + 1 to represent the all the diff.
    """
    (N, M) = map(int, raw_input().split())
    diff_to_prev = [ 0 ] * (N + 1)

    for i in xrange(M):
        (a, b, k) = map(int, raw_input().split())
        diff_to_prev[a - 1] += k
        diff_to_prev[b] -= k

    acc = 0
    max_val = 0
    for val in diff_to_prev:
        acc += val
        max_val = max(max_val, acc)



def main():
    #solve()
    to_be_solve()

if __name__ == '__main__':
    main()
