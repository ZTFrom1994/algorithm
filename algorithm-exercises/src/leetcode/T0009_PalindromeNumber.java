package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/3/21 3:00 PM
 */
public class T0009_PalindromeNumber {

    public static void main(String[] args) {
        T0009_PalindromeNumber t = new T0009_PalindromeNumber();
        System.out.println(t.isPalindrome(22));
        System.out.println(t.isPalindrome(10));
        System.out.println(t.isPalindrome(121));
    }

    /**
     * 基本思路就是反转整数，然后比较是否和原来的数字相同，但是有个问题，反转后的数字可能会溢出，需要额外判断
     * 更优方案:从右向左反转数字，如果被反转的数字某一次循环中和未反转的数字相同 ，则是回文数，如果大于未反转的数字，则不是回文数
     * 边界条件：1.负数肯定不是回文数 2.单个数字肯定是回文数 3.被反转的数字只要一次为0的肯定不是回文数
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int unreversed = x;
        int reversed = 0;
        while (reversed < unreversed) {
            int k = unreversed % 10;
            reversed = reversed * 10 + k;
            if (reversed == 0) {
                return false;
            }
            unreversed = unreversed / 10;
            if (reversed == unreversed || reversed == unreversed / 10) {
                return true;
            }
        }
        return false;
    }
}
