class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        
        for(int i = 0; i< s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i),0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((x,y) -> (freqMap.get(y)- freqMap.get(x)));
        
        pq.addAll(freqMap.keySet());
        
        
        StringBuilder res = new StringBuilder();
        
        while(!pq.isEmpty()) {
            char current = pq.poll();
            
            for(int i = 0; i< freqMap.get(current); i++) {
                res.append(current);
            }
            
        }
        
        return res.toString();
        
        
        
        
    }
}