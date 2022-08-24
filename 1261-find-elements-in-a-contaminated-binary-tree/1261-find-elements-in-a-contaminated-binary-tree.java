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
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        
        if(root != null) 
            root.val = 0;
        //deContaminate(root);
    }
    
//     public void deContaminate(TreeNode current) {
//         if(current == null)
//             return;
//         if(current.left != null) {
//             current.left.val = 2 * current.val + 1;
//         }
        
//         if(current.right != null) {
//             current.right.val = 2 * current.val + 2;
//         }
        
//         deContaminate(current.left);
//         deContaminate(current.right);
//     }
    

    public boolean seek(TreeNode current, int target) {
        if(current == null) {
            return false;
        }
        
        if(current.val == target) {
            return true;
        }
        
        if(current.left != null) {
            current.left.val = 2 * current.val + 1;
        }
        
        if(current.right != null) {
            current.right.val = 2 * current.val + 2;
        }
        
        return seek(current.right, target) || seek(current.left, target);
        
    }
    public boolean find(int target) {
        
        return seek(root, target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */