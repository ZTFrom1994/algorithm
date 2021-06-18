package leetcode;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/18/21 3:05 PM
 */
public class T0026_RemoveDuplicates {

    public static void main(String[] args) {
        T0026_RemoveDuplicates t = new T0026_RemoveDuplicates();
        int[] i = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(t.removeDuplicates(i));
        System.out.println(Arrays.toString(i));
    }

    public int removeDuplicates(int[] nums) {
        int prev = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[prev]) {
                nums[prev + 1] = nums[i];
                prev++;
            }
        }
        return prev + 1;
    }
}
