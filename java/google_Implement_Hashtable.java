/*Implement_Hashtable
google

Design the data strcuture for Hashtable. Write methods to implement Insert and
Find.
*/


class google_Implement_Hashtable {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable(10);
        for (char i = 'a'; i <= 'z'; ++i) {
            ht.put(i + "", i);
            System.out.println(ht);
        }
        for (char i = 'a'; i <= 'z'; ++i) {
            System.out.println(ht.remove(i + ""));
            System.out.println(ht);
        }
    }
}

class Hashtable {
    private Item[] itemArray;
    private int capacity;
    private int size;
    //private static final Item AVAILABLE = new Item("Available", null);
    public Hashtable(int capacity) {
        // __init__
        this.size = 0;
        this.capacity = capacity; 
        itemArray = new Item[capacity];
    }
    public int size() {
        return size;
    }
    public int hash(String key) {
        return key.hashCode() % capacity; 
    }
    public Object get(String key) {
        int hashValue = hash(key);
        Item curItem = itemArray[hashValue];
        while (curItem != null && curItem.key() != key) {// why use != to determine? call by preference?
            // itemArray[hashValue] != AVAILABLE --> it's taken.
            // itemArray[hashValue].key() == key --> same key/value pair.
            curItem = curItem.next;
        }
        if (curItem == null) {
            return null; // curItem loops to end and didn't find key. No such existing key.
        } else {
            return curItem.element();
        }
    }
    public void put(String key, Object element) {
        //System.out.println("Put key: " + key + " /value: " + element);
        if (key != null) {
            int hashValue = hash(key);
            //System.out.println("Original hashvalue " + hashValue);
            if (itemArray[hashValue] == null) {
                itemArray[hashValue] = new Item(key, element);
            } else {
                Item curItem = itemArray[hashValue];
                //System.out.println("Hashvalue collision. Rotated to next node.");
                while (curItem.next != null && curItem.next.key() != key) {
                    curItem = curItem.next;
                    //System.out.println("Hashvalue collision. Rotated to next node.");
                }
                curItem.next = new Item(key, element);
            }
            ++this.size;
        }
    }
    public Object remove(String key) {
        int hashValue = hash(key);
        System.out.println("Removing key " + key + " with value " + hashValue);
        if (itemArray[hashValue] == null) {
            return null; // empty bucket. Key/value pair doesn't exist.
        }
        Item curItem = itemArray[hashValue];
        Item dummy = new Item("dummy", "dummy");
        dummy.next = curItem;
        Item prev = dummy; 
        while (curItem != null) {
            if (curItem.key().equals(key)) {
                prev.next = curItem.next;
                itemArray[hashValue] = dummy.next;
                --this.size;
                return curItem.element();
            }
            curItem = curItem.next;
            prev = prev.next;
        }
        return null;

    }
    public String toString() {
        StringBuilder s = new StringBuilder("<HashTable[");
        int i = 0;
        int count = 0;
        //System.out.println("size " + this.size);
        while (count < this.size) {
            Item curItem = itemArray[i];
            while (curItem != null) { //Skip the AVAILABLE cells.
                s.append(curItem.toString());
                if (count < this.size() - 1) {
                    s.append(",");
                }
                curItem = curItem.next;
                ++count;
            }
            ++i;
        }
        s.append("]>");
        return s.toString();
    }
}


class Item {
    private String key;
    private Object element;
    public Item next;
    public Item(String key, Object element) {
        this.setKey(key);
        this.setElement(element);
        this.next = null; // Use of LinkedList to handle hash collision.
    }
    public String key() {
        return key;
    }
    public Object element() {
        return element;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public void setElement(Object element) {
        this.element = element;
    }
    public String toString() {
        return "<Item(" + this.key() + "," + this.element() + ")>";
    }
}
