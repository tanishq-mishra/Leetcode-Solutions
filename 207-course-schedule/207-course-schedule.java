class Solution {
    
    public boolean dfs(HashMap<Integer, List<Integer>> preMap, int current, HashSet<Integer> visited) {
        
        if(visited.contains(current)) {
            return false;
        }
        
        
        List<Integer> pre = preMap.get(current);
        if(pre == null) {
            return true;
        }
        
        visited.add(current);
        
        
        for(int p : pre) {
            if(dfs(preMap, p, visited) == false) {
                return false;
            }
        }
        visited.remove(current);
        pre.clear();
        return true;
    }
    
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        //HashSet<Integer> alreadyTaken = new HashSet<>();
        
        
        
        for(int[] p : prerequisites) {
            List<Integer> pre = preMap.getOrDefault(p[0], new ArrayList<>());
            pre.add(p[1]);
            preMap.put(p[0], pre);
        }
        
        for(int i = 0; i<numCourses; i++) {
            if(preMap.containsKey(i)) {
                visited.clear();
                if(dfs(preMap, i, visited) == false) {
                    return false;
                }
            }
        }
        
       return true;
        
    }
}