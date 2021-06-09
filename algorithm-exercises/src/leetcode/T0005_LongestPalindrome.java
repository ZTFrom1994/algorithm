package leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/1/21 5:41 PM
 */
public class T0005_LongestPalindrome {

    public static void main(String[] args) {
        T0005_LongestPalindrome n = new T0005_LongestPalindrome();
        System.out.println(n.longestPalindrome("aaaaa"));
    }

    /**
     * 基本思路就是按顺序把每个字符当做中心字符向两边拓展，如果拓展出来两边的字符串不一样，可以停止拓展，如果长度超记录了，则记录下来
     * 这里考虑了两种情况，中心是一个字符还是两个字符，
     * 有一种巧妙的方法（这里没有实现），就是把每两个字符中间加入一个#字符（其他任意的字符都行）这样只需要考虑中心是一个字符的情况，因为添加了这种字符后，按中心对称拓展比较时，并不会将原来的字符和插入的字符比较，所以没有问题
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String maxStr = "";
        if (s.length() == 1) {
            return s;
        }
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                if (maxStr.length() < 2) {
                    maxStr = chars[i] + "" + chars[i + 1];
                }
                int left = i - 1;
                int right = i + 2;
                while (left >= 0 && right < chars.length) {
                    if (chars[left] == chars[right]) {
                        if (right - left >= maxStr.length()) {
                            maxStr = s.substring(left, right + 1);
                        }
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < chars.length - 1; i++) {
            if (i == 0) {
                if (maxStr.length() < 2) {
                    if (chars[0] == chars[1]) {
                        maxStr = chars[0] + "" + chars[1];
                    } else {
                        maxStr = chars[0] + "";
                    }
                }
                continue;
            }
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < chars.length) {
                if (chars[left] == chars[right]) {
                    if (right - left >= maxStr.length()) {
                        maxStr = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }
        return maxStr;
    }
}
