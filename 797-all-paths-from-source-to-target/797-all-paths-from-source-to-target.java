class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int[][] graph, int current, List<Integer>path) {
        if(current == graph.length-1) {
            path.add(graph.length-1);
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        
        path.add(current);
        int[] neighbours = graph[current];
        
        for(int n : neighbours) {
            
            helper(graph, n, path);
            
        }
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        helper(graph, 0, new ArrayList<>());
        
        return res;
    }
}