"""hackerrank_standardize_mobile_number_using_decorator

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/standardize-mobile-number-using-decorators
"""

def number_formatter(func):
    def inner(number):
        template = '+91 {0} {1}'
        first, second = number[:5], number[5:]
        number = template.format(first, second)

        res = func(number)
        return res

    return inner

@number_formatter
def print_number(n):
    print n


def main():
    n = int(raw_input())
    numbers = []
    for _ in xrange(n):
        number = raw_input()
        numbers.append(number)

    numbers = map(lambda x : x[-10:], numbers)
    for number in sorted(numbers):
        print_number(number)

if __name__ == '__main__':
    main()
