/*You have an array with all the numbers from 1 to N, where N is at most
32,000. The array may have duplicate entries and you do not know what N is.
With only 4KB of memory available, how would you print all duplicate element
in the array?

int -> 4bytes per number -> 4KB -> max read 1024 number per time

4kb = 4 * 1024 * 8 = 32,768 > 32,000 -> bit mask to track the numbers
*/
