





def main():
    T = int(raw_input())
    for t in xrange(1, T + 1):
        first = int(raw_input())
        grid = [ map(int, raw_input().split()) for i in xrange(4) ]
        second = int(raw_input())
        new_grid = [ map(int, raw_input().split()) for i in xrange(4) ]
        row = set(grid[first - 1])
        new_row = set(new_grid[second - 1])
        union = row & new_row
        if len(union) == 0:
            print 'Case #{0}: {1}'.format(t, 'Volunteer cheated!')
        elif len(union) == 1:
            print 'Case #{0}: {1}'.format(t, list(union)[0])
        else:
            print 'Case #{0}: {1}'.format(t, 'Bad magician!')


if __name__ == '__main__':
    main()
