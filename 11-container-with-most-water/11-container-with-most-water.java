class Solution {
    public int maxArea(int[] height) {
        int i =0;
        int j = height.length -1;
        int maxArea = Integer.MIN_VALUE;
        
        while(i < j) {
            
            int currentArea = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(currentArea, maxArea);
            
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            
        }
        
        return maxArea;
        
        
    }
}