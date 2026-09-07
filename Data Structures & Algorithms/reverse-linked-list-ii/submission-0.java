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
    public ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode temp=new ListNode(0);
       temp.next=head;
       if(head.next==null || left==right) return head;

       ListNode res=temp;
       for(int i=1;i<left;i++){
        res=res.next;
       } 
       ListNode curr=res.next;
       for(int i=0;i<right-left;i++){
        ListNode nextnode=curr.next;
        curr.next=nextnode.next;
        nextnode.next=res.next;
        res.next=nextnode;
       }
       return temp.next;
    }
}