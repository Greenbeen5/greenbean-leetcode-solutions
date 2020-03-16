/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        ListNode head = null;
        ListNode last = null;
        while(l1 != null && l2 != null){
            int cur = l1.val + l2.val + up;
            up = 0;
            if(cur > 9){
                up = cur / 10;
                cur = cur - up*10;
            }
            if(head == null){
                head = new ListNode(cur);
                last = head;
            }else{
                ListNode node = new ListNode(cur);
                last.next = node;
                last = node;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1 != null ? l1 : l2;
        while(remain != null){
            int cur = remain.val + up;
            up = 0;
            if(cur > 9){
                up = cur / 10;
                cur = cur - up*10;
            }
            if(head == null){
                head = new ListNode(cur);
                last = head;
            }else{
                ListNode node = new ListNode(cur);
                last.next = node;
                last = node;
            }
            remain = remain.next;
        }
        if(up != 0){
            last.next = new ListNode(up);
        }
        return head;
    }
}