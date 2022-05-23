class Solution {
    
    public boolean dfs(HashMap<Integer, List<Integer>> preMap, int current, HashSet<Integer> visited, HashSet<Integer> alreadyTaken) {
        if(alreadyTaken.contains(current)) {
            return true;
        }
        if(visited.contains(current)) {
            return false;
        }
        
        visited.add(current);
        
        List<Integer> pre = preMap.getOrDefault(current, new ArrayList<>());
        
        for(int p : pre) {
            if(dfs(preMap, p, visited,alreadyTaken) == false) {
                return false;
            }
        }
        visited.remove(current);
        return true;
    }
    
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> alreadyTaken = new HashSet<>();
        
        
        
        for(int[] p : prerequisites) {
            List<Integer> pre = preMap.getOrDefault(p[0], new ArrayList<>());
            pre.add(p[1]);
            preMap.put(p[0], pre);
        }
        
        for(int i = 0; i<numCourses; i++) {
            if(preMap.containsKey(i)) {
                visited.clear();
                if(dfs(preMap, i, visited, alreadyTaken) == false) {
                    return false;
                }
                alreadyTaken.add(i);
            }
        }
        
       return true;
        
    }
}