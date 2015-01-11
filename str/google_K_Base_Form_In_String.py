"""google_K_Base_Form_In_String.py
google


Given a string, k and n. Check if this string contains all possible forms of
k-based number with length n.

For example, given string '00110', k = 2, n = 2, string contains all possible
binary form of length 2, which are, '00', '01', '10', '11'
"""

def solve(s, k, n):
    """Sliding window.

    Adding all substring with length n to set.
    For k-based number with n digits, there are totally k^n possibilities.
    """
    seen = set()
    for i in xrange(len(s) - n + 1):
        seen.add(s[i:i + n])

    return len(seen) == k ** n


def main():
    print solve('00110', 2, 2)


if __name__ == '__main__':
    main()
