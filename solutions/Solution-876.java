/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode normal = head;
        ListNode quick = head;
        while(quick.next != null){
            normal = normal.next;
            quick = quick.next;
            if(quick.next == null){
                return normal;
            }else{
                quick = quick.next;
            }
        }
        return normal;
    }
}