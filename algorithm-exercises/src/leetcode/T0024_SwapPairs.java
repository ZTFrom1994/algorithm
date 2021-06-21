package leetcode;

import leetcode.data.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author 张涛
 * @date 6/21/21 1:27 PM
 */
public class T0024_SwapPairs {

    public static void main(String[] args) {
        T0024_SwapPairs t = new T0024_SwapPairs();
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        t.swapPairs(l);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode k = new ListNode(1);
        k.next = head;
        ListNode current = k;
        while (current != null && current.next != null && current.next.next != null) {
            ListNode t1 = current.next;
            ListNode t2 = current.next.next;
            ListNode t3 = current.next.next.next;
            current.next = t2;
            t2.next = t1;
            t1.next = t3;
            current = t1;
        }
        return k.next;
    }
}
