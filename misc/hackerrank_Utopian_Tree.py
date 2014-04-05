"""hackerrank_Utopian_Tree

https://www.hackerrank.com/challenges/utopian-tree
"""




def solve(n):
    height = 0
    for i in xrange(n + 1):
        if i % 2 == 0:
            height += 1
        else:
            height += height
    return height



def main():
    T = int(raw_input())
    for _ in xrange(T):
        print solve(int(raw_input()))


if __name__ == '__main__':
    main()
