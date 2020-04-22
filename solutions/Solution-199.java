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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int leaves = 1;
        //ans.add(root.val);
        queue.addLast(root);
        while(queue.size() != 0){
            while(leaves-- != 0){
                TreeNode cur = queue.pollFirst();
                if(cur.left != null){
                    queue.addLast(cur.left);
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                }
                if(leaves == 0){
                    ans.add(cur.val);
                }
            }
            leaves = queue.size();
        }
        
        return ans;
    }
}