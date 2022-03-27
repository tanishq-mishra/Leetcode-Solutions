class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for(int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) +1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> (Integer.compare(y[0],x[0])));
        
        for(Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            int[] newNum = {e.getValue(), e.getKey()};
            pq.add(newNum);
        }
        
        
        int[] result = new int[k];
        
        for( int i=0; i<k;i++) {
            result[i] = pq.poll()[1];
        }
        
        return result;
        
        
    }
}