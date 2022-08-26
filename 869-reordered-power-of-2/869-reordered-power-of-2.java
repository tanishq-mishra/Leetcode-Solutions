class Solution {
    public boolean isValid(int n) {
        
        if(n ==0) {
            return false;
        }
        if(n == 1) {
            return true;
        }
        while(n>1 && n% 2 == 0) {
            n/=2; 
        }
        
        return n == 1;
    }
    
    public boolean helper(ArrayList<Integer> digits, int current, boolean[] visited, int count) {
        if( count == digits.size()) {
            return isValid(current);
        }
        
        for(int i = 0; i< digits.size(); i++) {
            if(current == 0 && digits.get(i) == 0 || visited[i]) {
                continue;
            }
            
            
            visited[i] = true;
            //System.out.println(current);
            if(helper(digits, (current*10) + digits.get(i), visited, count+1)) {
                return true;
            }
            visited[i] = false;
        }
        
        return false;
    }
    public boolean reorderedPowerOf2(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        int val = n ;
        while(val > 0) {
            digits.add(val%10);
            val/=10;
        }
        //System.out.println(digits);
        
        
        
        return helper(digits, 0, new boolean[digits.size()], 0);
    }
} 