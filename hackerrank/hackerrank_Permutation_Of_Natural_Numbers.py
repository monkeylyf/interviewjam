"""hackerrank_Permutation_Of_Natural_Numbers.py

https://www.hackerrank.com/contests/101hack22/challenges/permutation-of-natural-numbers
"""


def main():
    s = raw_input()
    local_max = len(s) + 1

    prev = None
    acc = None

    res = []

    for char in s:
        if prev is None:
            # Set first char as flag to find longest consecutive subarray.
            prev = char
            acc = 1
        elif prev == char:
            # Current char equals to previous one. Keep on accumulating.
            acc += 1
        elif prev == 'I':
            # Longest consecutive subarray with all 'I'.
            # Construct longest increasing subarray with max as local_max.
            res += range(local_max - acc, local_max + 1)
            local_max -= acc + 1
            # Tricky part:
            # So now the pattern is III...ID with char is pointing to the last
            # D. The subarray constructed above is [max-acc... max], that means
            # no matter what number is chosen next for D with new local_max
            # range is alwasy gonna be less than current max.
            # So here treat the rest of the array just as a new array.
            # Reset.
            prev = None
            acc = 0
        elif prev == 'D':
            # Longest consecutive subarray with all 'D'.
            # Construct longest decreasing subarray with max as local_max.
            # [max, max-1...max-acc]
            res += range(local_max, local_max - acc, -1)
            local_max -= acc
            prev = char
            acc = 1
        else:
            raise ValueError(prev)

    # Checkout the last continuous segment.
    if acc != 0:
        if prev == 'I':
            res += range(local_max - acc, local_max + 1)
        elif prev == 'D':
            res += range(local_max, local_max - acc, -1)
        else:
            raise ValueError(prev)

    if len(res) != len(s) + 1:
        # By resetting the array it will miss the 1.
        res.append(1)

    print ' '.join(map(str, res))


if __name__ == '__main__':
    main()
