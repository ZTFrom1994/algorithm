package leetcode;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/18/21 3:33 PM
 */
public class T0027_RemoveElement {

    public static void main(String[] args) {
        T0027_RemoveElement t = new T0027_RemoveElement();
        int[] i = new int[]{3, 2, 2, 3};
        System.out.println(t.removeElement(i, 3));
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == val) {
                int k = i + 1;
                while (k < nums.length && nums[k] == val) {
                    k++;
                }
                if (k == nums.length) {
                    return i;
                }
                nums[i] = nums[k];
                nums[k] = val;
            }
        }
        return i + 1;
    }
}
