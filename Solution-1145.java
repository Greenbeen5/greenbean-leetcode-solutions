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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        boolean ans;
        TreeNode X = findX(root,x);
        int lControl = traverse(X.left);
        int rControl = traverse(X.right);
        int other = n - lControl - rControl-1;
        if(other>n/2 || lControl>n/2 || rControl > n/2){
            ans = true;
        }
        else{
            ans = false;
        }
        return ans;
        
    }
    public int traverse(TreeNode start){
        if(start == null){
            return 0;
        }
        else{
            return traverse(start.left)+traverse(start.right)+1;
        }
    }
    public TreeNode findX(TreeNode rt, int x){
        if(rt == null){
            return rt;
        }
        else if(rt.val == x){
            return rt;
        }
        else{
            TreeNode xNode = findX(rt.left,x);
            if(xNode ==null){
                xNode = findX(rt.right,x);
            }
            return xNode;
        }
    }
}