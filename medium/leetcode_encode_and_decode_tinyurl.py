# https://vi.stackexchange.com/questions/9656/how-does-p-command-work-in-vim

import string
from random import choice

ALPHANUMERIC = string.ascii_lowercase + string.digits

class Codec:

    def __init__(self):
        self.long_to_short = {}
        self.short_to_long = {}

    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        short_url = self.long_to_short.get(longUrl)
        if short_url is None:
            code = ''.join(choice(ALPHANUMERIC) for _ in range(6))
            while code in self.short_to_long:
                code = ''.join(choice(ALPHANUMERIC) for _ in range(6))
            self.short_to_long[code] = longUrl
            short_url = f'http://tinyurl.com/{code}'
        return short_url

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        code = shortUrl[-6:]
        return self.short_to_long[code]


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))
