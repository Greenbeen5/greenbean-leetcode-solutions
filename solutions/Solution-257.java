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
    public List<String> binaryTreePaths(TreeNode root) {
        List<TreeNode> openStack = new LinkedList<>();
        List<String> res = new ArrayList<>();
        dfs(root, openStack, res);
        return res;
    }
    
    private void dfs(TreeNode node, List<TreeNode> stack, List<String> res){
        if(node != null){
            stack.add(0, node);
            if(node.left == null && node.right == null){
                addToRes(stack, res);
            }else{
                dfs(node.left, stack, res);
                dfs(node.right, stack, res);
            }
            stack.remove(0);
        }
        
    }
    
    private void addToRes(List<TreeNode> stack, List<String> res){
        StringBuilder sb = new StringBuilder();
        for(int i = stack.size() - 1; i>=0; --i){
            sb.append(String.valueOf(stack.get(i).val));
            if(i != 0) sb.append("->");
        }
        res.add(sb.toString());
    }
}