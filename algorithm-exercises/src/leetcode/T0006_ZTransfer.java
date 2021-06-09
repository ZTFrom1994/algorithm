package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/3/21 10:03 AM
 */
public class T0006_ZTransfer {

    public static void main(String[] args) {
        T0006_ZTransfer t = new T0006_ZTransfer();
        System.out.println(t.convert("kmvdfytyzoynugtxapjveyyptcwjqlvczsfeqafsodhkjahlqqgwofojjmtzzqbzigfajmsxpaibcrouivtycjknvdnxtqydzddiqyhharkejbztwutaddnaicxdvvgubmetklckfpoqqpjojeqoifrqiqwfocbpofkasomzdbpvsajefbsnhlfrcbwqgxhwctxwhjwnmlifmujtvdicpnttrrjzosvslursenhsaqzomihhopmfffywxjxnbsgonzitmqloilduvkblansfvqdubahcupshobccrqrzduvaewogmglhxqbyqkdlaxuqyztrrksuenwkmkryrefqvionstautxlrwelnqdjurfgdsxdjekzzspomlphemuvkagzqmimfpskhsnqwxrxrhlfucmyoivyiexyqhkxxfhgxuzvtqsmzfrtigtyopxztwxlgkifpplmlkjgddseilasrtriiqhdoeouqwzfnntyzcgefyjqkjideblptusibjerhgxvtsvsvexacisotbuxehoychifsowzuvwnouilyhlcpgtkjnhnwwnyfvfzkcygzxwnteyrnmvcsombdvqateaabgznkaujzqzswzjjlenfvbiywbasfbugjuutwqevgdncdylqeyyzzgaxharodmxoithejobprotumenselsftseduwrakoosjyysmzhfpccdg228", 228));
    }

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
