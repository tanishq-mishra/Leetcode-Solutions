/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int getMaxIndex(int [] nums, int start, int end) {
        int max = start;
        
        for(int i = start; i<=end; i++) {
            if(nums[i] > nums[max]) {
                max = i;
            }
        }
        
        return max;
    }
    
    public TreeNode helper(int[] nums, int start, int end) {
        
        if(start>end) {
            return null;
        }
    
        int maxIndex = getMaxIndex(nums, start, end);
        TreeNode current = new TreeNode(nums[maxIndex]);
        
        
        current.left = helper(nums, start, maxIndex-1);
        current.right = helper(nums, maxIndex +1, end);
        
        return current;
        
        
        
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
}