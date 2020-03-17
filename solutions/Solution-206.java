/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        boolean flag = true;
        if(cur == null){
            return null;
        }
        stack.push(null);
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(!stack.isEmpty()){
            cur = stack.pop();
            if(cur != null){
                cur.next = stack.peek();
            }
            if(flag){
                head = cur;
                flag = false;
            }
        }
        return head;
    }
}