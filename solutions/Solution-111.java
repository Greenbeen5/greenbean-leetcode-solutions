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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return getMinDepth(root, 1);
    }
    
    public int getMinDepth(TreeNode node, int depth){
        if(node.left != null && node.right != null){
            return Math.min(getMinDepth(node.left, depth + 1), getMinDepth(node.right, depth + 1));
        }else if(node.left != null){
            return getMinDepth(node.left, depth + 1);
        }else if(node.right != null){
            return getMinDepth(node.right, depth + 1);
        }else{
            return depth;
        }
    }
}