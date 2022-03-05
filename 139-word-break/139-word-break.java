class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        if(s.length() == 0) {
            return true;
        }
        boolean fromBelowCalls = false;
        for(String w : wordDict) {
            if(s.startsWith(w)) {
                fromBelowCalls = wordBreak(s.substring(w.length()), wordDict);
            }
            
            if(fromBelowCalls) {
                memo.put(s, true);
                return true;
            }
        }
        
        memo.put(s, false);
        return false;
    }
}