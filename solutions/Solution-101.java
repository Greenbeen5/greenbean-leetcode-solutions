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
    boolean res = true;
    public boolean isSymmetric(TreeNode root) {
        trav(root,root);
        return res;
    }
    
    public void trav(TreeNode l, TreeNode r){
        if(l != null && r != null){
            if(l.val != r.val){
                res = false;
                return;
            }else{
                trav(l.left, r.right);
                trav(l.right, r.left);
            }
        }else if(l == null && r == null){
            return;
        }else{
            res = false;
            return;
        }
    }
}