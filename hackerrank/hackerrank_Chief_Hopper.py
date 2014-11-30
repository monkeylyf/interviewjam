"""hackerrank_Chief_Hopper.py

https://www.hackerrank.com/contests/w12/challenges/chief-hopper
"""


def main():
    n = int(raw_input())
    heights = map(int, raw_input().split())

    # if the bot reach nth building and with 0 energy left,
    # the minimum energy it needs when it's at n-1th building.
    bot_energy = (heights[-1] + 1) / 2

    for i in reversed(xrange(n - 1)):
        bot_energy = (bot_energy + 1 + heights[i]) / 2

    print bot_energy


if __name__ == '__main__':
    main()
