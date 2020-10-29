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
    int cur = 0;
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        trav(root);
        return sum;
    }
    private void trav(TreeNode node){
        cur += node.val;
        if(node.left == null && node.right == null){
            sum += cur;
        }else{
            if(node.left != null){
                cur *= 10;
                trav(node.left);
                cur /= 10;
            }
            if(node.right != null){
                cur *= 10;
                trav(node.right);
                cur /= 10;
            }
        }
        cur -= node.val;
    }
}