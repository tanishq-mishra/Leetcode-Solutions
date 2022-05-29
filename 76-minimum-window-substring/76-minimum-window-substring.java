class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0) {
            return "";
        }
        
        HashMap<Character, Integer> sCount = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();
        
        for(int i = 0; i< t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) +1);
        }
        
        //System.out.println(tCount.size());
        
        int left = 0;
        int right = 0;
        int present = 0;
        
        int resLeft = 0;
        int resRight = 0;
        int reSize = Integer.MAX_VALUE;
        //System.out.println(tCount);
        for(right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            
            if(tCount.containsKey(current)) {
                
                sCount.put(current, sCount.getOrDefault(current, 0)+1);
                if(sCount.get(current).equals(tCount.get(current))) {
                    
                    present++;
                }
            }
            
            
            
            while(present == tCount.size()) {
                
                if(reSize > right-left+1) {
                    reSize = right-left+1;
                    resLeft = left;
                    resRight = right;
                }
                char currentLeft = s.charAt(left);
                left++;
                if(sCount.containsKey(currentLeft)) {
                    sCount.put(currentLeft, sCount.get(currentLeft)-1);
                    if(sCount.get(currentLeft) < tCount.get(currentLeft)) {
                        present--;
                    }
                }
                
            }
            
           
            
        }
        //System.out.println(present);
        
        
        
        return reSize != Integer.MAX_VALUE  ? s.substring(resLeft, resRight+1): "";
    }
}