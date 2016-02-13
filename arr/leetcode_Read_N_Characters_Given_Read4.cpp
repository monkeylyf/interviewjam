/**
 * Read n characters given read4.
 * leetcode
 *
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 *
 * The return value is the actual number of characters read. For example, it
 * returns 3 if there is only 3 characters left in the file.
 *
 * By using the read4 API, implement the function int read(char *buf, int n)
 * that reads n characters from the file.
 *
 * Note:
 * The read function will only be called once for each test case.
 */

#include <stdio.h>
#include <stdlib.h>

// Forward declaration of the read4 API.
int read4(char *buf);

class Solution {
 public:
  /**
   * @param buf Destination buffer
   * @param n   Maximum number of characters to read
   * @return    The number of characters read
   */
  int read(char *buf, int n) {
    int count = 0;
    while (n > 0) {
      int read_char_num = std::min(n, read4(buf));
      n -= read_char_num;
      count += read_char_num;
      buf += read_char_num;  // C/C++ syntax that moves the pointer.
      if (read_char_num != 4) {
        break;
      }
    }
    return count;
  }
};


int main() {
  Solution sol;
}
