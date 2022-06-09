class TimeMap {
    HashMap<String, TreeMap<Integer, String>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> vals = store.getOrDefault(key, new TreeMap<>());
        vals.put(timestamp, value);
        store.put(key, vals);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> vals = store.get(key);
        if(vals == null) {
            return "";
        }
        String res = vals.get(timestamp);
        if(res != null) {
            return res;
        }
        
        int start = vals.firstKey();
        if(start > timestamp) {
            return "";
        }
        
        return vals.floorEntry(timestamp).getValue();
  
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */