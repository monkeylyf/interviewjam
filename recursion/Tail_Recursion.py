# Explain what is tail recursion and implement reverse a list using functional programming style




def rev(a):
    """Tail recursion.
    
    rev([0, 1, 2, 3])
      nested([], [0, 1, 2, 3])
      nested([0] + [], [1, 2, 3])
      nested([1] + [0], [2, 3])
      nested([2] + [1, 0], [3])
      nested([3], [2, 1, 0], [])
      [3, 2, 1, 0]
    [3, 2, 1, 0]
    """
    # Nested function.
    def nested(acc, a):
        # Notice that [a[0]] + acc instead of [a[0]] + acc
        return  nested([a[0]] + acc, a[1:]) if a else acc

    return nested([], a)


def re(a):
    """None tail recursion.
   
    What happens in call stack.
    re([0, 1, 2, 3])
    re([1, 2, 3,]) + 0
    (re([2, 3,]) + 1) + 0
    ((re([3]) + 2) + 1) + 0
    (((re([]) + 3) + 2) + 1) + 0
    (((3) + 2) + 1) + 0
    ((5) + 1) + 0
    6 + 0
    6
    """
    return re(a[1:]) + [a[0]] if a else []


def main():
    n = 500
    # Test case
    print rev(range(n))
    print re(range(n))


if __name__ == '__main__':
    main()
