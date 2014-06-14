"""hackerrank_Sam_And_Substrings

https://www.hackerrank.com/challenges/sam-and-substrings
"""


def solve(n):
    MOD = 10 ** 9 + 7

    acc = 0
    for i, char in enumerate(n):
        state = int(n[0]) if i == 0 else (int(char) * (i + 1)) % MOD + (state * 10 % MOD) % MOD
        acc = (acc + state) % MOD

    print acc

def main():
    n = raw_input()
    solve(n)


if __name__ == '__main__':
    main()
