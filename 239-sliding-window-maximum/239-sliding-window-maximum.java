class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] ans = new int[nums.length -k +1];
        int i = 0;
        int left = 0;
        int right = 0;
        
        while(right < nums.length) {
            
            while(deque.size() !=0 && nums[deque.peekLast()]< nums[right]) {
                deque.pollLast();
            }
            deque.add(right);
            if(left > deque.peekFirst()) {
                deque.pollFirst();
            }

            if(right +1 >= k) {
                ans[i++] = nums[deque.peekFirst()];
                right++;
                left++;
            } else {
                right++;
                
            }
        }
        
        
        
        return  ans;
        
    }
}