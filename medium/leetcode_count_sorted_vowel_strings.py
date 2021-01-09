# https://leetcode.com/problems/count-sorted-vowel-strings/

pecomputed = [0, 5, 15, 35, 70, 126, 210, 330, 495, 715, 1001, 1365, 1820, 2380, 3060, 3876, 4845, 5985, 7315, 8855, 10626, 12650, 14950, 17550, 20475, 23751, 27405, 31465, 35960, 40920, 46376, 52360, 58905, 66045, 73815, 82251, 91390, 101270, 111930, 123410, 135751, 148995, 163185, 178365, 194580, 211876, 230300, 249900, 270725, 292825, 316251]

class Solution:
    def countVowelStrings(self, n: int) -> int:
        # DP and also can be precomputed.
        #dp = [0, 5]
        #state = [1, 1, 1, 1, 1]
        #for i in range(2, 51):
        #    acc = 0
        #    total = 0
        #    for i, val in enumerate(state):
        #        acc += val
        #        state[i] = acc
        #        total += acc
        #    dp.append(total)
        #print(dp)

        return precomputed[n]
