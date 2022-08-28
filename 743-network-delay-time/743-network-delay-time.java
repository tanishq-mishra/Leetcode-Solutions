class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] costs = new int[n];
        
        Arrays.fill(costs, 100000000);
        
        costs[k-1] = 0;
        // for(int i = 0; i<costs.length; i++) {
        //     System.out.print(costs[i] + "  ");
        // }
        for(int i = 0; i<n-1; i++) {
            
            
            for(int[] t: times) {
                int source = t[0]-1;
                int destination = t[1]-1;
                int cost = t[2];
                if(costs[source] == 100000000)
                    continue;
                costs[destination] = Math.min(costs[destination], costs[source] + cost);
            }

            
        }
        
        int max = -100000000;
        for(int i = 0; i<n; i++) { 
            max = Math.max(max, costs[i]);
        }
        
        return max == 100000000? -1 : max;
    }
}