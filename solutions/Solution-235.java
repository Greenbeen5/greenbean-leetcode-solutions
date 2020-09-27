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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rv = root.val, pv = p.val, qv = q.val;
        if(rv == pv) return p;
        if(rv == qv) return q;
        if(rv < qv && rv > pv || rv > qv && rv < pv) return root;
        if(rv < qv && rv < pv) return lowestCommonAncestor(root.right, p, q);
        else if(rv > qv && rv > pv) return lowestCommonAncestor(root.left, p, q);
        else return null;
    }
}