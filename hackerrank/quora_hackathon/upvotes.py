"""upvotes.p

"""

def main():
    n, k = map(int, raw_input().split())
    votes = map(int, raw_input().split())

    incre = [None] * (n - 1)

    for i in xrange(n - 1):
        if votes[i + 1] > votes[i]:
            incre[i] = 1
        elif votes[i + 1] < votes[i]:
            incre[i] = -1
        else:
            incre[i] = 0

    # Init sliding window.
    prev = None
    count = 0
    states = []
    for i in xrange(k - 1):
        if prev is None:
            prev = incre[i]
            count = 1
            continue

        #
        if incre[i] == prev:
            count += 1
        else:
            # checkout
            states.append(())





if __name__ == '__main__':
    main()
