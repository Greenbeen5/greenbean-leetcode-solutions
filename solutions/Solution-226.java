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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    
    private void invert(TreeNode node){
        if(node != null){
            invert(node.left);
            invert(node.right);
            TreeNode l = node.left;
            node.left = node.right;
            node.right = l;
        }
    }
}