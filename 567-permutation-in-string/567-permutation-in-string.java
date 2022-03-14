class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int windowSize = c1.length;
        
        int start = 0;
        int end = c1.length-1;
        boolean[] selected = new boolean[c1.length];
        
        while(end <c2.length) {
            int flag = 0;
            for(int i = 0 ; i<selected.length; i++) {
                selected[i] = false;
            }
            
            for(int i = 0 ; i< c1.length; i++) {
                for(int j = start; j<=end; j++) {
                    if(c1[i] == c2[j]) {
                        if(!selected[j%windowSize]) {
                            selected[j%windowSize] = true;
                            flag++;
                            break;
                        }
                        
                    }
                        
                }
            }
            if(flag == windowSize) {
                return true;
            }
            start = start + windowSize-flag;
            end = end + windowSize-flag;
            
        }
        
        
        return false;
    }
}