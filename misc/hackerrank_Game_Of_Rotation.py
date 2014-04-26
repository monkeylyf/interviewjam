"""hackerrank_Game_Of_Rotation

https://www.hackerrank.com/contests/101apr14/challenges/game-of-rotation
"""

def solve(N, arr):
    n = len(arr)
    acc = 0
    ret = None
    max_shift = None
    window_sum = 0

    for i, val in enumerate(arr):
        acc += (i + 1) * val
        if i == 0:
            continue
        window_sum += val

    for i in xrange(n):
        shift = arr[i] * (n - 1) - window_sum
        # Update
        ret = acc + shift if not ret else max(ret, acc + shift)
        acc += shift
        # Rotate
        window_sum += arr[i] - arr[(i + 1) % n]

    print ret



def main():
    N = int(raw_input())
    arr = map(int, raw_input().split())
    solve(N, arr)



if __name__ == '__main__':
    main()
