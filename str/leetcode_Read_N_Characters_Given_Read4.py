"""Read N characters given read4
leetcode

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it
returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that
reads n characters from the file.

Note:
The read function will only be called once for each test case.
"""

INPUT = None
OFFSET = 0

def read4(buf):
    """The read4 API is already defined for you.

    Using global to mock read from file with offset.

    # @param buf, a list of characters
    # @return an integer
    """
    global OFFSET
    first_four_char = INPUT[OFFSET:OFFSET + 4]
    for i, char in enumerate(first_four_char):
        buf[i] = char
    OFFSET += 4
    return len(first_four_char)


class Solution(object):
    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Maximum number of characters to read (int)
        :rtype: The number of characters read (int)
        """
        count = 0
        py_buf = [''] * 4
        while n > 0:
            read_char = min(n, read4(py_buf))

            for i in xrange(read_char):
                buf[count + i] = py_buf[i]

            n -= read_char
            count += read_char
            if read_char != 4:
                break
        return count


def main():
    sol = Solution()
    global INPUT
    INPUT = 'abcdef'
    buf = [''] * 999
    n = 5
    sol.read(buf, n)
    assert ''.join(buf[:n]) == INPUT[:5]


if __name__ == '__main__':
    main()
