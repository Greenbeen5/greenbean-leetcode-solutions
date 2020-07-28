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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> trav = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            while(cur.left != null && !visited.contains(cur.left)){
                stack.push(cur.left);
                cur = cur.left;
            }
            cur = stack.pop();
            trav.add(cur.val);
            visited.add(cur);
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        return trav;
    }
}