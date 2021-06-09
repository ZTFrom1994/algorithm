package leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/9/21 2:23 PM
 */
public class T0014_LongestCommonPrefix {

    public static void main(String[] args) {
        T0014_LongestCommonPrefix t = new T0014_LongestCommonPrefix();
        System.out.println(t.longestCommonPrefix(new String[]{"123", "1234", "12"}));
    }

    /**
     * 思路：如果2个字符串的X,Y最长前缀是z，则另一个字符串K，与X、Y三者的最长前缀必不会超过z，只需要用z和K取最长公共前缀
     * 做法：第一个和第二个取公共前缀A，A再和第三个取公共最长前缀B，B和第四个取公共最长前缀C，依次取下去
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        int idx = 0;
        String p = strs[0];
        while (idx < strs.length - 1) {
            p = getCommonPrefix(p, strs[idx + 1]);
            if (p == "") {
                break;
            }
            idx++;
        }
        return p;
    }

    private String getCommonPrefix(String a, String b) {
        int l = Math.min(a.length(), b.length());
        int i = 0;
        while (i < l) {
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
            i++;
        }
        return a.substring(0, i);
    }
}
