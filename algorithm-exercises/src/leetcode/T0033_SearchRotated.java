package leetcode;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/21/21 2:05 PM
 */
public class T0033_SearchRotated {

    public static void main(String[] args) {
        T0033_SearchRotated t = new T0033_SearchRotated();
        System.out.println(t.search(new int[]{1}, 1));
    }

    public int search(int[] nums, int target) {
        int i = 0;
        while (i >= 0 && i < nums.length) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target || (i + 1 < nums.length && nums[i] > nums[i + 1])) {
                int j = nums.length - 1;
                while (j > i) {
                    if (nums[j] == target) {
                        return j;
                    } else {
                        j--;
                    }
                }
                return -1;
            }else {
                i++;
            }
        }
        return -1;
    }
}
