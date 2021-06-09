package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/2/21 1:12 PM
 */
public class T0003_LengthOfLongestSubstring {

    public static void main(String[] args) {
        T0003_LengthOfLongestSubstring t = new T0003_LengthOfLongestSubstring();
        System.out.println(t.lengthOfLongestSubstring("1923421367892331"));
    }

    /**
     * 分别设置2个指针 left和right left标识当前子串起点，right表示当前子串扩展的位置，right不断向右侧扩展，同时判断left和right之间的值是否和新扩展到的字符重复，
     * 如果right向右移动到k位置，发现和left-right之间的j位置有重复，left跳至j+1，right继续向右拓展。跳到j+1的原因是j+1和right之间肯定是一个不重复的子串，只需要在此基础上继续扩展即可
     * 这里用map存储已经遍历过的字符和其下标位置
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int maxLength = 1;
        Map<Character, Integer> handled = new HashMap<>();
        int left = 0;
        int right = 0;
        while (left < chars.length && right < chars.length && (chars.length - left > maxLength)) {
            Integer index = handled.get(chars[right]);
            if (index != null && index >= left) {
                maxLength = Math.max(right - left, maxLength);
                left = index + 1;
            } else {
                maxLength = Math.max(right - left + 1, maxLength);
                handled.put(chars[right], right);
                right++;
            }
        }
        return maxLength;
    }
}
