class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        
        for(int i = 0; i< s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i),0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((x,y) -> (freqMap.get(y)- freqMap.get(x)));
        
        pq.addAll(freqMap.keySet());
        
        
        StringBuffer res = new StringBuffer();
        
        while(!pq.isEmpty()) {
            char current = pq.poll();
            int freq = freqMap.get(current);
            for(int i = 0; i<freq ; i++) {
                res.append(current);
            }
            
        }
        
        return res.toString();
        
        
        
        
    }
}