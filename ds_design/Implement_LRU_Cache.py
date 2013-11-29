"""LRUCache implementation.

The implementation uses doubly linked list to store the cache record sequence,
which gives O(1) complexity for both insert and look up. However, this is not a
thread-safe cache.

Courtesy to yelin, the author of this.
"""


PREV = 0
NEXT = 1
KEY = 2
VALUE = 3

class LRUCache(object):

    """The base class for the LRU cache"""

    def __init__(self, max_objects=5000):
        """Initialize the basic data structures for LRU cache.

        : Parameters:
            - max_objects : the max number of records will be stored in the cache.
        """
        self.max_objects = max_objects
        self.cache = {}

        self.__reset() 

    def __len__(self):
        """Return the size of the cache.

        : Returns:
            - Length of the cache.
        """
        return len(self.cache)

    def __reset(self):
        """Create a dummy head node for doubly linked list."""
        self._lru_root = [None, None]
        self._lru_root[:] = [self._lru_root, self._lru_root] # Self-referencing.

        self.cache_size = 0

    def clear(self):
        """Empty the cache (invalidate all entries)."""
        self.cache.clear()
        # Clear everything except dummy head node of doubly linked list.
        del self._lru_root[:]
        self.__reset()

    def dump(self):
        """Print (key, value) pairs in the order of appearance in the list.

        The least recently used cache entry is printed first, most recently used
        entry last.

        Both key and value objects need to implement __repr__ function so that
        they can be printed.
        """
        curr = self._lru_root[NEXT]
        print '['
        while curr != self._lru_root:
            print '(%r, %r),' % (curr[KEY], curr[VALUE])
            curr = curr[NEXT]
        print ']'

    def keys(self):
        """Return the keys of the cache entries.

        : Returns:
            - A list of keys of the cached entries.
        """
        return self.cache.keys()

    def put(self, key, value):
        """Store the specific record into the cache.

        If the size of the cache exceeds max size, remove the least recently
        used record.

        : Parameters:
            - key: the key of the record to be inserted.
            - value: the value of the record to be inserted.
        """
        link = self.cache.get(key, None)
        if link is None:
            # Insert (key, value) if key is not found in the cache.
            last = self._lru_root[PREV]
            link = [last, self._lru_root, key, value]
            self._lru_root[PREV] = link
            last[NEXT] = link
            self.cache[key] = link
            self.cache_size += 1
            if self.cache_size > self.max_objects:
                self._erase(self._lru_root[NEXT])
        else:
            self._move_to_tail(link)
            link[VALUE] = value

    def get(self, key):
        """Look up the value for the requested key in the cache.

        Returns record if it is found, otherwise None.

        : Parameters:
            - key : the requested key of the record

        : Returns:
            - value of the corresponding key in the cache or None if key is not
              found.
        """
        if self.cache_size == 0: # Redumdant code?
            return None
        record = self.cache.get(key, None)
        if record is None:
            return None
        # Refresh the record.
        self._move_to_tail(record)
        return record[VALUE]

    def _erase(self, record):
        """Erase a record from both cache dict and lru list.

        : Parameters:
            - record : reference to the item to be removed.
        """
        old_prev, old_next, old_key, old_value = record
        old_prev[NEXT] = old_next
        old_next[PREV] = old_prev
        del record
        del self.cache[old_key]
        self.cache_size -= 1

    def _move_to_tail(self, record):
        """Move the most recent used record to the tail of the cache list.

        : Parameters:
            - record: the requested record which will be moved to the tail of the
                      cache list.
        """
        link_prev, link_next, key, value = record
        link_prev[NEXT] = link_next
        link_next[PREV] = link_prev
        last = self._lru_root[PREV]
        self._lru_root[PREV] = record
        last[NEXT] = record
        record[PREV] = last
        record[NEXT] = self._lru_root


if __name__ == '__main__':
    import unittest

    class TestLRUCache(unittest.TestCase):

        """Test class for LRUCache."""

        def test1_init(self):
            """Test the initilization method."""
            lc1 = LRUCache()
            self.assertEqual(lc1.max_objects, 5000)
            self.assertEqual(lc1.cache, {})
            self.assertEqual(lc1.cache_size, 0)
            lc2 = LRUCache(max_objects=1000)
            self.assertEqual(lc2.max_objects, 1000)
            self.assertEqual(lc2.cache, {})
            self.assertEqual(lc2.cache_size, 0)
            self.assertEqual(len(lc2), 0)

        def test2_put_get(self):
            """Test put and get methods. Dump cache states."""
            lc = LRUCache(max_objects=3)
            lc.put('key0', 'val0')
            self.assertEqual(lc.cache_size, 1)
            for i in range(1, 3):
                lc.put('key' + str(i), 'val' + str(i))
            # 0->1->2.
            lc.dump()
            self.assertEqual(lc.cache_size, 3)

            lc.put('key3', 'val3')
            # 1->2->3.
            lc.dump()
            self.assertEqual(lc.cache_size, 3)
            self.assertEqual(lc.get('key0'), None)
            res1 = lc.get('key1')
            self.assertEqual(res1, 'val1')
            res2 = lc.get('key2')
            self.assertEqual(res2, 'val2')
            res3 = lc.get('key3')
            self.assertEqual(res3, 'val3')
            # 1->2->3.
            lc.dump()

            lc.put('key3', 'val3')
            self.assertEqual(lc.cache_size, 3)
            self.assertNotEqual(lc.get('key1'), None)
            # 2->3->1, eject 2 when max capacity is reached.
            lc.dump()

            lc.put('key4', 'val4')
            self.assertEqual(lc.cache_size, 3)
            self.assertEqual(lc.get('key2'), None)
            # 3->1->4, eject 3 when max capacity is reached.
            lc.dump()

            lc.put('key5', 'val5')
            # 1->4->5.
            self.assertEqual(lc.get('key3'), None)

        def test3_clear(self):
            """Test clear method."""
            lc = LRUCache(max_objects=3)
            for i in range(0, 10):
                lc.put('key' + str(i), 'val' + str(i))
            lc.clear()
            self.assertEqual(lc.cache_size, 0)
            self.assertEqual(lc.cache, {})
            lc.dump()


    suite1 = unittest.TestLoader().loadTestsFromTestCase(TestLRUCache)
    unittest.TextTestRunner(verbosity=2).run(suite1)
