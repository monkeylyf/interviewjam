"""codejam_deceitful_war
codejam 2014

https://code.google.com/codejam/contest/2974486/dashboard#s=p2
"""


def solve(N, naomi, ken, t):
    head = 0
    tail = N - 1

    n = k = 0

    while k < N:
        if naomi[n] < ken[k]:
            n += 1
        k += 1

    war_game = N - n

    n = k = 0

    #print naomi
    #print ken

    while k < N:
        if naomi[n] <= ken[k]:
            #print naomi[n], ken[k]
            N -= 1 # Use the smallest to tell Ken a large num to make Ken play largest car he has.
            n += 1
        else:
            k += 1
            n += 1


    print 'Case #{0}: {1} {2}'.format(t, N, war_game)

def main():
    T = int(raw_input())
    for t in xrange(1, T + 1):
        N = int(raw_input())
        naomi = sorted(map(float, raw_input().split()))
        ken   = sorted(map(float, raw_input().split()))

        solve(N, naomi, ken, t)



if __name__ == '__main__':
    main()
