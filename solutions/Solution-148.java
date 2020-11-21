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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((o1,o2) -> o1.val - o2.val);
        ListNode cur = head;
        while(cur != null){
            heap.add(cur);
            cur = cur.next;
        }
        head = heap.poll();
        cur = head;
        while(heap.size() > 0){
            cur.next = heap.poll();
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
}