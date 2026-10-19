class ListNode{
    String url;
    ListNode next;
    ListNode prev;

    ListNode(String url,ListNode prev,ListNode next){
        this.url=url;
        this.next=next;
        this.prev=prev;
    }
    ListNode(String val){
        this(val,null,null);
    }
}
class BrowserHistory {
    ListNode head;
    public BrowserHistory(String homepage) {
        head=new ListNode(homepage);
    }
    
    public void visit(String url) {
        head.next=new ListNode(url,head,null);
        head=head.next;
    }
    
    public String back(int steps) {
        while(head.prev!=null && steps>0){
            head=head.prev;
            steps--;
        }
        return head.url;
    }
    
    public String forward(int steps) {
        while(head.next!=null && steps>0){
            head=head.next;
            steps--;
        }
        return head.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */