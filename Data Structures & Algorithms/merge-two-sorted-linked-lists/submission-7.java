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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=new ListNode(0);
        ListNode dummy=head;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                dummy.next=list1;
                list1=list1.next;
            }else{
                dummy.next=list2;
                list2=list2.next;
            }
            dummy=dummy.next;
        }
        
        dummy.next=(list1!=null)?list1:list2;
        //• list1 != null (The Condition): It checks if there are still nodes left in the first list (list1).
        //• ? list1 (If True): If list1 is not empty, it chooses list1.
        //• : list2 (If False): If list1 is empty, it chooses list2.

        return head.next;

    }
}