/*Implement_Set_With_RandomDelete
google

How would you define a data structure that stores a set of values (i.e., a
value cannot appear more than one time), and implements the following functions:

add(p)--adds the value p to the set
delete(p)--removes the value p from the set
getrandom()--returns a random value from the set (all items should be equally likely).
(Assume you have access to some nice random() function.)

All operations should be O(1) time complexity.


Duplicate:
Given a set, and functions insert(i), delete(i), count(i), size(), random. 
Design a data structure and implement PopRandom() to pop a random element 
from the set and return it.
*/


import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;


class google_Implement_Set_With_RandomDelete {
    public static void  main(String[] args) {
        randomSet set = new randomSet();
        for (char i = 'a'; i <= 'z'; ++i) {
            set.add(i);
        }
        for (char i = 'a'; i <= 'z'; ++i) {
            System.out.print(set.randomPop() + " ");
        }
        System.out.println();
    }
    private static class randomSet {
        private ArrayList<Object> arr;
        private HashMap<Object, Integer> map;
        randomSet() {
            arr = new ArrayList<Object>();
            map = new HashMap<Object, Integer>();
        }
        public void print() {
            System.out.println("ArrayList");
            System.out.println(arr);
            System.out.println("HashMap");
            for (Object i : map.keySet()) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (Object i : map.keySet()) {
                System.out.print(map.get(i) + " ");
            }
            System.out.println();
        }
        public void add(Object obj) {
            if (!map.containsKey(obj)) {
                arr.add(obj);
                map.put(obj, arr.size() - 1);
            }
        }
        public void delete(Object obj) {
            if (map.containsKey(obj)) {
                int index = map.get(obj);
                if (index < arr.size() - 1) {
                    // if obj is not the last element in arr.
                    // Swith obj and last element in arr.
                    Object last = arr.get(arr.size() - 1);
                    arr.set(index, last); // Update ArrayList
                    map.put(last, index); // Update HashMap
                }
                arr.remove(arr.size() - 1); // Remove the last element of arr.
                map.remove(obj); // Remove given obj from HashMap.
            } 
        }
        public int size() {
            return arr.size();
        }
        public Integer rand() {
            if (arr.size() == 0) {
                return null;
            } else {
                return new Random().nextInt(arr.size());
            }
        }
        public Object randomPop() {
            Integer r = rand();
            if (r == null) {
                return null;
            } else {
                Object obj = arr.get(r);
                delete(obj);
                return obj;
            }
        }
    }
}
