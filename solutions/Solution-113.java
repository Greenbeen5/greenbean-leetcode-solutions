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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        List<Integer> cur = new ArrayList<>();
        dfs(root, cur, sum);
        return res;
    }
    
    private void dfs(TreeNode t, List<Integer> l, int s){
        l.add(t.val);
        if(t.left==null && t.right == null){
            if(s - t.val == 0){
                res.add(new ArrayList<Integer>(l));
            }
        }else{
            if(t.left != null){
                dfs(t.left, l, s-t.val);
            }
            if(t.right != null){
                dfs(t.right, l, s-t.val);
            }
        }
        l.remove(l.size() - 1);
    }
}