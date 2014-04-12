def solve(C, F, X, T):
    clock = 0

    val = 0
    farm = 0

    used_time = 0

    while True:
        # Time that you need to win without buying new farm
        t = (X - val) / (2.0 + farm * F)
        # Time that you need to win with buying one new farm
        one_more_farm_T = (C - val) / (2.0 + farm * F)
        wait_til_win = X / (2.0 + (farm + 1) * F)
        if one_more_farm_T + wait_til_win > t:
            print 'Case #{0}: {1:.7f}'.format(T, t + used_time)
            break
        else:
            used_time += one_more_farm_T
            farm += 1



def main():
    T = int(raw_input())
    for t in xrange(1, T + 1):
        (C, F, X) = map(float, raw_input().split())
        solve(C, F, X, t)

if __name__ == '__main__':
    main()
