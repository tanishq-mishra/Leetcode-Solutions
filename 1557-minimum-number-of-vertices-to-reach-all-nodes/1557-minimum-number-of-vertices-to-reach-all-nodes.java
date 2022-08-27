class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(List<Integer> e :edges) {
            visited[e.get(1)] = true;
        }
        
        for(int i = 0; i< visited.length; i++) {
            if(!visited[i]) {
                res.add(i);
            }
        }
        
        
        
        return res;
    }
}