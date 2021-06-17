package leetcode;

import java.util.*;

/**
 * @author 张涛
 * @date 6/11/21 10:07 AM
 */
public class T0020_ValidBracket {

    public static void main(String[] args) {
        T0020_ValidBracket t = new T0020_ValidBracket();
        System.out.println(t.isValid("())("));
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if(chars.length == 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '(' || c=='{' || c=='['){
                stack.push(c);
            }else {
                // 利用两个括号ASCII码之间的差值不大于2,因为小括号，中括号，大括号，两两之间的ASCII码差值为1，2，2，如果差值小于2 肯定是对应的那个括号
                if(stack.empty() || Math.abs(c - stack.pop()) > 2){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
