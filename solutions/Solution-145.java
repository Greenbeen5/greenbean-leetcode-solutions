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
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList<>();
        postTrav(root, post);
        return post;
    }
    
    private void postTrav(TreeNode n, List<Integer> out){
        if(n != null){
            postTrav(n.left, out);
            postTrav(n.right, out);
            out.add(n.val);
        }
    }
}