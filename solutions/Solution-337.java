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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] values = dfs(root);
        return Math.max(values[0], values[1]);
    }
    
    public int[] dfs(TreeNode node){
        int[] vals = new int[2];
        if(node == null) return vals;
        int[] leftVals = dfs(node.left);
        int[] rightVals = dfs(node.right);
        vals[0] = Math.max(leftVals[0], leftVals[1]) + Math.max(rightVals[0], rightVals[1]);
        vals[1] = node.val + leftVals[0] + rightVals[0];
        return vals;
    }
}/*
class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int ans = Math.max(dfs(root, true), dfs(root, false));
        return ans;
    }
    
    public int dfs(TreeNode node, boolean isRobbed){
        if(isRobbed){
            if(node.left != null && node.right != null){
                return dfs(node.left, false) + dfs(node.right, false) + node.val;
            }else if(node.left == null && node.right != null){
                return dfs(node.right, false) + node.val;
            }else if(node.right == null && node.left != null){
                return dfs(node.left, false) + node.val;
            }else{
                return node.val;
            }
        }else{
            if(node.left != null && node.right != null){
                return Math.max(dfs(node.left, true), dfs(node.left, false)) +
                    Math.max(dfs(node.right, true), dfs(node.right, false));
            }else if(node.left == null && node.right != null){
                return Math.max(dfs(node.right, true), dfs(node.right, false));
            }else if(node.right == null && node.left != null){
                return Math.max(dfs(node.left, true), dfs(node.left, false));
            }else{
                return 0;
            }
        }
    }
}
*/