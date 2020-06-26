/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> valSet = new HashSet<>();
        ListNode cur = head;
        if(cur == null) return head;
        valSet.add(cur.val);
        while(cur.next != null){
            if(!valSet.contains(cur.next.val)){
                valSet.add(cur.next.val);
                cur = cur.next;
            }else{
                cur.next = cur.next.next;
            }
        }
        return head;
    }
}