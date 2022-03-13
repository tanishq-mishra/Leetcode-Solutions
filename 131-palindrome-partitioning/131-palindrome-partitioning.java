class Solution {
    
    public boolean isPal(String s,int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        return true;
    }
    
    public void helper(List<List<String>> ans, List<String> currentList, String s, int currentIndex) {
        if(currentIndex >= s.length()) {
            ans.add(new ArrayList<>(currentList));
            return;
        }
        
        for(int i = currentIndex; i<=s.length()-1; i++) {
            String temp = s.substring(currentIndex,i+1);
            if(isPal(s, currentIndex, i)) {
                currentList.add(temp);
                helper(ans, currentList, s, i+1);
                currentList.remove(currentList.size()-1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        
        
        helper(ans, new ArrayList<>(), s, 0);
        
        return ans;
    }
}