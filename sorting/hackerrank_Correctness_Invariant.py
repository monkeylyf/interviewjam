""" hackerrank_Correctness_Invariant

https://www.hackerrank.com/challenges/correctness-invariant
"""

def insertion_sort(l):
    for i in xrange(1, len(l)):
        j = i-1 
        key = l[i]
        while (l[j] > key) and (j >= 0): # The change is in this line.
           l[j+1] = l[j]
           j -= 1
        l[j+1] = key


m = input()
ar = [int(i) for i in raw_input().strip().split()]
insertion_sort(ar)
print " ".join(map(str,ar))
