package LinkedList;

public class ReverseLinkedList {
    public ListNode reverse(ListNode head){
        ListNode prev, curr, nxt;
        prev = null;
        curr = head;
        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
