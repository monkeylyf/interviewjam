"""Gift excahnge
Twitter

You have n people and each one should give his/her gift to someone and each one
can only received a gift fro one person
"""

def all_solutions(n):
    """"""
    def dfs(i, n, given, acc, container):
        """"""
        if i == n:
            container.append(acc[:])
        else:
            for j in xrange(n):
                if i == j:
                    # Cannot take gift from yourself.
                    continue
                if given[j]:
                    # Cannot take gift from a person who has already given his/her
                    continue

                given[j] = True
                acc.append(j)
                dfs(i + 1, n, given, acc, container)
                acc.pop()
                given[j] = False

    container = []
    dfs(0, n, [False] * n, [], container)
    return container


def main():
    p(all_solutions(4))


if __name__ == '__main__':
    main()
