# https://leetcode.com/problems/iterator-for-combination/

class CombinationIterator:

    def __init__(self, characters: str, combinationLength: int):
        self.char = characters
        self.n = len(self.char)
        self.len = combinationLength
        self.pointers = list(range(combinationLength))
        self.has_next = combinationLength <= self.n

    def next(self) -> str:
        s = ''.join(self.char[i] for i in self.pointers)
        i = self.len - 1
        carry = True
        while carry and i >= 0:
            self.pointers[i] += 1
            if self.pointers[i] >= self.n - (self.len - i - 1):
                carry = True
                self.pointers[i] = 0
                i -= 1
            else:
                carry = False
        self.has_next = i >= 0
        if self.has_next:
            for j in range(i + 1, self.len):
                self.pointers[j] = self.pointers[j - 1] + 1
        return s

    def hasNext(self) -> bool:
        return self.has_next


def main():
    combinator = CombinationIterator("abcde", 3)
    while combinator.hasNext():
        print(combinator.next())


if __name__ == '__main__':
    main()
