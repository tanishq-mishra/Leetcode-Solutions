class Solution {
    public boolean helper(int current, HashSet<Integer> added, HashMap<Integer, List<Integer>>preMap, List<Integer> res, boolean[] visited) {
        if(added.contains(current)) {
            return true;
        }
        
        if(visited[current]) {
            return false;
        }
        
        visited[current] = true;
        
        List<Integer> pre = preMap.get(current);
        
        if(pre != null) {
            for(int p : pre) {
                if(!helper(p, added, preMap, res, visited)) {
                    return false;
                }
            }
        }
        
        res.add(current);
        added.add(current);
        visited[current] = false;
        
        return true;
    }
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        HashSet<Integer> added = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        
        for(int[] p : prerequisites) {
            List<Integer> pre = preMap.getOrDefault(p[0], new ArrayList<>());
            pre.add(p[1]);
            preMap.put(p[0], pre);
        }
        
            
        
        for(int i = 0; i<numCourses; i++) {
            
            if(!helper(i,added, preMap, res, visited)) {
                return new int[0];
            }
        }
        int[] resultArr = new int[res.size()];
        
        for(int i = 0; i< res.size(); i++) {
            resultArr[i] = res.get(i);
        }
        
        
        return resultArr;
        
    }
}