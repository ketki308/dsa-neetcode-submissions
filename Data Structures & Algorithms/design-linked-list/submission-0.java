class ListNode{
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val){
        this.val=val;
        this.next=null;
        this.prev=null;
    }
}
class MyLinkedList {
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
        head=new ListNode(0);
        tail=new ListNode(0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int index) {
        ListNode cur=head.next;
        while(cur!=null && index>0){
            cur=cur.next;
            index--;
        }
        if(cur!=null && cur!=tail && index==0){
            return cur.val;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        ListNode node=new ListNode(val);
        ListNode next=head.next;
        ListNode prev=head;
        prev.next=node;
        next.prev=node;
        node.next=next;
        node.prev=prev;
    }
    
    public void addAtTail(int val) {
        ListNode node=new ListNode(val);
        ListNode next=tail;
        ListNode prev=tail.prev;
        prev.next=node;
        next.prev=node;
        node.next=next;
        node.prev=prev;
    }
    
    public void addAtIndex(int index, int val) {
        ListNode cur=head.next;
        while(cur!=null && index>0){
            cur=cur.next;
            index--;
        }
        if(cur!=null && index==0){
            ListNode node=new ListNode(val);
            ListNode next=cur;
            ListNode prev=cur.prev;
            prev.next=node;
            next.prev=node;
            node.next=next;
            node.prev=prev;
        }
    }
    
    public void deleteAtIndex(int index) {
        ListNode cur=head.next;
        while(cur!=null && index>0){
            cur=cur.next;
            index--;
        }   
        if(cur!=null && cur!=tail && index==0){
            ListNode next=cur.next;
            ListNode prev=cur.prev;
            next.prev=prev;
            prev.next=next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */