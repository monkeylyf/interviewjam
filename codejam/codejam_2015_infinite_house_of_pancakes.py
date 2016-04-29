"""
"""


def max_two_n_index(arr):
    first = None
    first_index = None
    second = None
    second_index = None

    for i, val in enumerate(arr):
        if i == 0:
            first = val
            first_index = i
        elif val > first:
            # first to second.
            second = first
            second_index = first_index
            # update first
            first = val
            first_index = i
        elif second == None or val > second:
            second = val
            second_index = i

    return first, first_index, second, second_index


def main():
    test = int(raw_input())
    for t in xrange(test):
        d = int(raw_input())
        p = map(int, raw_input().split())
        #p.sort(reverse=True)
        #print d, p

        minute = 0
        while p:
            minute += 1
            first, first_index, second, second_index = max_two_n_index(p)

            half = first / 2
            next_max = max(first - half, second)

            if first > 1 + next_max:
                p[first_index] -= half
                p.append(half)
            else:
                new_p = []
                for i in p:
                    if i - 1 > 0:
                        new_p.append(i - 1)
                p = new_p

        print 'Case #{}: {}'.format(t + 1, minute)


if __name__ == '__main__':
    main()
