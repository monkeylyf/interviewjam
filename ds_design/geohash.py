"""Geohash

http://en.wikipedia.org/wiki/Geohash
"""

from base64 import b32encode


def encode(longitute, latitude, precision=50):
    """
    """
    mapper = {0: '0', 1: '1', 2: '2', 3: '3', 4: '4', 5: '5', 6: '6', 7: '7', 8: '8', 9: '9',
           10: 'b', 11: 'c', 12: 'd', 13: 'e', 14: 'f', 15: 'g', 16: 'h',
           17: 'j', 18: 'k', 19: 'm', 20: 'n', 21: 'p', 22: 'q', 23: 'r',
           24: 's', 25: 't', 26: 'u', 27: 'v', 28: 'w', 29: 'x', 30: 'y',
           31: 'z'}


    if longitute[-1] == 'E':
        longitute = float(longitute[:-1])
    elif longitute[-1] == 'W':
        longitute = -float(longitute[:-1])
    else:
        raise ValueError('Invalid longitute format: {0}'.format(longitute))

    if latitude[-1] == 'N':
        latitude = float(latitude[:-1])
    elif latitude[-1] == 'S':
        latitude = -float(latitude[:-1])
    else:
        raise ValueError('Invalid latitude format: {0}'.format(latitude))

    (longi_start, longi_end) = (-180.0, 180.0)
    (lati_start, lati_end) = (-90.0, 90.0)
    bits = []

    for _ in xrange(precision):
        #print (longi_start, longi_end)
        #print (lati_start, lati_end)
        # longitute
        longitute_mid = (longi_start + longi_end) / 2
        if longitute <= longitute_mid:
            bits.append('0')
            longi_end = longitute_mid
        else:
            bits.append('1')
            longi_start = longitute_mid

        # latitude 
        latitude_mid = (lati_start + lati_end) / 2
        if latitude <= latitude_mid:
            bits.append('0')
            lati_end = latitude_mid
        else:
            bits.append('1')
            lati_start = latitude_mid
  
    #print bits
    geohash = []
    for i in xrange(0, len(bits), 5):
        geohash.append(int(''.join(bits[i : i + 5]), 2))
    #print geohash
    return ''.join(map(lambda x : mapper[x], geohash))


def main():
    print encode('73.97W', '40.78N')
    print encode('73.96993203W', '40.75815170N')


if __name__ == '__main__':
    main()
