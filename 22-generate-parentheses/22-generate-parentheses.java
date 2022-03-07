class Solution {
    public HashSet<String> helper(String p , int n) {
        if(n == 0) {
            HashSet<String> ans = new HashSet<>();
            ans.add(p);
            return ans;
        }
        
        HashSet<String> fromBelowCall = new HashSet<>();
        
        if(p.length() == 0) {
            fromBelowCall.addAll(helper("()", n-1));
        } else {
            for(int i = 0; i< p.length(); i++) {
            
            fromBelowCall.addAll(helper(p.substring(0,i) + "()" + p.substring(i), n-1));
            }  
            
        }
        
        
        return fromBelowCall;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>(helper("",n));
        return ans;
    }
}