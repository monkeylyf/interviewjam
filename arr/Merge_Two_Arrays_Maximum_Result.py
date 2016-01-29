"""Merge two arrays so the results is as large as possible.

The order of each element in each array must remain the same.

For example
[1] and [2] should yield [2, 1],
[1, 2] and [1, 2, 3] should yield [1, 2, 3, 1, 2]
"""


def merge(arr1, arr2):
    """Keep in mind that naively implementing two pionters won't work.

    The problem is when two pointers ref to the same value, then which one
    should you move first? You need to compare the rest of both arrays.
    """
    n = len(arr1)
    m = len(arr2)

    if n == 0:
        return arr2
    if m == 0:
        return arr1

    merged = []
    i = 0
    j = 0

    while i < n and j < m:
        if arr1[i] > arr2[j]:
            merged.append(arr1[i])
            i += 1
        elif arr1[i] < arr2[j]:
            merged.append(arr2[j])
            j += 1
        else:
            ii = i
            jj = j
            while ii < n and jj < m and arr1[ii] == arr2[jj]:
                ii += 1
                jj += 1

            #print ii, jj
            if ii == n:
                merged.append(arr2[j])
                j += 1
            elif jj == m:
                merged.append(arr1[i])
                i += 1
            elif arr1[ii] > arr2[jj]:
                merged.append(arr1[i])
                i += 1
            else:
                merged.append(arr2[j])
                j += 1

    if i < n:
        merged.extend(arr1[i:])
    if j < m:
        merged.extend(arr2[j:])

    return merged


def main():
    assert merge([], [1]) == [1]
    assert merge([2], []) == [2]
    assert merge([1], [1]) == [1, 1]
    assert merge([1], [1, 2]) == [1, 2, 1]
    assert merge([1, 0], [1, 0]) == [1, 1, 0, 0]


if __name__ == '__main__':
    main()
