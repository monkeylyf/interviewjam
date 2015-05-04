"""
"""

def main():
    test = int(raw_input())
    for t in xrange(test):
        max_shy, string = raw_input().split()
        max_shy = int(max_shy)
        audience = map(int, list(string))

        invited = 0
        for shy_lvl, num in enumerate(audience):
            if shy_lvl == 0:
                standing = audience[0]
                continue

            if num == 0:
                continue

            #print shy_lvl, num

            if standing >= shy_lvl:
                standing += num
            else:
                needed = shy_lvl - standing
                invited += needed
                standing += needed + num

            #print 'standing', standing
            #print 'invited', invited


        print 'Case #{}: {}'.format(t + 1, invited)



if __name__ == '__main__':
    main()
