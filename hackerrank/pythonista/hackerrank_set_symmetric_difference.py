"""hackerrank_set_symmetric_difference.py

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/sets
"""


def main():
    m = int(raw_input())
    m_arr = set(map(int, raw_input().split()))
    n = int(raw_input())
    n_arr = set(map(int, raw_input().split()))

    ordered_list = sorted(list(set.union(m_arr - n_arr, n_arr - m_arr)))

    for i in ordered_list:
        print i



if __name__ == '__main__':
    main()
