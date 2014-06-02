"""hackerrank_Palindrome_Index

https://www.hackerrank.com/contests/w4/challenges/palindrome-index
"""

def is_palindrome(s):
    if len(s) == 0 or len(s) == 1:
        return True

    head = 0
    tail = len(s) - 1
    while head < tail:
        if s[head] != s[tail]:
            return False

        head += 1
        tail -= 1

    return True

def solve(s):
    head = 0
    tail = len(s) - 1

    while head < tail:
        if s[head] == s[tail]:
            head += 1
            tail -= 1
            continue

        if tail - head == 1:
            remove_index = tail
        elif is_palindrome(s[head : tail]):
            remove_index = tail
        elif is_palindrome(s[head + 1 : tail + 1]):
            remove_index = head
        else:
            remove_index = None

        return remove_index

    return -1
                

def main():
    T = int(raw_input())
    for _ in xrange(T):
        print solve(raw_input())


if __name__ == '__main__':
    main()
