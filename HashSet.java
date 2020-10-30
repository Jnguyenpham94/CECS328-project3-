import java.lang.reflect.Array;

// Implements the Map ADT using a hash table with separate chaining.
public class HashSet<T> {
    private class Entry {
        public T mKey;
        public boolean mIsNil = false;

        private Entry(T key, boolean mIsNil) {
            this.mKey = key;
            this.mIsNil = mIsNil;
        }

        //TODO: find a way to display all of the words in the hash set not necessary for project apparently but still would be nice
        @Override
        public String toString(){
            return mTable.length + "\n";
        }
    }

    private Entry[] mTable;
    private int mCount; // the number of elements in the set, i.e., "n"
    public int tableSize;
    public int value;

    // Constructs a hashtable with the given size.
    public int HashMap(int tableSize) {
        int power = 1;
        while (power < tableSize || power == tableSize) {
            power *= 2;
        }
        this.tableSize = power;
        tableSize = this.tableSize;
        // The next line is a workaround for Java not liking us making an array
        // of a generic type. (Node is a generic type because it has generic
        // members.)
        mTable = (HashSet.Entry[]) Array.newInstance(Entry.class, tableSize);

        // mTable's entries are all null initially.
        // mTable[i] == null ---> nothing has ever lived at index i
        // mTable[i] != null && mTable[i].mIsNil ---> something used to be here but was
        // removed.
        return tableSize;
    }

    
    /**
     *  Inserts the given key and value into the table, assuming no entry with
     *  an equal key is present. If such an entry is present, override the entry's
     *  value.
     *  Every object in Java has a .hashCode() function that computes a h(k)
     *  value for that object. Use that function for your hash table index
     *  calculations. Note that in Java, .hashCode() can be negative!!! --> use
     *  absolute value.
     * @param key
     */
    public void add(T key) {
        // TODO: finish this method. You must NOT allow duplicates to be inserted.
        if (count() > loadFactor()) {
            HashMap(tableSize * 2);
            for(int i= 0; i < tableSize - 1; i++){
                add(key);
            }
        }
        if(find(key) == true){
            mTable[value] = new Entry(key, false);
            mCount++;
        }
    }

    /**
     *  Use the hash code and probing function to keep looking for this key until:
     *  1. you find a null element 
     *  2. you find the key 
     *  3. you fail n times.
     * 
     * @param key
     * @return true if the given key is present in the set. false otherwise
     */
    public boolean find(T key) {
        int i = 0;
        int m = 7;
        int probing = (i * i + i) / 2;
        value = Math.abs(key.hashCode());
        while (i < tableSize) {
            value += probing;
            value %= tableSize;
            if (mTable[value] == null) {// usually for add
                return true;
            } else if (key.equals(value)) { // for remove 
                return true;
            } else if (i == m) { // coprime value may need a smaller one
                return false;
            }
            i++;
        }
        return false;
    }

    // 
    /**
     * Removes the given key from the set.
     * Use the hash code and probing function to keep looking for this key until:
     * 1. you find a null element
     * 2. you find the key
     * 3. you fail n times.
     * @param key
     */
    public void remove(T key) {
        if(find(key) == true){
            mTable[value] = new Entry(key, true);
            mCount--;
        }
        else{
            System.out.println(key + " not found");
        }
    }

    public int getTableSize(){
        return tableSize;
    }

    public int count() {
        return mCount;
    }

    public double loadFactor() {// load factor is .8 * size of table
        return tableSize * .8;
    }

}