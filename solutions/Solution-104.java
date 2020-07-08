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
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode node, int depth){
        if(node == null){
            return depth;
        }else{
            depth++;
            return Math.max(dfs(node.left, depth), dfs(node.right, depth));
        }
    }
}