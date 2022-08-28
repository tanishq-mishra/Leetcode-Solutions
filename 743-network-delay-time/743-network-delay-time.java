class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] costs = new int[n];
        
        Arrays.fill(costs, 100000000);
        
        costs[k-1] = 0;
        // for(int i = 0; i<costs.length; i++) {
        //     System.out.print(costs[i] + "  ");
        // }
        for(int i = 0; i<n; i++) {
            
            
            for(int[] t: times) {
                int source = t[0]-1;
                int destination = t[1]-1;
                int cost = t[2];
                // if(costs[source] == Integer.MAX_VALUE)
                //     continue;
                costs[destination] = Math.min(costs[destination], costs[source] + cost);
            }
            // costs = temp;
            // for(int j= 0; j<costs.length; j++) {
            // System.out.print(costs[j] + "  ");
            // }
            // System.out.println();
            
        }
        
        int max = -100000000;
        for(int i = 0; i<n; i++) {
            //System.out.print(costs[i] + "  ");
            
            max = Math.max(max, costs[i]);
        }
        //System.out.println();
        
        return max == 100000000? -1 : max;
    }
}