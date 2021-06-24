package leetcode;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/8/21 11:17 AM
 */
public class T0011_MaxWaterContainer {

    public static void main(String[] args) {
        T0011_MaxWaterContainer t = new T0011_MaxWaterContainer();
        System.out.println(t.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 两个值之间宽度是固定的，水的高度以小的那个为准（短板效应）
     * 双指针法：移动长的一端肯定不如上次的体积大，所以每次移动较短的一端，才可能找到最大体积
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(height[left] * (right - left), max);
                left++;
            } else {
                max = Math.max(height[right] * (right - left), max);
                right--;
            }
        }
        return max;
    }
}
