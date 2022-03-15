class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> deque = new LinkedList<Integer>();
        int[] ans = new int[nums.length -k +1];
        int i = 0;
        int left = 0;
        int right = 0;
        
        while(right < nums.length) {
            
            while(deque.size() !=0 && nums[deque.get(deque.size()-1)]< nums[right]) {
                deque.remove(deque.size()-1);
            }
            deque.add(right);
            if(left > deque.get(0)) {
                deque.remove(0);
            }

            if(right +1 >= k) {
                ans[i++] = nums[deque.get(0)];
                right++;
                left++;
            } else {
                right++;
                
            }
        }
        
        
        
        return  ans;
        
    }
}