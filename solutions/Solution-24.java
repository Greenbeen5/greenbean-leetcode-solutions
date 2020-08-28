/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode last = null;
        ListNode cur = head;
        ListNode adj = head.next;
        while(adj != null){
            if(last == null){
                cur.next = adj.next;
                adj.next = cur;
                last = cur;
                cur = last.next;
                head = adj;
                adj = (cur == null ? null : cur.next);
            }else{
                cur.next = adj.next;
                adj.next = cur;
                last.next = adj;
                last = cur;
                cur = last.next;
                adj = (cur == null ? null : cur.next);
            }
        }
        return head;
    }
}