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
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0, right = nums.length-1;
        TreeNode root = DFSConvert(nums, left, right);
        return root;
    }
    public TreeNode DFSConvert(int[] nums, int left, int right){
        if(left == right){
            TreeNode cur = new TreeNode(nums[left]);
            return cur;
        }else if(left > right){
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = DFSConvert(nums, left, mid-1);
        cur.right = DFSConvert(nums, mid+1, right);
        
        return cur;
    }
}