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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode last = root;
        queue.offer(root);
        while(!queue.isEmpty()){
            last = queue.poll();
            if(last.right != null) queue.offer(last.right);
            if(last.left != null) queue.offer(last.left);
        }
        return last.val;
    }
}