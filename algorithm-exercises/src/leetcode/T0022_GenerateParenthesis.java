package leetcode;

import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @author 张涛
 * @date 6/17/21 4:40 PM
 */
public class T0022_GenerateParenthesis {

    public static void main(String[] args) {
        T0022_GenerateParenthesis t = new T0022_GenerateParenthesis();
        System.out.println(t.generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Arrays.asList("()");
        }
        List<String> list = generateParenthesis(n - 1);
        Set<String> set = new HashSet<>();
        for (String k : list) {
            set.add("()" + k);
            set.add(k + "()");
            set.add("(" + k + ")");
        }
        return new ArrayList<>(set);
    }
}
