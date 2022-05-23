class Solution {
    
    public boolean dfs(HashMap<Integer, List<Integer>> preMap, int current, boolean[] visited) {
        
        if(visited[current]) {
            return false;
        }
        
        
        List<Integer> pre = preMap.get(current);
        if(pre == null || pre.size() == 0) {
            return true;
        }
        
        visited[current] = true;
        
        
        for(int p : pre) {
            if(dfs(preMap, p, visited) == false) {
                return false;
            }
        }
        visited[current] = false;
        pre.clear();
        return true;
    }
    
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        
        
        for(int[] p : prerequisites) {
            List<Integer> pre = preMap.getOrDefault(p[0], new ArrayList<>());
            pre.add(p[1]);
            preMap.put(p[0], pre);
        }
        
        for(int i = 0; i<numCourses; i++) {
            if(preMap.containsKey(i)) {
                if(dfs(preMap, i, visited) == false) {
                    return false;
                }
            }
        }
        
       return true;
        
    }
}