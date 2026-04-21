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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return ;

        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode prev=null;
        ListNode curr=slow.next;
        slow.next=null;

        while(curr!=null){
            ListNode nextnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        ListNode first=head;
        ListNode second=prev;

        while(second!=null){
            ListNode t1=first.next;
            ListNode t2=second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }
}
