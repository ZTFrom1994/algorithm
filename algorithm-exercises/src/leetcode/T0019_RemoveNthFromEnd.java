package leetcode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * @author 张涛
 * @date 6/16/21 9:56 AM
 */
public class T0019_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode toRemove = null;
        ListNode toRemovePrev = null;
        int gap = 0;
        while (current != null) {
            if (gap < n) {
                gap++;
            } else {
                if (toRemove == null) {
                    toRemove = head;
                } else {
                    toRemovePrev = toRemove;
                    toRemove = toRemove.next;
                }
            }
            current = current.next;
        }
        if (toRemovePrev == null) {
            return head.next;
        } else {
            toRemovePrev.next = toRemove.next;
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
