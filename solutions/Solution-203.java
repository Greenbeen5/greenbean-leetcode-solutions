/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode cur = head;
        ListNode last = null;
        while(cur != null){
            if(cur.val == val){
                if(last == null){
                    head = cur.next;
                    cur = cur.next;
                }else{
                    last.next = cur.next;
                    cur = cur.next;
                }
            }else{
                if(last == null){
                    last = cur;
                    cur = cur.next;
                }else{
                    last = last.next;
                    cur = cur.next;
                }
            }
        }
        return head;
    }
}