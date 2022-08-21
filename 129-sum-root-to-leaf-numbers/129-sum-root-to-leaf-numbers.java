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
    List<Integer> numbers;
    
    public void helper (TreeNode root, int number) {
        if(root == null) 
            return;
        if(root.left == null && root.right == null) {
            numbers.add((number*10)+ root.val);
            return;
        }
        helper(root.left, (number*10) + root.val);
        helper(root.right, (number*10) + root.val);
        
        
    }
    
    public int sumNumbers(TreeNode root) {
        numbers = new ArrayList<>();
        int sum = 0;
        helper(root, 0);
        
        //System.out.println(numbers);
        for(int num : numbers) {
            sum+=num;
        }
        
        return sum;
        
    }
}