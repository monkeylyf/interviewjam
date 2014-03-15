# hackerrank_Manasa_loves_Maths
#
# https://www.hackerrank.com/contests/mar14/challenges/manasa-loves-maths



def make_trie(words):
    _end = '_end_'
    root = dict()
    for word in words:
        current_dict = root
        for letter in word:
            current_dict = current_dict.setdefault(letter, {})
        current_dict = current_dict.setdefault(_end, None)
    return root


def in_trie(trie, word):
    current_dict = trie
    for letter in word:
        if letter in current_dict:
            current_dict = current_dict[letter]
        else:
            return False
    return '_end_' in current_dict


def solve(num, prefix_tree):
    # Nested function.
    def dfs(level, acc):
        if level == 3 or all(used):
            return in_trie(prefix_tree, acc)
        else:
            for idx, digit in enumerate(arr):
                if not used[idx]:
                    used[idx] = True

                    res = dfs(level + 1, acc + arr[idx])
                    if res:
                        return res

                    used[idx] = False
            return False


    arr = [ digit for digit in str(num) ]
    print arr
    used = [ False for _ in xrange(len(arr)) ]
    print 'YES' if dfs(0, '') else 'NO'


def main():
    # Create prefix tree:
    last_three_digits = [ str(i * 8) for i in xrange(125) ]
    prefix_tree = make_trie(last_three_digits)
    
    T = int(raw_input())
    for _ in xrange(T):
        num = int(raw_input())
        solve(num, prefix_tree)


if __name__ == '__main__':
    main()
