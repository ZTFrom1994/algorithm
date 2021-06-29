package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @author 张涛
 * @date 6/29/21 1:28 PM
 */
public class T0046_AllArrange {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = arrange(nums, nums.length);
        return ans;
    }

    /**
     * 前n个数的全排列
     *
     * @param nums
     * @param n
     * @return
     */
    private List<List<Integer>> arrange(int[] nums, int n) {
        if (n == 1) {
            List<List<Integer>> l = new ArrayList<>();
            for (int i : nums) {
                l.add(Arrays.asList(i));
            }
            return l;
        }
        List<List<Integer>> hasArranged = arrange(nums, n - 1);
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> l : hasArranged) {
            for (int i : nums) {
                if (!l.contains(i)) {
                    List<Integer> s = new ArrayList<>(l);
                    s.add(i);
                    ans.add(s);
                }

            }
        }
        return ans;
    }
}
