"""hackerrank_decorator2_name_directory

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/decorators-2-name-directory
"""

def name_directory_formatter(func):
    def inner(content):
        (_, _, first_name, last_name, sex) = content
        content = '{0} {1} {2}'.format('Mr.' if sex == 'M' else 'Ms.',
                                        first_name,
                                        last_name)

        res = func(content)
        return res
    return inner


@name_directory_formatter
def print_name_directory(content):
    print content


def main():
    n = int(raw_input())
    names = []
    for i in xrange(n):
        number = raw_input()
        (first_name, last_name, age, sex) = number.split()
        names.append((age, i, first_name, last_name, sex))

    map(print_name_directory, sorted(names))


if __name__ == '__main__':
    main()

