"""hackerrank_Cipher

https://www.hackerrank.com/contests/w10/challenges/cipher
"""

from Queue import Queue


def solve(n, k, b):
    """Reverse sliding window."""
    window = Queue()
    acc = []
    count = 0

    for i in xrange(n):
        val = int(b[i])
        if len(window.queue) == k:
            # Dequeue.
            count -= window.queue.popleft()
        digit = abs(val - count) % 2

        window.queue.append(digit)
        count += digit
        acc.append(str(digit))

    print ''.join(acc)


def main():
    (n, k) = map(int, raw_input().split())
    b = raw_input()
    solve(n, k, b)


if __name__ == '__main__':
    main()
