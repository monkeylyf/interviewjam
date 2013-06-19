# Given the equation y = x ^ (x >> n)
# Both y and x are 32 bit integer and n is betwee [0, 31]
# Given y and n, what's the value of x?

def calc_x(y, n):
    assert n <= 31
    assert n >= 0
    # print 'binary form', '{0:b}'.format(y)
    a = [ '{0:b}'.format(y)[x:x+n] for x in range(0,len('{0:b}'.format(y)), n)]
    # print 'a', a
    for i in range(1, len(a)):
        a[i] = '{0:b}'.format(int(str(a[i]), 2) ^ int(str(a[i - 1]), 2)).zfill(n)
    return int(''.join(a), 2)


def calc_y(x, n):
    return x ^ (x >> n)


def hacky(y, n):
    #return reduce(lambda a, b: (a >> n) ^ b , [0] + [ y for _ in range(0, 32, n) ])
    return reduce(lambda a, b: (a >> n) ^ b , [ y for _ in range(0, 32, n) ])


def main():
    for i in range(10, 15):
        for n in range(1, 32):
            assert i == hacky(calc_y(i, n), n)
    

if __name__ == '__main__':
    main()
