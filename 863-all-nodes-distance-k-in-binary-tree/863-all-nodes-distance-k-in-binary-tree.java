/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean found = false;
    HashMap<TreeNode, TreeNode> parents = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();
    List<Integer> ans = new ArrayList<>();
    public void setParents(TreeNode root, TreeNode parent) {
        if(root == null) {
            return ;
        }
        parents.put(root, parent);
        setParents(root.left, root);
        setParents(root.right, root);
    }
    public void getNodes(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        if(!visited.contains(root)) {
            visited.add(root);
            if(k == 0) {
                ans.add(root.val);
                return;
            } else {
                getNodes(root.left, k-1);
                getNodes(root.right, k-1);
                getNodes(parents.get(root), k-1);
            }
        }
        
       
        
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k == 0) {
            ans.add(target.val);
            return ans;
        }
        
        setParents(root, null);
        getNodes(target, k);
        
        return ans;
    }
}