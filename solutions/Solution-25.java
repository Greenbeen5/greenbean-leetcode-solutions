/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)return head;
        ListNode forward = head;
        ListNode cur = head;
        ListNode newHead = head;
        ListNode lastTail = null;
        ListNode lastForward = head;
        while(true){
            for(int i = 0; i<k; ++i){
                if(forward == null) return newHead;
                forward = forward.next;
            }
            //ListNode nextHead = forward;
            ListNode last = forward;
            ListNode front;
            while(cur.next != forward){
                front = cur.next;
                cur.next = last;
                last = cur;
                cur = front;
            }
            if(newHead == head) newHead = cur;
            cur.next = last;
            if(lastTail == null) lastTail = head;
            else{
                lastTail.next = cur;
                lastTail = lastForward;
            }
            cur = forward;
            lastForward = forward;
        }
        
    }
}