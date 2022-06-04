

class LRUCache {
    int capacity;
    Map<Integer, Integer> list;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new LinkedHashMap<Integer, Integer>(){
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
            {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        
        Integer value = list.get(key);
        if(value == null) {
            return -1;
        }
        list.remove(key);
        list.put(key, value);
        
        return value;
    }
    
    public void put(int key, int value) {
        
        if(list.containsKey(key)) {
            list.remove(key);
        }
        list.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */