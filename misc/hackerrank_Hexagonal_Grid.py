"""hackerrank_Hexagonal_Grid

https://www.hackerrank.com/contests/101mar14/challenges/hexagonal-grid
"""



def solve(N, up, lower):
    """Not the most elegant solution but it works."""
    dp = [ [ False for _ in xrange(3) ] for _ in xrange(N) ]
    # dp[0]: whole line. 
    # dp[1]: up grid and prev part is good
    # dp[2]: lower grid and prev part is good
    dp[0][0] = up[0] == lower[0]
    dp[0][1] = up[0] == '1' and lower[0] == '0'
    dp[0][2] = up[0] == '0' and lower[0] == '1'

    #print up
    #print lower
    for i in xrange(1, N):
        #print i
        if up[i] == '0' and lower[i] == '0':
            dp[i][0] = dp[i - 1][0]
            dp[i][1] = (up[i - 1] == '0' and dp[i - 1][2]) or (lower[i - 1] == '0' and dp[i - 1][1])
            dp[i][2] = (lower[i - 1] == '0' and dp[i - 1][1]) or (up[i - 1] == '0' and dp[i - 1][2])
        elif up[i] == '1' and lower[i] == '1':
            dp[i][1] = dp[i][2] = dp[i][0] = dp[i - 1][0]
        elif up[i] == '0' and lower[i] == '1':
            dp[i][0] = dp[i][1] = (up[i - 1] == '0' and dp[i - 1][2]) or (lower[i - 1] == '0' and dp[i - 1][1])
            dp[i][2] = dp[i - 1][0]
        else:
            # up[i] == '1' and lower[i] == '0':
            dp[i][0] = dp[i][2] = lower[i - 1] == '0' and dp[i - 1][1]
            dp[i][1] = dp[i - 1][0]
    
    #for line in dp:
    #    print line

    return dp[-1][0]


def main():
    T = int(raw_input())
    for _ in xrange(T):
        N = int(raw_input())
        up = raw_input()
        lower = raw_input()
        if up.count('1') + lower.count('1') % 2 == 1:
            print 'NO'

        elif solve(N, up, lower):
            print 'YES'
        else:
            print 'NO'


if __name__ == '__main__':
    main()
