package leetcode;

import leetcode.collection.ListNode;

public class LinkedNodeTest {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        LinkedNodeTest lnt = new LinkedNodeTest();
        lnt.addTwoNumbers(l1,l2);
    }

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode pre = new ListNode(0);
        ListNode d = pre;
        int sum = 0 ;
        while (c1 != null||c2 != null){
            if(c1 != null){
                sum += c1.val;
                c1 = c1.next;
            }

            if(c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }

            d.next = new ListNode(sum%10);
            sum /= 10;
            d = d.next;
        }
        if(sum ==1) d.next = new ListNode(1);
        System.out.println(pre.next.toString());
        return pre.next;
    }
}
