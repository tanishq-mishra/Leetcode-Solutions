class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int maxDP = 1;
        int maxCount = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        for(int i = 1; i<nums.length; i++) {
            for(int j =0; j<i; j++) {
                if(nums[j] < nums[i] && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j]+1;
                    count[i]=count[j];
                } else if(nums[j] < nums[i] && dp[j]+1 == dp[i]) {
                    count[i]+=count[j];
                }
                
            }
            maxDP = Math.max(maxDP, dp[i]);
        }
        
        //System.out.println(maxDP);
        for(int i = 0; i<nums.length; i++) {
            if(dp[i] == maxDP) {
                maxCount += count[i];
            } 
            
        }
        
        return maxCount;
    }
}