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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        queue.add(root);
        queue.add(null);
        ans.add(new ArrayList<>());
        
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current == null) {
                if(queue.isEmpty()) {
                    break;
                }
                ans.add(new ArrayList<>());
                queue.add(null);
            } else {
                ans.get(ans.size()-1).add(current.val);
                if(current.left !=null) {
                    queue.add(current.left); 
                }
                
                if(current.right !=null) {
                    queue.add(current.right); 
                }
            }
        }
        return ans;
    }
}