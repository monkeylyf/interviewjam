# Given an integer array with length n + 1, all elements are from [1, n]
# and there is only one duplicate element. Find it.

#google


def find_duplicate(arr):
    # Solution xor all elements in array and xor all number from [1, n]
    # Then all elements are xor'ed two times and duplicates are xor'ed
    # three times. the result itself is the duplicate element
    ret = 0
    for i in arr:
        ret = ret ^ i
    for i in range(1, len(arr)):
        ret = ret ^ i
    return ret 


def run():
    arr = [1,2,3,4,5,5,6,7,8]
    assert(find_duplicate(arr) == 5)
    arr = [1,2,3,3]
    assert(find_duplicate(arr) == 3)

if __name__ == '__main__':
    run()
