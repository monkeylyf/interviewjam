/**
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value
 * already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if
 * this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the
 * mapping for the key.
 *
 * Example:
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Note:
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */

fn main() {
    let key: i32 = 2;
    let value: i32 = 4;
    let mut hashmap = MyHashMap::new();
    hashmap.put(key, value);
    assert_eq!(value, hashmap.get(key));
    hashmap.remove(key);
    assert_eq!(-1, hashmap.get(key));
}

struct MyHashMap {
    container: [i32; 1_000_001]
}


/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MyHashMap {

    /** Initialize your data structure here. */
    fn new() -> Self {
       MyHashMap {
           /* Due to its constaint, initialze an i32 array with max given size. */
           container: [-1; 1_000_001]
       }
    }

    /** value will always be non-negative. */
    fn put(&mut self, key: i32, value: i32) {
        self.container[key as usize] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fn get(&self, key: i32) -> i32 {
        return self.container[key as usize];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fn remove(&mut self, key: i32) {
        self.container[key as usize] = -1;
    }
}

/*
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.container = [None] * 1000001

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.container[key] = value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        existing = self.container[key]
        if existing is None:
            return -1
        else:
            return existing

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.container[key] = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
 */
