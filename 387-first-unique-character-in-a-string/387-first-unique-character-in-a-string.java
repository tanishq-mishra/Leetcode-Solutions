class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, List<Integer>> freqMap = new HashMap<>();
        
        
        for(int i = 0; i<s.length(); i++) {
            char current = s.charAt(i);
            if(freqMap.containsKey(current)) {
                List<Integer> temp = freqMap.get(current);
                temp.set(1, temp.get(1)+1);
            } else {
                List<Integer> temp = new ArrayList<>();
                
                temp.add(i);
                temp.add(1);
                freqMap.put(current, temp);
            }
        }
        int minIndex = s.length()+1;
        for(Map.Entry<Character, List<Integer>> entry: freqMap.entrySet()) {
            if(entry.getValue().get(1) == 1){
                minIndex = Math.min(minIndex, entry.getValue().get(0));
            }
        }
        
        
        return minIndex == s.length()+1 ? -1: minIndex;
        
    }
}