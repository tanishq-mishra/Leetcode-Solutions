class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int maxReach = startFuel;
       
        PriorityQueue<Integer> stationsReached = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        int stops = 0;
        int i = 0;
        while(maxReach < target) {
            while(i < stations.length && maxReach >= stations[i][0]) {
                stationsReached.add(stations[i][1]);
                i++;
            }
            if(stationsReached.isEmpty()) {
                return -1;
            }
            maxReach += stationsReached.poll();
            stops++;
            
        }
        
        return stops;
    }
}