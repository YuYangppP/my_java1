package Linkedlist.eighty2Three;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName DeleteDuplicates.java
 * @Description TODO
 * @Date 2019/11/14 22:40
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void print(ListNode node){
        if (node == null){
            System.out.println("链表为空");
            return;
        }
        while (node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        DeleteDuplicates d = new DeleteDuplicates();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        print(d.deleteDuplicates(l1));

    }
}
