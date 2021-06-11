package leetcode;

import java.util.*;

/**
 * @author 张涛
 * @date 6/10/21 10:30 AM
 */
public class T0015_ThreeSum {

    public static void main(String[] args) {
        T0015_ThreeSum t = new T0015_ThreeSum();
        System.out.println(t.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                Integer c = map.get(0 - nums[i] - nums[j]);
                if (c != null && c > j) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[c]));
                }
            }
        }
        return result;
    }


}
