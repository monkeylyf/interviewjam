"""hackerrank_Encryption

https://www.hackerrank.com/challenges/encryption
"""

import math

def main():
    msg = raw_input()
    length = len(msg)
    root = math.sqrt(length)
    # In case of a rectangle the number of rows will always be smaller than the
    # number of columns.
    # Check if length is perfect square.
    col = int(root) if int(root + 0.5) ** 2 == length else int(root) + 1
    matrix = [ list(msg[i : min(i + col, length)]) for i in xrange(0, length, col) ]

    len_of_last_col = len(matrix[-1])
    # Padding last col if neccesary.
    if len_of_last_col < col:
        matrix[-1] = matrix[-1] + [''] * (col - len_of_last_col)
    
    for zipped_col in zip(*matrix):
        print ''.join(zipped_col),


if __name__ == '__main__':
    main()
