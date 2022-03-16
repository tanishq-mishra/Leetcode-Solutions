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
    List<Integer> ans = new ArrayList<>();
    public void helper(TreeNode root) {
        
        if(root == null) {
            return;
        }
        ans.add(root.val);
        
        if(root.right == null) {
            helper(root.left);
        } else {
            helper(root.right);
        }
        
    }
    
    public List<Integer> rightSideView(TreeNode root) {
         Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        queue.add(root);
        queue.add(null);
        
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            if(current == null) {
                if(queue.isEmpty()) {
                    break;
                
                }
                queue.add(null);
                continue;
            } else if(queue.peek() == null) {
                
                ans.add(current.val);
            } 
                if(current.left !=null) {
                    queue.add(current.left); 
                }
                
                if(current.right !=null) {
                    queue.add(current.right); 
                }
            
        }
        
        return ans;
        
    }
}