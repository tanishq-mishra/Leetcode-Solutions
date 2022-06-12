class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int helper(String s, int current) {
        if(memo.containsKey(current)) {
            return memo.get(current);
        }
        if(current == s.length()-1 && s.charAt(current) != '0') {
            return 1;
        }
        if(current == s.length()) {
            return 1;
        }
        if(s.charAt(current) == '0') {
            return 0;
        }
        
        int value = Integer.parseInt(s.substring(current, current+2));
        
        if(value % 10 == 0 && value <=20) {
            memo.put(current, helper(s, current+2));
            return memo.get(current);
        }
        
        if(value <=26) {
            memo.put(current, helper(s, current+1)+ helper(s, current+2));
            return memo.get(current);
            
        } else {
            memo.put(current, helper(s, current+1));
            return memo.get(current);
        }
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }
         return helper(s, 0);
        
    }
}