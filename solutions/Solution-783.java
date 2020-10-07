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
    public int minDiffInBST(TreeNode root) {
        List<Integer> trav = new ArrayList<>();
        traverse(root, trav);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i<trav.size()-1; ++i){
            minDiff = Math.min(trav.get(i+1) - trav.get(i), minDiff);
        }
        return minDiff;
    }
    
    private void traverse(TreeNode root, List<Integer> trav){
        if(root != null){
            traverse(root.left, trav);
            trav.add(root.val);
            traverse(root.right,trav);
        }
    }
}