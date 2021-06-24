package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author 张涛
 * @date 6/24/21 5:52 PM
 */
public class T0042_GetRainWater {

    public static void main(String[] args) {
        T0042_GetRainWater t = new T0042_GetRainWater();
        System.out.println(t.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }


    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int ans = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int l = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > l) {
                l = height[i - 1];
            }
            leftMax[i] = l;
        }
        int r = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i + 1] > r) {
                r = height[i + 1];
            }
            rightMax[i] = r;
        }
        for (int i = 1; i < height.length - 1; i++) {
            if (leftMax[i] > height[i] && rightMax[i] > height[i]) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return ans;
    }
}
