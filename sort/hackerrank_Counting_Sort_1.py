"""hackerrank_Counting_Sort_1

https://www.hackerrank.com/challenges/countingsort1
"""



def main():
    N = int(raw_input())
    arr = map(int, raw_input().split())
    
    count = {}

    for i in arr:
        try:
            count[i] += 1
        except KeyError:
            count[i] = 1

    for i in xrange(100):
        try:
            val = count[i]
        except KeyError:
            val = 0
        print val,
    print ''


if __name__ == '__main__':
    main()
