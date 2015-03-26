"""hackerrank_Superman_Celebrates_Diwali.py

https://www.hackerrank.com/contests/w14/challenges/superman-celebrates-diwali
"""

from pprint import pprint as p


def find_largest_and_second_largest(arr):
    """Find largest and second largest info of an integer array."""
    largest = None
    largest_idx = None
    second_largest = None

    for i, value in enumerate(arr):
        if largest is None:
            # Init largest.
            largest = value
            largest_idx = set([i])
        elif value > largest:
            # Move largest to second largest.
            second_largest = largest
            # Update largest.
            largest = value
            largest_idx = set([i])
        elif value == largest:
            # Add index to largest_idx
            largest_idx.add(i)
        elif second_largest is None:
            # Init second largest.
            second_largest = value
        elif value > second_largest:
            # Update second largest.
            second_largest = value
        elif value == second_largest:
            # Don't care the indices of second largest element.
            pass
        else:
            pass

    return largest, largest_idx, second_largest


def main():
    """Obvsiouly it's a DP puzzle.

    dp[k][j] represents the max people you can save when  you are in building j
    and at floor k. You have only two options: 1. jump to one of the other
    buildings. 2. Stay with current building and go one floor down.
    Keeping states of previous k floors.

    dp[k][j] = max(
        dp[k - 1][j] + people at building j floor k
        dp[k - i][g] + people at building j floor k where g != j
    )

    The tricky part is when you choose to jump, do need to find the optimal
    building with most people to save. it can be precomputed.
    """
    n, h, i = map(int, raw_input().split())

    builingds = [[0 for _ in xrange(n)] for _ in xrange(h)]
    # Reconstruct input.
    for k in xrange(n):
        arr = map(int, raw_input().split())
        # builingds[i][j] represents number of people to save at building j floor i.
        for j in arr[1:]:
            builingds[j - 1][k] += 1

    # Edge case: only one building.
    # In this case you just go straight down without worrying about jumping.
    if n == 1:
        ret = 0
        for k in xrange(h):
            ret += builingds[k][0]

        print ret
        return

    # At least two buildings. n >= 2.
    sliding_window = []

    # Cooking init state of sliding window.
    for k in xrange(min(h, i)):
        if k == 0:
            sliding_window.append((builingds[k], find_largest_and_second_largest(builingds[k])))
        else:
            cur_floor = [x + y for x, y in zip(builingds[k], sliding_window[-1][0])]
            sliding_window.append((cur_floor, find_largest_and_second_largest(cur_floor)))

    # Start sliding.
    for k in xrange(i, h):
        cur_floor = [None] * n
        for j in xrange(n):
            local_max = 0
            people_to_save_on_this_floor = builingds[k][j]

            # If you choose to jump.
            floor, (largest, largest_idx, second_largest) = sliding_window[0]
            if j not in largest_idx or len(largest_idx) > 1:
                choose_to_jump = people_to_save_on_this_floor + largest
            else:
                choose_to_jump = people_to_save_on_this_floor + second_largest

            # If you choose not to jump.
            choose_not_to_jump = people_to_save_on_this_floor + sliding_window[-1][0][j]

            cur_floor[j] = max(choose_to_jump, choose_not_to_jump)
        sliding_window = sliding_window[1:] + [(cur_floor, find_largest_and_second_largest(cur_floor))]

    print sliding_window[-1][1][0]


if __name__ == '__main__':
    main()
