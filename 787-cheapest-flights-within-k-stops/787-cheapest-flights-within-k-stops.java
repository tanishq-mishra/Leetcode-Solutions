// class Solution {
    
//     int res = Integer.MAX_VALUE;
//     public void helper(HashMap<Integer, List<List<Integer>>> graph, int current, int dest, HashSet<Integer> visited, int k, int cost) {
//         if(k == -1 && current!= dest) {
            
//             return;
//         }
        
//         if(current == dest) {
//             res = cost;
//             return;
//         }
//         if(visited.contains(current)) {
            
//             return;
//         }
        
//         visited.add(current);
//         List<List<Integer>> adjList = graph.get(current);
        
//         if(adjList != null) {
//             for(List<Integer> node :adjList) {
//                 if(cost+node.get(1) > res) 
//                     continue;
//                 helper(graph, node.get(0), dest, visited, k-1, cost+node.get(1));
//             }
//         }
        
        
//         visited.remove(current);
        
     
        
        
//     }
    
    
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         HashMap<Integer, List<List<Integer>>> graph = new HashMap<>();
//         for(int[] flight : flights) {
//             List<Integer> node = new ArrayList<Integer>();
            
//             node.add(flight[1]); // destination
//             node.add(flight[2]); // fare
            
//             List<List<Integer>> adjList = graph.getOrDefault(flight[0], new ArrayList<>());
//             adjList.add(node);
//             graph.put(flight[0], adjList);
//         }
        
//         helper(graph, src, dst,new HashSet<Integer>(), k, 0);
        
//         return res != Integer.MAX_VALUE ? res : -1;
//     }
// }



class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}