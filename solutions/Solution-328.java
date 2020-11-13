/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode oLast = null;
        if(head==null || head.next==null) return head;
        ListNode even = head.next;
        ListNode eHead = even;
        while(odd != null && even != null){
            odd.next = even.next;
            if(odd.next == null){
                oLast = odd;
            }
            odd = odd.next;
            if(odd != null){
                even.next = odd.next;
                even = even.next;
            }
        }
        if(oLast != null){
            oLast.next = eHead;
        }
        if(even == null){
            odd.next = eHead;
        }
        return head;
    }
}