/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in
 * the HashSet, do nothing.
 *
 * Example:
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 *
 * Note:
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */

fn main() {
    let key: i32 = 4;
    let mut obj = MyHashSet::new();
    obj.add(key);
    assert!(obj.contains(key));
    obj.remove(key);
    assert!(!obj.contains(key));
}

struct MyHashSet {
    container: [bool; 1_000_001]
}


/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MyHashSet {

    /** Initialize your data structure here. */
    fn new() -> Self {
        MyHashSet {
            container: [false; 1_000_001]
        }
    }

    fn add(&mut self, key: i32) {
        self.container[key as usize] = true;
    }

    fn remove(&mut self, key: i32) {
        self.container[key as usize] = false;
    }

    /** Returns true if this set contains the specified element */
    fn contains(&self, key: i32) -> bool {
        return self.container[key as usize];
    }
}
