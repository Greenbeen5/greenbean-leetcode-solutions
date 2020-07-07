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
    private int valSum = 0;
    private boolean res = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        trav(root, sum);
        return res;
    }
    
    public void trav(TreeNode node, int sum){
        if(node == null){
            return;
        }
        valSum += node.val;
        if(valSum == sum && node.left==null && node.right == null){
            res = true;
        }
        trav(node.left, sum);
        trav(node.right, sum);
        valSum -= node.val;
    }
}