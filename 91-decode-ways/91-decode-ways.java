class Solution {
    HashMap<String, Integer> memo = new HashMap<>();
    public int helper(String s) {
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        if(s.length() == 1 && s.charAt(0) != '0') {
            return 1;
        }
        if(s.length() == 0) {
            return 1;
        }
        if(s.charAt(0) == '0') {
            return 0;
        }
        
        int value = Integer.parseInt(s.substring(0, 2));
        
        if(value % 10 == 0 && value <=20) {
            memo.put(s, helper(s.substring(2)));
            return memo.get(s);
        }
        
        if(value <=26) {
            memo.put(s, helper(s.substring(1))+ helper(s.substring(2)));
            return memo.get(s);
            
        } else {
            memo.put(s, helper(s.substring(1)));
            return memo.get(s);
        }
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }
         return helper(s);
        
    }
}