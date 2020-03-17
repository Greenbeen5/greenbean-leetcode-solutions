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
    List<Integer> sequence = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        traverse(root);
        for(int i = 0;i<sequence.size()-1;i++){
            if(sequence.get(i) >= sequence.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public void traverse(TreeNode root){
        if(root.left != null){
            traverse(root.left);
        }
        if(root!=null){
            sequence.add(root.val);
        }
        if(root.right != null){
            traverse(root.right);
        }
    }
}