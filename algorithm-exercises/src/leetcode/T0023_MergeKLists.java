package leetcode;

import java.util.*;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @author 张涛
 * @date 6/17/21 5:13 PM
 */
public class T0023_MergeKLists {

    public static void main(String[] args) {
        T0023_MergeKLists t = new T0023_MergeKLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[]{l1, l2,l3};
        System.out.println(t.mergeKLists(listNodes));
    }


    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> listNodeComparable = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        if (lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue(lists.length, listNodeComparable);
        ListNode head = new ListNode(-1);
        ListNode current = head;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            priorityQueue.add(lists[i]);
        }
        ListNode i = null;
        while (!priorityQueue.isEmpty()) {
            current.next = priorityQueue.poll();
            current = current.next;
            if (current.next != null) {
                priorityQueue.add(current.next);
            }
        }
        return head.next;
    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode head = new ListNode(-1);
//        ListNode current = head;
//        if (lists.length == 0) {
//            return null;
//        }
//        Map<Integer, ListNode> map = new HashMap<>();
//        for (int i = 0; i < lists.length; i++) {
//            if (lists[i] != null){
//                map.put(i, lists[i]);
//            }
//        }
//        ListNode minNode;
//        while (map.size() != 0) {
//            int minValueIdx = -1;
//            for (Map.Entry<Integer, ListNode> entry : map.entrySet()) {
//                if (minValueIdx == -1 || entry.getValue().val < map.get(minValueIdx).val) {
//                    minValueIdx = entry.getKey();
//                }
//            }
//            if (minValueIdx == -1) {
//                break;
//            }
//            minNode = map.get(minValueIdx);
//            current.next = minNode;
//            current = current.next;
//            if (minNode.next == null) {
//                map.remove(minValueIdx);
//            } else {
//                map.put(minValueIdx, minNode.next);
//            }
//        }
//        return head.next;
//    }

    static class ListNode {
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
