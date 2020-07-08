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
    int accu = -2147483648;
    public TreeNode convertBST(TreeNode root) {
        trav(root);
        return root;
    }
    
    public void trav(TreeNode node){
        if(node != null){
            trav(node.right);
            if(accu == -2147483648){
                accu = node.val;
            }else{
                node.val += accu;
                accu = node.val;
            }
            trav(node.left);
        }
    }
}