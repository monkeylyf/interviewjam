#hackerrank_Cut_the_Sticks
#https://www.hackerrank.com/contests/101feb14/challenges/cut-the-sticks
#



length = int(raw_input())
arr = sorted(map(int, raw_input().split()))

index = 0

while index < length:
    print length - index

    while index < length - 1 and arr[index] == arr[index + 1]:
        index += 1
    index += 1
