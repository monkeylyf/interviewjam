def justify(n, s):
    s = s.strip().split(' ')
    index = 1
    cur_line = [s[0]]
    flag = len(s[0])
    while index < len(s):
        if flag + 1 + len(s[index]) <= n:
            cur_line.append(s[index])
            flag += len(s[index]) + 1
        else:
            #print 'debug ', cur_line
            print space_control(cur_line, n)
            cur_line = [s[index]]
            flag = len(s[index])
        index += 1
    print ' '.join(cur_line) + ' ' * (n - len(cur_line))


def space_control(cur_line, n):
    L = n - len(''.join(cur_line))
    if len(cur_line) == 1:
        return cur_line[0] + ' ' * (n - len(cur_line[0]))
    num_of_space = len(cur_line) - 1
    div, mod = divmod(L, num_of_space)
    str = []
    for i in range(num_of_space):
        space = div + 1if i < mod else div
        str.append(cur_line[i] + ' ' * space)
    str.append(cur_line[num_of_space])
    return ''.join(str)


def main():
    justify(10, "The quick brown fox jumped over the lazy dog.")
    justify(17, "Now is the time for all good men to come to the aid of their country")



if __name__ == '__main__':
    main()
