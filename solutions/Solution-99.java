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
    private TreeNode[] targets = new TreeNode[2];
    private boolean findFirst = false;
    private TreeNode possibleSecond;
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        midTrav(root,stack);
        if(targets[1] == null) targets[1] = possibleSecond;
        swapVal(targets);
    }
    
    public void midTrav(TreeNode cur, Deque<TreeNode> stack){
        if(cur.left != null){
            midTrav(cur.left, stack);
        }
        if(stack.size()!=0){
            TreeNode last = stack.peek();
            if(!findFirst && last.val > cur.val){
                targets[0] = last;
                possibleSecond = cur;
                findFirst = true;
            }else if(findFirst && last.val > cur.val){
                targets[1] = cur;
            }
        }
        stack.push(cur);
        if(cur.right != null){
            midTrav(cur.right, stack);
        }
    }
    
    public void swapVal(TreeNode[] nodes){
        int tmp = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = tmp;
    }
}