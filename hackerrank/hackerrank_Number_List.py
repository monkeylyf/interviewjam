"""hackerrank_Number_List.py

https://www.hackerrank.com/contests/w14/challenges/number-list
"""


def main():
    """Alwasy pay attention to terms like subarray/subsequence because it's so
    important that it might completely change your approach to tackle the
    problem..

    # of subarrays with max larger than k =
        # of subarrays - # of subarrays with max no great than k
    """
    # Lambda for calc total number of possible subarrays.
    num_of_subarrays = lambda x: x * (x + 1) / 2
    t = int(raw_input())
    for _ in xrange(t):
        n, k = map(int, raw_input().split())
        arr = map(int, raw_input().split())

        counter = 0
        total = num_of_subarrays(n)
        # Find all consecutive subarrays that max is no greater than k.
        for i in arr:
            if i <= k:
                counter += 1
            else:
                # Extract from totel.
                total -= num_of_subarrays(counter)
                counter = 0

        # Don't forget to check the last since the else will never be hit
        # because loop ends first.
        total -= num_of_subarrays(counter)
        print total


if __name__ == '__main__':
    main()
