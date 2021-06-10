package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/9/21 4:31 PM
 */
public class T0013_RomanToInt {

    public static void main(String[] args) {
        T0013_RomanToInt t = new T0013_RomanToInt();
        System.out.println(t.romanToInt("MCMXCIV"));
    }


    /**
     * 有2个思路：
     * 1.按从左到右的顺序处理罗马数字，正常情况当前数字是小于前一个数字的，如果当前数字比前一个大，则整体减去2倍的前一个数字
     * 2.按从左到右的顺序处理罗马数字，当前数字是大于后一个数字的则加本数字，如果当前数字比后一个大，则减去本数字
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int r = 0;
        for (int i = 0; i < chars.length; i++) {
            int k = getValue(chars[i]);
            if (i == chars.length - 1 || k >= getValue(chars[i + 1])) {
                r += k;
            } else {
                r -= k;
            }
        }
        return r;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
