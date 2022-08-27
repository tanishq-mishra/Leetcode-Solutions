class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        double[] costs = new double[n+1];
        
        Arrays.fill(costs, Double.POSITIVE_INFINITY);
        
        costs[k] = 0;
        // for(int i = 0; i<costs.length; i++) {
        //     System.out.print(costs[i] + "  ");
        // }
        for(int i = 1; i<=n; i++) {
            
            
            for(int[] t: times) {
                int source = t[0];
                int destination = t[1];
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
        
        double max = Double.NEGATIVE_INFINITY;
        for(int i = 1; i<=n; i++) {
            //System.out.print(costs[i] + "  ");
            max = Math.max(max, costs[i]);
        }
        
        return max == Double.POSITIVE_INFINITY? -1 : (int)max;
    }
}