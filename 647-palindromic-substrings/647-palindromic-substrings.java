class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        char[] charArr = s.toCharArray();
        
        for(int i = 0; i<charArr.length; i++) {
            // odd length palindrome
            int x = i;
            int y = i;
            
            while(x >= 0 && y<charArr.length && charArr[x] == charArr[y]) {
                //System.out.println("odd" + "  " + x + "  " + y);
                x--;
                y++;
                res++;
            }
            
            
            // even length palindrome
            
            x = i;
            y = i+1;
            while(x >= 0 && y<charArr.length && charArr[x] == charArr[y]) {
                //System.out.println("even" + "  " + x + "  " + y);
                x--;
                y++;
                res++;
            }
        }
        
        
        return res;
        
    }
}