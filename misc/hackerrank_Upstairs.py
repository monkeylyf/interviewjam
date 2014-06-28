"""hackerrank_Upstairs

https://www.hackerrank.com/contests/addepar/challenges/upstairs
"""
def solve(arr, N):
    """N >= 2"""
    local_max = 0
    floor = -1
    for i in xrange(1, N):
        before = up(arr[i - 1], arr[i])
        after =  up(arr[i], arr[i - 1])
        if i - 2 >= 0:
            before += up(arr[i - 2], arr[i - 1])
            after +=  up(arr[i - 2], arr[i])
        if i + 1 < N:
            before += up(arr[i], arr[i + 1])
            after +=  up(arr[i - 1], arr[i + 1])
        if before - after > local_max:
            local_max = before - after
            floor = i
    
    return floor


def up(a, b):
    return b - a if b > a else 0


def main():
    N = int(raw_input())
    arr = map(int, raw_input().split())
    print -1 if N <= 1 else solve(arr, N)

if __name__ == '__main__':
    main()
