package leetcode;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 张涛
 * @date 6/15/21 1:26 PM
 */
public class T0017_LetterCombinations {
    public static final Map<String, List<String>> map;

    static {
        map = new HashMap<>();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    public static void main(String[] args) {
        T0017_LetterCombinations t = new T0017_LetterCombinations();
        System.out.println(t.letterCombinations(""));
    }

    public List<String> letterCombinations(String digits) {
        return combination(digits, 0);
    }

    public List<String> combination(String digits, int currentIndex) {
        if (digits == "") {
            return new ArrayList<>();
        }
        if (currentIndex == digits.length() - 1) {
            return map.get("" + digits.charAt(currentIndex));
        }
        List<String> comb = combination(digits, currentIndex + 1);
        List<String> res = new ArrayList<>();
        List<String> list = map.get("" + digits.charAt(currentIndex));
        for (String s : list) {
            for (String a : comb) {
                res.add(s + a);
            }
        }
        return res;
    }
}
