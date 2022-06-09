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
        Map.Entry<Integer, String> res = vals.floorEntry(timestamp);
        if(res != null) {
            return res.getValue();
        }
        return "";
  
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */