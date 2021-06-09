package leetcode;

import javafx.scene.paint.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/2/21 3:20 PM
 */
public class T0004_FindMedianSortedArrays {

    public static void main(String[] args) {
        T0004_FindMedianSortedArrays t = new T0004_FindMedianSortedArrays();
        int[] num1 = new int[]{};
        int[] num2 = new int[]{2};
        System.out.println(t.findMedianSortedArrays(num1, num2));
    }


    /**
     * 最简单的做法：把两个有序数组合并排序，找中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int targetIndex = 0;
        if (totalLength % 2 == 0) {
            //总数为偶数情况，中位数是两个数的平均值
            targetIndex = (totalLength / 2) - 1;
        } else {
            targetIndex = (totalLength / 2);
        }
        List<Integer> list = new ArrayList<>();
        if (nums1.length == 0) {
            for (int i = 0; i < nums2.length; i++) {
                list.add(nums2[i]);
            }
        } else if (nums2.length == 0) {
            for (int i = 0; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
        } else if (nums1[0] > nums2[nums2.length - 1]) {
            for (int i = 0; i < nums2.length; i++) {
                list.add(nums2[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
        } else if (nums2[0] > nums1[nums1.length - 1]) {
            for (int i = 0; i < nums1.length; i++) {
                list.add(nums1[i]);
            }for (int i = 0; i < nums1.length; i++) {
                list.add(nums2[i]);
            }
        } else {
            int p1 = 0;
            int p2 = 0;
            while (p1 < nums1.length || p2 < nums2.length) {
                if (p1 == nums1.length) {
                    for (; p2 < nums2.length; p2++) {
                        list.add(nums2[p2]);
                    }
                    break;
                }
                if (p2 == nums2.length) {
                    for (; p1 < nums1.length; p1++) {
                        list.add(nums1[p1]);
                    }
                    break;
                }
                if (nums1[p1] < nums2[p2]) {
                    list.add(nums1[p1]);
                    p1++;
                } else {
                    list.add(nums2[p2]);
                    p2++;
                }
            }
        }

        if (totalLength % 2 != 0) {
            return list.get(targetIndex);
        } else {
            return (list.get(targetIndex) + list.get(targetIndex + 1)) / 2.0;
        }

    }
}
