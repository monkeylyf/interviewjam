# https://leetcode.com/problems/largest-multiple-of-three/

from typing import List

class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        if not digits:
            return  ''

        s = sum(digits)
        if s % 3 == 0:
            if digits[0] == 0:
                return '0'
            else:
                digits.sort(reverse=True)
                return ''.join(map(str, digits))

        mapping = {}
        for (i, val) in enumerate(digits):
            mod = val % 3
            if mod == 0:
                continue
            arr = mapping.get(mod)
            if arr is None:
                mapping[mod] = [(val, i)]
            else:
                arr.append((val, i))
        if s % 3 == 1:
            # Remove one smallest number that mods 3 equals to 1.
            arr = mapping.get(1)
            if arr is not None:
                _, min_val_index = min(arr)
                rest = [val for i, val in enumerate(digits) if i != min_val_index]
                if not rest:
                    return ''
                rest.sort(reverse=True)
                if rest[0] == 0:
                    return '0'
                else:
                    return ''.join(map(str, rest))
           # Remove two smallest number that mods 3 equals to 2.
            arr = mapping.get(2)
            if arr is not None and len(arr) >= 2:
                arr.sort()
                _, min_val_index = arr[0]
                _, second_min_val_index = arr[1]
                rest = [val for i, val in enumerate(digits) if i != min_val_index and i != second_min_val_index]
                if not rest:
                    return ''
                rest.sort(reverse=True)
                if rest[0] == 0:
                    return '0'
                else:
                    return ''.join(map(str, rest))

        if s % 3 == 2:
            # Remove one smallest number that mods 3 equals to 2.
            arr = mapping.get(2)
            if arr is not None:
                _, min_val_index = min(arr)
                rest = [val for i, val in enumerate(digits) if i != min_val_index]
                if not rest:
                    return ''
                rest.sort(reverse=True)
                if rest[0] == 0:
                    return '0'
                else:
                    return ''.join(map(str, rest))
           # Remove two smallest number that mods 3 equals to 1.
            arr = mapping.get(1)
            if arr is not None and len(arr) >= 2:
                arr.sort()
                _, min_val_index = arr[0]
                _, second_min_val_index = arr[1]
                rest = [val for i, val in enumerate(digits) if i != min_val_index and i != second_min_val_index]
                if not rest:
                    return ''
                rest.sort(reverse=True)
                if rest[0] == 0:
                    return '0'
                else:
                    return ''.join(map(str, rest))

        # No solution.
        return ''


def main():
    sol = Solution()
    print(sol.largestMultipleOfThree([8, 1, 9]) == '981')
    print(sol.largestMultipleOfThree([8, 6, 7, 1, 0]) == '8760')
    print(sol.largestMultipleOfThree([3, 6, 5, 2, 0]) == '630')
    print(sol.largestMultipleOfThree([0,0,0,0,0,0]) == '0')
    print(sol.largestMultipleOfThree([1]) == '')

if __name__  == '__main__':
    main()
