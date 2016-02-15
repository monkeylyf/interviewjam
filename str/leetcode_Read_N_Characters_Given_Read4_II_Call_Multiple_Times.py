"""Read n characters given read4 II call multiple times

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called *MULTIPLE* times.
"""


from collections import deque

INPUT = None
OFFSET = 0

# The read4 API is already defined for you.
# @param buf, a list of characters
# @return an integer
def read4(buf):
    global OFFSET
    if OFFSET < len(INPUT):
        four_char = INPUT[OFFSET:OFFSET + 4]
        for i, char in enumerate(four_char):
            buf[i] = char
        OFFSET += 4
        return len(four_char)


class Solution(object):

    def __init__(self):
        """"""
        # WTF, if overread is set as static var of this class, it won't AC.
        # But if move to obj attribute, it works. Maybe it has something to
        # do with the OJ?
        self.overread = deque()

    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Maximum number of characters to read (int)
        :rtype: The number of characters read (int)
        """
        count = 0
        # Dump overread to buf is there is any
        while self.overread and n > 0:
            buf[count] = self.overread.popleft()
            count += 1
            n -= 1

        while n > 0:
            buff4 = [None] * 4
            num_char_read = read4(buff4)
            needed_num_char = min(num_char_read, n)
            j = 0
            while j < needed_num_char:
                buf[count + j] = buff4[j]
                j += 1

            count += j
            # Read more than need
            if n < num_char_read:
                # Move unwanted char to overread for next time.
                while j < num_char_read:
                    self.overread.append(buff4[j])
                    j += 1
            if num_char_read < 4:
                break
            n -= needed_num_char
        return count


def main():
    sol = Solution()
    global INPUT
    INPUT = 'abc'
    buf = [''] * 10
    n = 2
    print sol.read(buf, n)
    print ''.join(buf)

    #n = 1
    #sol.read(buf, n)
    #print ''.join(buf)


if __name__ == '__main__':
    main()
