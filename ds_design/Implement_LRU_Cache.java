/*Implement_LRU_Cache

A cache is a mechanism by which future requests for that data are served faster
and/or at a lower cost.

Requirements
1. Fixed size: The cache needs to have some bounds to limit memory usage.
2. Fast access: O(1) cache insert and lookup operations.
3. Entry replacement algorithm: When the cache is full, the less useful cache
                                entries are purged from cache. The algorithm to
                                replace these entries is Least Recently Used (LRU)
                                or the cache entries which have not been accessed recently will be replaced.
*/

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class Implement_LRU_Cache {
    public static void main(String[] args) {
    }
    public static class LRUCache {
        private int capacity; // Maximum number of items in the cache.
        public LRUCache(int capacity) { 
            super(capacity+1, 1.0f, true); // Pass 'true' for accessOrder.
            this.capacity = capacity;
        }
        protected boolean removeEldestEntry(Entry entry) {
            return (size() > this.capacity);
        }
    }
}
