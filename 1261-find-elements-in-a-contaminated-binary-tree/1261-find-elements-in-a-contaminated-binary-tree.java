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
class FindElements {
    
    BitSet nodeSet ;
    public FindElements(TreeNode root) {
        
        nodeSet = new BitSet();
        
        addNodes(root, 0);
    }


    public void addNodes(TreeNode current, int val) {
        if(current == null) {
            return;
        }
        nodeSet.set(val);
        
        addNodes(current.left, (val * 2) + 1);
        addNodes(current.right, (val * 2) + 2);
        
        
    }
    public boolean find(int target) {
        
        return nodeSet.get(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */