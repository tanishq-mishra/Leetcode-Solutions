class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> keys = new ArrayList<>();
        keys.addAll(rooms.get(0));
        HashSet<Integer> usedKeys = new HashSet<>();
        
        usedKeys.add(0);
        
        
        while(!keys.isEmpty()) {
            List<Integer> newKeys = new ArrayList<>();
            while(!keys.isEmpty()) {
                int key = keys.get(0);
                keys.remove(0);
                usedKeys.add(key);
                
                newKeys.addAll(rooms.get(key));
            }
            
            for(int key : newKeys) {
                if(!usedKeys.contains(key)) {
                    keys.add(key);
                }
            }
            
            
        }

        return (usedKeys.size() == rooms.size());
    }
    

}


