class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        
        for(int i = 0; i< s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i),0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((x,y) -> (y.getValue()- x.getValue()));
        
        for(Map.Entry<Character, Integer> m : freqMap.entrySet()) {
            pq.add(m);
        }
        
        
        StringBuilder res = new StringBuilder();
        
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> current = pq.poll();
            
            for(int i = 0; i< current.getValue(); i++) {
                res.append(current.getKey());
            }
            
        }
        
        return res.toString();
        
        
        
        
    }
}