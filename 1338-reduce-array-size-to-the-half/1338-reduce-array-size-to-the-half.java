class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        
        for(int i = 0; i< arr.length;i++) {
            freqMap.put(arr[i],(freqMap.getOrDefault(arr[i], 0))+1);
        }
        
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b) -> (Integer.compare(b,a)));
        for(int e : freqMap.values()) {
            pq.add(e);
        }
        
        int tbd = 0;
        int count = 0;
        while(tbd <arr.length/2) {
            tbd += pq.poll();
            count++;
        }
        
        return count;
    }
}