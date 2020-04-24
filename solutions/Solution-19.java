/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode front=head,cur,rear=null;
        for(int i = 0;i<n-1;i++){
            front = front.next;
        }
        if(front.next == null){
            head = head.next;
            return head;
        }
        cur = head;
        while(front.next != null){
            front = front.next;
            cur = cur.next;
            if(rear == null){
                rear = head;
            }else{
                rear = rear.next;
            }
        }
        rear.next = cur.next;
        return head;
    }
}