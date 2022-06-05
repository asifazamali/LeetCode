package LinkedList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head2 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        ListNode node32 = new ListNode(5);
        ListNode node42 = new ListNode(6);
        head2.next = node22;
        node22.next = node32;
        node32.next = node42;
//        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
//        head = reverseLinkedList.reverse(head);
//        ListNode res = mergeTwoSortedList(head, head2);
//        ListNode res = removeElt(head, 1);
//        println(res);
//        System.out.println(hasCycle(head2));

        RandomNode randomNode1 = new RandomNode(1);
        RandomNode randomNode2 = new RandomNode(2);
        RandomNode randomNode3 = new RandomNode(3);
        RandomNode randomNode4 = new RandomNode(5);

        randomNode1.next = randomNode2;
        randomNode2.next = randomNode3;
        randomNode3.next = randomNode4;

        randomNode1.random = randomNode3;
        randomNode2.random = randomNode1;
        randomNode3.random = randomNode4;
        randomNode4.random = randomNode2;

        RandomNode res = copyList(randomNode1);
        println(randomNode1);
        println(res);

    }
    public static void println(RandomNode randomNode) {
        RandomNode curr = randomNode;
        while (curr != null) {
            System.out.println(curr + " " + curr.val + " " + curr.random);
            curr = curr.next;
        }
        System.out.println();
    }


    public static void println(ListNode head){
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode middleNode(ListNode head){
        ListNode slow, fast;
        slow = head;
        fast = head;
        /*
            1 -> 2 -> 3
         */
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoSortedList(ListNode list1, ListNode list2){
       ListNode  dummy = new ListNode(-1);
       ListNode temp = dummy;
       ListNode temp1 = list1;
       ListNode temp2 = list2;
       while(temp1 != null && temp2 != null){
           if(temp1.val <= temp2.val){
               temp.next = new ListNode(temp1.val);
               temp1 = temp1.next;
           }else{
               temp.next = new ListNode(temp2.val);
               temp2 = temp2.next;
           }
           temp = temp.next;
       }
       while(temp1 != null){
           temp.next = new ListNode(temp1.val);
           temp1 = temp1.next;
           temp = temp.next;
       }
       while(temp2 != null){
           temp.next = new ListNode(temp2.val);
           temp2 = temp2.next;
           temp = temp.next;
       }
       return dummy.next;
    }

    /*
       d-> 1-> 2 -> 2 -> 2 -> 3
     */

    private static ListNode removeElt(ListNode head, int val){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev, curr;
        prev = dummy;
        curr = head;
        while(curr != null){
            while(curr != null && curr.val == val){
                curr = curr.next;
            }
            prev.next = curr;
            if(curr == null) break;
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    private static boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    /*
    1-2-3-4
    1-1'- 2  -2'-3 - 3' - 4 - 4'

     */

    private static RandomNode copyList(RandomNode head){
        RandomNode curr= head;
        while(curr != null){
            RandomNode newNode = new RandomNode(curr.val);
            RandomNode nxt = curr.next;
            newNode.next = nxt;
            curr.next = newNode;
            curr = nxt;
        }
        curr = head;
        /*
       1-1'- 2  -2'-3 - 3' - 4 - 4'
       1' - 2'
         */
        while(curr != null){
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
/*
    d- 1-1'- 2  -2'-3 - 3' - 4 - 4'
    d -> 1 -> 2 -> 3 -> 4
     d -> 2
     1-> 3

 */
        RandomNode dummyNode = new RandomNode(-1);
        RandomNode temp = dummyNode;
        curr = head;
        while (curr != null){
            temp.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }


}
