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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.offer(root);
        while(queue.size() != 0){
            int levelCount = queue.size();
            long levelSum = 0L;
            for(int i = 0; i<levelCount; ++i){
                TreeNode cur = queue.poll();
                levelSum += (long)cur.val;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add((double)levelSum / (double)levelCount);
        }
        return res;
    }
}