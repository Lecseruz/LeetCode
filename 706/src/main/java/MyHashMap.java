class MyHashMap
{
    static final int INITIAL_CAPACITY = 10000000;
    private MyEntry[] list = new MyEntry[INITIAL_CAPACITY];

    public static void main(String[] args)
    {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(112332, 2);
        myHashMap.put(1, 5);
        myHashMap.put(1, 3);
        myHashMap.remove(1);
        System.out.println(myHashMap.get(112332));
    }

    /** Initialize your data structure here. */
    public MyHashMap()
    {

    }

    /** value will always be non-negative. */
    public void put(int key, int value)
    {
        list[key] = new MyEntry(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key)
    {
        MyEntry entry = list[key];
        return entry == null ? -1 : entry.getValue();
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key)
    {
        list[key] = null;
    }

    class MyEntry
    {
        private int key;
        private int value;
        private MyEntry next;

        public MyEntry(int key, int value)
        {
            this.key = key;
            this.value = value;
        }

        public int getKey()
        {
            return key;
        }

        public void setKey(int key)
        {
            this.key = key;
        }

        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
        }

        public MyEntry getNext()
        {
            return next;
        }

        public void setNext(MyEntry next)
        {
            this.next = next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap(); obj.put(key,value);
 * int param_2 = obj.get(key); obj.remove(key);
 */