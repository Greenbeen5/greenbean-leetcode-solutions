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
    public Integer max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Integer height = getHeight(root);
        if(height==0){
            return 0;
        }
        return max.intValue();

    }
    private Integer getHeight(TreeNode n){
        Integer r;
        Integer l;
        if(n.left == null && n.right==null){
            return 0;
        }else if(n.left != null && n.right == null){
            r = getHeight(n.left) + 1;
            max = max > r ? max : r;
            return r;
        }else if(n.left == null && n.right != null){
            r = getHeight(n.right) + 1;
            max = max > r ? max : r;
            return r;
        }else{
            r = getHeight(n.right) + 1;
            l = getHeight(n.left) + 1;
            max = max > r+l ? max : r+l;
            return Math.max(r,l);
        }
    }
}