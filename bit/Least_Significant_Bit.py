# Least Significant Bit
# For example:
# Hex   Binary  LSB
# 6     110     2
# 11    1011    1
#
#
# http://en.wikipedia.org/wiki/Least_significant_bit
#

def lsb(num):
    if num % 2 == 1:
        return 1
    ret = 1
    while num % 2 == 0:
        num /= 2
        ret += 1
    return ret



if __name__ == '__main__':
    # test case
    assert(lsb(6) == 2)
    assert(lsb(11) == 1)
