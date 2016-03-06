"""Geohash

http://en.wikipedia.org/wiki/Geohash
"""


def encode(longitute, latitude, precision=50):
    """
    """
    mapping = [
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'b', 'c', 'd', 'e', 'f', 'g', 'h',
        'j', 'k', 'm', 'n', 'p', 'q', 'r',
        's', 't', 'u', 'v', 'w', 'x', 'y',
        'z'
    ]

    if longitute[-1] == 'E':
        longitute = float(longitute[:-1])
    elif longitute[-1] == 'W':
        longitute = -float(longitute[:-1])
    else:
        raise ValueError('Invalid longitute format: {}'.format(longitute))

    if latitude[-1] == 'N':
        latitude = float(latitude[:-1])
    elif latitude[-1] == 'S':
        latitude = -float(latitude[:-1])
    else:
        raise ValueError('Invalid latitude format: {}'.format(latitude))

    longi_start = -180.0
    longi_end = 180.0
    lati_start = -90
    lati_end = 90.0
    # Use bytearray for better space usage.
    bits = [None] * (precision * 2)

    for i in xrange(precision):
        # longitute
        longi_idx = 2 * i
        longitute_mid = (longi_start + longi_end) / 2
        if longitute <= longitute_mid:
            bits[longi_idx] = '0'
            longi_end = longitute_mid
        else:
            bits[longi_idx] = '1'
            longi_start = longitute_mid

        # latitude
        lati_idx = 2 * i + 1
        latitude_mid = (lati_start + lati_end) / 2
        if latitude <= latitude_mid:
            bits[lati_idx] = '0'
            lati_end = latitude_mid
        else:
            bits[lati_idx] = '1'
            lati_start = latitude_mid

    geohash = []
    for i in xrange(0, len(bits), 5):
        # Encode every 5 bits into a char predefined.
        encoded = mapping[int(''.join(bits[i:i + 5]), 2)]
        geohash.append(encoded)
    return ''.join(geohash)


def main():
    assert encode('73.97W', '40.78N') == 'dr5ruzb8wnfr6wsqtd9q'
    assert encode('73.96993203W', '40.75815170N', 52) == 'dr5rugb9rwjj22ybhc2w3'


if __name__ == '__main__':
    main()
