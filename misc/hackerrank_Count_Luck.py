#hackerrank_Count_Luck
#https://www.hackerrank.com/contests/101feb14/challenges/count-luck
#


T = int(raw_input())


def dfs(forrest, N, M, K, start_i, start_j):
    #
    vistied = [ [ False for _ in xrange(M) ] for _ in xrange(N) ]
    vistied[start_i][start_j] = True

    def dfs_util(i, j, k):
        print '@({0}, {1}) k={2}'.format(i, j, k)
        if forrest[i][j] == '*':
            print 'Arrived! k={0}'.format(k)
            return k == K
        else:
            options = set()
            # check Up
            if i > 0 and not vistied[i - 1][j] and forrest[i - 1][j] in ('.', '*'):
                options.add((i - 1, j))
            # check down
            if i < N - 1 and not vistied[i + 1][j] and forrest[i + 1][j] in ('.', '*'):
                options.add((i + 1, j))
            # check left
            if j > 0 and not vistied[i][j - 1] and forrest[i][j - 1] in ('.', '*'):
                options.add((i, j - 1))
            # check right
            if j < M - 1 and not vistied[i][j + 1] and forrest[i][j + 1] in ('.', '*'):
                options.add((i, j + 1))

            use_wand = 1 if len(options) > 1 else 0
            print 'use wand? {0}'.format(use_wand)
            for i, j in options:
                vistied[i][j] = True
                res = dfs_util(i, j, k + use_wand)
                if res:
                    return True
                else:
                    vistied[i][j] = False

            return False

    res = dfs_util(start_i, start_j, 0)
    content = 'Impressed' if res else 'Oops!'
    print content

def get_exit_start(forrest, N, M):
    start_i = None
    start_j = None
    for i in xrange(N):
        for j in xrange(M):
            if forrest[i][j] == 'M':
                start_i, start_j, = i, j

    return (start_i, start_j)


for i in xrange(T):
    (N, M) = map(int, raw_input().split())

    forrest = [None] * N

    for j in xrange(N):
        forrest[j] = raw_input()

    K = int(raw_input())

    #print N, M
    #print forrest
    #print K
    (start_i, start_j) = get_exit_start(forrest, N, M)
    #print (start_i, start_j)

    dfs(forrest, N, M, K, start_i, start_j)
