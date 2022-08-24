class MyHashMap {
    Integer[] values;
    public MyHashMap() {
        values = new Integer[1000001];
    }
    
    public void put(int key, int value) {
        values[key] = value;
    }
    
    public int get(int key) {
        if(values[key] == null || values[key] == -1){
            return -1;
        }
        return values[key] ;
    }
    
    public void remove(int key) {
        values[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */