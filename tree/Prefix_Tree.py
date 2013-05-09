from collections import defaultdict

 
class Trie:

    def __init__(self):
        self.root = defaultdict(Trie)
        self.value = None
 
    def add(self, s, value):
        """Add the string 'string' to the 
        'Trie' and map it to the given value."""
        #global nops
        #nops += 1
        head, tail = s[0], s[1:]
        cur_node = self.root[head]
        if not tail:
            cur_node.value = value
            return  # No further recursion
        self.root[head].add(tail, value)
 
    def lookup(self, s, default=None):
        """Look up the value corresponding to 
        the string 's'."""
        #global nops
        #nops += 1
        head, tail = s[0], s[1:]
        node = self.root[head]
        if tail:
            return node.lookup(tail)
        return node.value or default
 
    def remove(self, s):
        """Remove the string s from the Trie. 
        Returns *True* if the string was a member."""
        #global nops
        #nops += 1
        head, tail = s[0], s[1:]
        try:
            node = self.root[head]
        except KeyError:
            return False  # Not contained
        if tail:
            return node.remove(tail)
        else:
            del node
            return True
 
    def prefix(self, s):
        """Check whether the string 's' is a prefix 
        of some member."""
        head, tail = s[0], s[1:]
        try:
            node = self.root[head]
        except KeyError:
            return False
        else:
            return node.prefix(tail)
 
    def items(self):
        """Return an iterator over the items of the 'Trie'."""
        for char, node in self.root:
            if node.value is None:
                yield node.items
            else:
                yield node


def main():
    obj = Trie()
    for str in ["cat", "cate", "apple", "pear", "av", "haha", "great"]:
        obj.add(str, 'shit')

    
    for str in ["cat", "cate", "apple", "pear", "av", "haha", "great"]:
        print obj.lookup(str)


if __name__ == '__main__':
    main()
