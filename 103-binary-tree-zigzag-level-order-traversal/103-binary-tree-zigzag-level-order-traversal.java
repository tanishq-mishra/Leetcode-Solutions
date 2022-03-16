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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean opposite = true;
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> level = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            
            if(current == null) {
                opposite = !opposite;
                if(q.isEmpty()) {
                    if(opposite) {
                        Collections.reverse(level);
                    }
                    ans.add(new ArrayList<>(level));
                    break;
                } else {
                    if(opposite) {
                        Collections.reverse(level);
                    }
                    ans.add(new ArrayList<>(level));
                    level.clear();
                    q.add(null);
                }
            } else {
                
                level.add(current.val);
                
                    if(current.left != null) {
                        q.add(current.left);
                    }
                    if(current.right != null) {
                        q.add(current.right);
                    }
                    
                
            }
        }
        
        
        return ans;
        
    }
}