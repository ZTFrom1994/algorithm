package leetcode;

import leetcode.data.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例 1：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/1/21 2:37 PM
 */
public class T0001_TwoNumberAdd {

    /**
     * 就按照正常进位的逻辑写即可
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        int v = 0;
        while (l1 != null || l2 != null){
            int val = 0;
            if (l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                val += l2.val;
                l2 = l2.next;
            }
            val += v;
            v = 0;
            if (val >= 10){
                val = val - 10;
                v = 1;
            }
            if (current == null){
                result = new ListNode(val);
                current = result;
            }else {
                current.next = new ListNode(val);
                current = current.next;
            }
        }
        if (v == 1){
            current.next = new ListNode(1);
        }
        return result;
    }
}


