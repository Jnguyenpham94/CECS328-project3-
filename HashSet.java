import java.lang.reflect.Array;

// Implements the Map ADT using a hash table with separate chaining.
public class HashSet<T> {
    private class Entry {
        public T mKey;
        public boolean mIsNil;
    }

    private Entry[] mTable;
    private int mCount; // the number of elements in the set, i.e., "n"
    private int tableSize;

    // Constructs a hashtable with the given size.
    public void HashMap(int tableSize) {
        int power = 1;
        while (power < tableSize) {
            power *= 2;
        }
        tableSize = power;
        // The next line is a workaround for Java not liking us making an array
        // of a generic type. (Node is a generic type because it has generic
        // members.)
        mTable = (Entry[]) Array.newInstance(Entry.class, tableSize);

        // mTable's entries are all null initially.
        // mTable[i] == null ---> nothing has ever lived at index i
        // mTable[i] != null && mTable[i].mIsNil ---> something used to be here but was
        // removed.
    }

    // Inserts the given key and value into the table, assuming no entry with
    // an equal key is present. If such an entry is present, override the entry's
    // value.
    public void add(T key) {
        // Every object in Java has a .hashCode() function that computes a h(k)
        // value for that object. Use that function for your hash table index
        // calculations. Note that in Java, .hashCode() can be negative!!! --> use
        // absolute value.
        if (count() > loadFactor()) {
            HashSet<String> table = new HashSet<>();
            table.HashMap(tableSize * 2);

        }
        mCount++;
        // TODO: finish this method. You must NOT allow duplicates to be inserted.
    }

    // Returns true if the given key is present in the set.
    public boolean find(T key) {
        // Use the hash code and probing function to keep looking for this key until:
        // 1. you find a null element
        // 2. you find the key
        // 3. you fail n times.

        // TODO: finish this method
        return false;
    }

    // Removes the given key from the set.
    public void remove(T key) {
        // Use the hash code and probing function to keep looking for this key until:
        // 1. you find a null element
        // 2. you find the key
        // 3. you fail n times.

        // TODO: finish this method.
    }

    public int count() {
        return mCount;
    }

    public double loadFactor() {// load factor is .8 * size of table
        return tableSize * .8;
    }

}