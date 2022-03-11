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
    public void helper(TreeNode root, List<List<Integer>> avg, int currentLevel) {
        if(root == null) {
            return;
        }
        
        if(avg.size() < currentLevel) {
            List<Integer> newLevel = new ArrayList<>();
            newLevel.add(root.val);
            avg.add(newLevel);
        } else {
            List<Integer> temp = avg.get(currentLevel-1);
            temp.add(root.val);
        }
        
        helper(root.left, avg, currentLevel+1);
        helper(root.right, avg, currentLevel+1);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> avg = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        
        
        helper(root, avg, 1);
        for(List<Integer> a : avg) {
            double d = 0;
            for(int i : a) {
                d += (double)i;
            }
            d = d/a.size();
            ans.add(d);
        }

        return ans;
    }
}