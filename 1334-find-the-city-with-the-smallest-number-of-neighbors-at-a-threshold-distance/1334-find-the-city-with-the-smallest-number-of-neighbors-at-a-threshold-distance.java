// Floyd Warshal

class Solution {
    public int findTheCity(int n, int[][] ed, int distanceThreshold) {
        int[] dist = new int[n];
        int minNeighbours = Integer.MAX_VALUE;
        int city = 0;
        List<int[]> edges = new ArrayList<>();
        
        for(int[] e : ed) {
            edges.add(new int[]{e[0], e[1], e[2]});
            edges.add(new int[]{e[1], e[0], e[2]});
            
        }
        
        
        
        
        for(int j = 0; j<n; j++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[j] = 0;
            for(int i = 0 ; i< n ; i++) {
                
                
                int[] temp = Arrays.copyOf(dist, n);
                for(int[] edge : edges) {
                    int curr = edge[0];
                    int next = edge[1];
                    int cost = edge[2];
                    if(temp[curr] == Integer.MAX_VALUE)
                        continue;
                    
                    temp[next] = Math.min(temp[next], temp[curr] + cost);
                }
                dist = temp;
            }
            
            int currentNeighbours = 0;
            int x = 0;
            for(int d : dist) {
                //System.out.println(j + " ->" +(x++)+" cost:" + d);
                if(d <= distanceThreshold) {
                    currentNeighbours++;
                }
            }
            //System.out.println("node:" + j +currentNeighbours)
            
            if(currentNeighbours <= minNeighbours) {
                minNeighbours = currentNeighbours; 
                city = Math.max(j, city);
            }
        }
        
        
        
        return city;
    }
}