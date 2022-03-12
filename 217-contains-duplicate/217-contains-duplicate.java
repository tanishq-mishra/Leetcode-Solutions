class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(!set.add(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        
        
        return false;
    }
}