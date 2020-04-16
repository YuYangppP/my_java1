package test;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName ListNode.java
 * @Description TODO
 * @Date 2019/10/27 16:53
 */
public class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

class Solution{
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        ListNode head = new ListNode(1                                                                           );
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(6);
        ListNode forth = new ListNode(4);
        head.next = second;
        second.next = third;
        third.next = forth;
        ListNode result = ss.reverseList(head);
        System.out.println(result.val);
    }
}