# Write a class DominoChecker that has a method called addBox(int[]) that 
# takes a box of five dominoes,
# described as a list of 10 integers (explained after), adds it to a 
# collection, 
# and returns true if a box with the same dominoes was already in the 
# collection and false otherwise.
# A box of dominoes is encoded as a list of 10 integers from 0 to 9, where a 
# pair of numbers represent a domino. 
# For example: 0,2,9,1,3,3,7,4,5,6 represents a box containing dominoes: (0,2)
# ; (9,1); (3,3); (7,4); (5,6).
# 
# hint: 1. domino (0, 2) is equivalent to ()
#       2. object should be able to track all added domino
# DominoChecker checker = new DominoChecker(???? up to you ???);
# checker.addBox("1234567811"); // returns false
# checker.addBox("1233445566"); // returns false
# checker.addBox("1233445566"); // returns true;
# checker.addBox("3344556612"); // returns true;
# checker.addBox("3344556621"); // returns true;


from sets import Set


class DominoChecker:
    
    def __init__(self):
        self.container = Set()

    def addBox(self, str):
        arr = [char for char in str]
        for i in range(10)[::2]:
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]

        arr = [Pair(arr[index], arr[index + 1])for index in range(10)[::2]]
        arr = sorted(sorted(arr, key=lambda pair: pair.x), key=lambda pair: pair.y)
        domino = ''.join([repr(pair) for pair in arr])
        if domino in self.container:
            return True
        else:
            self.container.add(domino)
            return False


class Pair:
    
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __repr__(self):
        return '{0}{1}'.format(self.x, self.y)


if __name__ == '__main__':
    cls = DominoChecker()
    print cls.addBox("1234567811")
    print cls.addBox("1233445566")
    print cls.addBox("1233445566")
    print cls.addBox("3344556612")
    print cls.addBox("3344556621")
